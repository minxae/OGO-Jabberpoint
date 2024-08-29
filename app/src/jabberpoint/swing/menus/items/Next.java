package jabberpoint.swing.menus.items;

import jabberpoint.swing.SlideViewer;

import java.awt.*;

public class Next extends MenuItem
{
    protected static final String TEXT = "Next";

    public Next(SlideViewer slideViewer) throws HeadlessException
    {
        super(TEXT);
        addActionListener(actionEvent ->
        {
            slideViewer.presentation().nextSlide();
            slideViewer.repaint();
        });
    }
}