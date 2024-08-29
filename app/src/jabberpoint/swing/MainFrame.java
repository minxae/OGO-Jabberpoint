package jabberpoint.swing;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.Serial;
import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	@Serial
	private static final long serialVersionUID = 3227L;
	
	public MainFrame(SlideViewer viewer)
	{
		addKeyListener(new KeyListener(viewer));
		setMenuBar(new MenuBar(this, viewer));
		getContentPane().add(viewer);
		setSize(viewer.getPreferredSize());
		setVisible(true);
		viewer.repaint();

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}