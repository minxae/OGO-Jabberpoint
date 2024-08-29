package jabberpoint.swing;

import jabberpoint.core.Presentation;
import jabberpoint.swing.drawables.DrawableItem;
import jabberpoint.swing.drawables.DrawableSlide;

import java.awt.*;
import java.io.Serial;
import javax.swing.JComponent;

public class SlideViewer extends JComponent
{
	private Presentation presentation;

	private final Font labelFont;
	
	@Serial
	private static final long serialVersionUID = 227L;

	private static final Color BACKGROUND_COLOR = Color.white;

	private static final Color COLOR = Color.black;

	private static final String FONT_NAME = "Dialog";

	private static final int FONT_STYLE = Font.BOLD;

	private static final int FONT_HEIGHT = 10;

	private static final int X_POSITION = 1100;
	
	private static final int Y_POSITION = 20;

	public SlideViewer()
	{
		setBackground(BACKGROUND_COLOR);
		this.presentation = new Presentation("", 0);
		this.labelFont = new Font(FONT_NAME, FONT_STYLE, FONT_HEIGHT);
	}

	public void presentation(Presentation presentation)
	{
		this.presentation = presentation;
	}

	public Presentation presentation()
	{
		return presentation;
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(DrawableSlide.WIDTH, DrawableSlide.HEIGHT);
	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		if (presentation.currentSlide() == null)
			return;

		graphics.setColor(BACKGROUND_COLOR);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		graphics.setFont(labelFont);
		graphics.setColor(COLOR);
		graphics.drawString(presentation.slideIndicator(), X_POSITION, Y_POSITION);
		tryToDrawSlide((Graphics2D) graphics);
	}

	private void tryToDrawSlide(Graphics2D graphics)
	{
		try
		{
			drawableSlide(graphics).draw(drawingArea());
		}
		catch (DrawableItem.DrawFailed e)
		{
			e.printStackTrace();
		}
	}

	private DrawableSlide drawableSlide(Graphics2D graphics)
	{
		return new DrawableSlide(presentation.currentSlide(), graphics, this);
	}

	private Rectangle drawingArea()
	{
		return new Rectangle(0, Y_POSITION, getWidth(), (getHeight() - Y_POSITION));
	}
}