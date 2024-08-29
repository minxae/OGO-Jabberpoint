package jabberpoint.swing.menus.items;

import jabberpoint.core.Presentation;
import jabberpoint.swing.MainFrame;
import jabberpoint.swing.SlideViewer;

import java.awt.*;

public class Clear extends MenuItem
{
    protected static final String TEXT = "New";

    public Clear(MainFrame parent, SlideViewer drawer)
    {
        super(TEXT, new MenuShortcut(TEXT.charAt(0)));

        addActionListener(actionEvent ->
        {
            drawer.presentation(new Presentation("", 0));
            parent.repaint();
        });
    }
}