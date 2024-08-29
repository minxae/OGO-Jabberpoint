package jabberpoint.swing.menus.items;

import jabberpoint.swing.AboutBox;
import jabberpoint.swing.MainFrame;

import java.awt.*;

public class About extends MenuItem
{
    protected static final String TEXT = "About";

    public About(MainFrame parent)
    {
        super(TEXT, new MenuShortcut(TEXT.charAt(0)));
        addActionListener(actionEvent -> AboutBox.show(parent));
    }
}