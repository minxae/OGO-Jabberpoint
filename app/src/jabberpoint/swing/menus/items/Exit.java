package jabberpoint.swing.menus.items;

import java.awt.*;

public class Exit extends MenuItem
{
    protected static final String TEXT = "Exit";

    public Exit() throws HeadlessException
    {
        super(TEXT, new MenuShortcut(TEXT.charAt(0)));
        addActionListener(actionEvent -> System.exit(0));
    }
}