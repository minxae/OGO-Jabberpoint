package jabberpoint.swing.menus.items;

import jabberpoint.swing.SlideViewer;

import javax.swing.*;
import java.awt.*;

public class Goto extends MenuItem
{
    protected static final String TEXT = "Go to";

    protected static final String PAGE_NUMBER = "Page number?";

    public Goto(SlideViewer slideViewer)
    {
        super(TEXT);
        addActionListener(listener ->
        {
            var pageNumberStr = JOptionPane.showInputDialog(PAGE_NUMBER);
            var pageNumber = Integer.parseInt(pageNumberStr);
            slideViewer.presentation().currentSlideIndex(pageNumber - 1);
            slideViewer.repaint();
        });
    }
}