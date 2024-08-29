package jabberpoint.swing.drawables;

import jabberpoint.core.Text;
import jabberpoint.swing.styles.Style;
import jabberpoint.swing.styles.StyleFactory;

import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

public class DrawableText extends Text implements DrawableItem
{
    private final Graphics2D graphics;
    private final Style style;
    private final int width;
    private final float scale;

    public DrawableText(Graphics2D graphics, Text text, int width, float scale) throws DrawableItem.DrawFailed
    {
        super(text.level(), text.text());

        style = StyleFactory.create(text.level());

        this.graphics = graphics;
        this.width = width;
        this.scale = scale;
    }

    public int height()
    {
        var layouts = getLayouts(text());
        var height = (int) (style.leading * scale);

        for (var layout : layouts)
            height += layout.getBounds().getHeight() + layout.getLeading() + layout.getDescent();

        return height;
    }

    public void draw(int x, int y)
    {
        var text = text();
        if (text == null)
            return;

        var layouts = getLayouts(text);
        var yAxis = y + (int) (style.leading * scale);

        graphics.setColor(style.color);

        for (var layout : layouts)
            yAxis = drawLayout(x, yAxis, layout);
    }

    private int drawLayout(int x, int yAxis, TextLayout layout)
    {
        yAxis += layout.getAscent();
        layout.draw(graphics, x + (int)(style.indent * scale), yAxis);
        yAxis += layout.getDescent();

        return yAxis;
    }

    private List<TextLayout> getLayouts(String text)
    {
        var layouts = new ArrayList<TextLayout>();
        var attrStr = getAttributedString(text);
        var measurer = new LineBreakMeasurer(attrStr.getIterator(), graphics.getFontRenderContext());
        var wrappingWidth = (width - style.indent) * scale;

        while (measurer.getPosition() < text.length())
            layouts.add(measurer.nextLayout(wrappingWidth));

        return layouts;
    }

    private AttributedString getAttributedString(String text)
    {
        if (text.isEmpty())
            return new AttributedString(" ");

        var attrStr = new AttributedString(text);
        attrStr.addAttribute(TextAttribute.FONT, getFont(scale), 0, text.length());
        return attrStr;
    }

    private Font getFont(float scale)
    {
        return style.font.deriveFont(style.fontSize * scale);
    }
}