package jabberpoint.swing.drawables;

import jabberpoint.core.Image;
import jabberpoint.core.Item;
import jabberpoint.core.Slide;
import jabberpoint.core.Text;

import java.awt.*;
import java.awt.image.ImageObserver;

public class DrawableSlide extends Slide
{
    private final Graphics2D graphics;

    private final ImageObserver observer;

    public final static int WIDTH = 1200;
    
    public final static int HEIGHT = 800;

    public DrawableSlide(Slide slide, Graphics2D graphics, ImageObserver observer)
    {
        super(slide.title(), slide.getItems());
        this.graphics = graphics;
        this.observer = observer;
    }

    public void draw(Rectangle area) throws DrawableItem.DrawFailed
    {
        var height = area.y;
        height += drawSlideHeader(area, height);
        drawItems(area, height);
    }

    private int drawSlideHeader(Rectangle area, int y) throws DrawableItem.DrawFailed
    {
        var slideItem = new DrawableText(graphics, new Text(0, title()), WIDTH, getScale(area));
        slideItem.draw(area.x, y);
        return slideItem.height();
    }

    private void drawItems(Rectangle area, int height) throws DrawableItem.DrawFailed
    {
        for (var item : getItems())
            height += drawItem(item, area, height);
    }

    private int drawItem(Item item, Rectangle area, int y) throws DrawableItem.DrawFailed
    {
        var drawableItem = drawableItem(item, area);
        drawableItem.draw(area.x, y);
        return drawableItem.height();
    }

    private DrawableItem drawableItem(Item item, Rectangle area) throws DrawableItem.DrawFailed
    {
        if (item instanceof Text)
            return new DrawableText(graphics, (Text)item, WIDTH, getScale(area));
        else
            return new DrawableImage((Image)item, graphics, observer, getScale(area));
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
    }
}