package jabberpoint.swing.menus.items;

import jabberpoint.swing.SlideViewer;

import java.awt.*;

public class Previous extends MenuItem
{
    protected static final String TEXT = "Prev";

    public Previous(SlideViewer slideViewer) throws HeadlessException
    {
        super(TEXT);
        addActionListener(listener ->
        {
            slideViewer.presentation().previousSlide();
            slideViewer.repaint();
        });
    }
}