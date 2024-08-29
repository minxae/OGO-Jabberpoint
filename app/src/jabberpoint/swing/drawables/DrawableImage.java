package jabberpoint.swing.drawables;

import jabberpoint.core.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class DrawableImage extends Image implements DrawableItem
{
	private final Graphics2D graphics;

	private final ImageObserver observer;
	
	private final float scale;

	private BufferedImage image;

	public DrawableImage(Image image, Graphics2D graphics,ImageObserver observer, float scale)
	{
		super(image.level(), image.path());
		this.graphics = graphics;
		this.scale = scale;
		this.observer = observer;
	}

	public int height() throws DrawFailed
	{
		tryToReadBufferedImage(path());
		return (int)(leading() * scale) + scaledHeight(scale);
	}

	public void draw(int x, int y) throws DrawFailed
	{
		tryToReadBufferedImage(path());
		var scaledIndent = scaledIndent(scale);
		var width = scaledIndent + x;
		var height = scaledIndent + y;
		graphics.drawImage(image, width, height, scaledWidth(scale), scaledHeight(scale), observer);
	}

	private void tryToReadBufferedImage(String imageName) throws DrawFailed
	{
		try
		{
			image = ImageIO.read(new File(imageName));
		}
		catch (IOException e)
		{
			throw new ImageNotFound("File " + imageName + " not found");
		}
	}

	private int scaledIndent(float scale)
	{
		return (int) (leading() * scale);
	}

	private int scaledHeight(float scale)
	{
		return (int)(image.getHeight(observer)*scale);
	}

	private int scaledWidth(float scale)
	{
		return (int)(image.getWidth(observer)*scale);
	}

	private int leading()
	{
		return level() == 0 ? 20 : 10;
	}

	public static class ImageNotFound extends DrawFailed
	{
		public ImageNotFound(String message)
		{
			super(message);
		}
	}
}