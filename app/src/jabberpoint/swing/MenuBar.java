package jabberpoint.swing;

import jabberpoint.swing.menus.FileMenu;
import jabberpoint.swing.menus.HelpMenu;
import jabberpoint.swing.menus.ViewMenu;

public class MenuBar extends java.awt.MenuBar
{
    public MenuBar(MainFrame parent, SlideViewer drawer)
    {
        add(new FileMenu(parent, drawer));
        add(new ViewMenu(drawer));
        setHelpMenu(new HelpMenu(parent));
    }
}