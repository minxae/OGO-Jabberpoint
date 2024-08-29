package jabberpoint.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyListener extends KeyAdapter
{
	private final SlideViewer slideViewer;

	public KeyListener(SlideViewer slideViewer)
	{
		this.slideViewer = slideViewer;
	}

	public void keyPressed(KeyEvent keyEvent)
	{
		switch(keyEvent.getKeyCode())
		{
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				slideViewer.presentation().nextSlide();
				slideViewer.repaint();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				slideViewer.presentation().previousSlide();
				slideViewer.repaint();
				break;
			case 'q':
			case 'Q':
				System.exit(0);
			default:
				break;
		}
	}
}