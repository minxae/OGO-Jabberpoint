package jabberpoint.swing.menus;

import jabberpoint.swing.MainFrame;
import jabberpoint.swing.SlideViewer;
import jabberpoint.swing.menus.items.Clear;
import jabberpoint.swing.menus.items.Exit;
import jabberpoint.swing.menus.items.Open;
import jabberpoint.swing.menus.items.Save;

import java.awt.*;

public class FileMenu extends Menu
{
    protected static final String FILE = "File";

    public FileMenu(MainFrame parent, SlideViewer drawer)
    {
        super(FILE);
        add(new Open(parent, drawer));
        add(new Clear(parent, drawer));
        add(new Save(parent, drawer));
        addSeparator();
        add(new Exit());
    }
}