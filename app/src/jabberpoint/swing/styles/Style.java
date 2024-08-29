package jabberpoint.swing.styles;

import java.awt.Color;
import java.awt.Font;


public abstract class Style
{
	public final int indent;

	public final Color color;

	public final Font font;

	public final int fontSize;
	
	public final int leading;

	private static final String FONT_NAME = "Helvetica";

	public Style(int indent, Color color, int points, int leading)
	{
		this.indent = indent;
		this.color = color;
		this.font = new Font(FONT_NAME, Font.BOLD, fontSize=points);
		this.leading = leading;
	}

	public String toString()
	{
		return "["+ indent + "," + color + "; " + fontSize + " on " + leading +"]";
	}
}