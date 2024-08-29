package jabberpoint.swing.menus;

import jabberpoint.swing.SlideViewer;
import jabberpoint.swing.menus.items.Goto;
import jabberpoint.swing.menus.items.Next;
import jabberpoint.swing.menus.items.Previous;

import java.awt.*;

public class ViewMenu extends Menu
{
    protected static final String TEXT = "View";

    public ViewMenu(SlideViewer drawer)
    {
        super(TEXT);
        add(new Next(drawer));
        add(new Previous(drawer));
        add(new Goto(drawer));
    }
}