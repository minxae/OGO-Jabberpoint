package jabberpoint.swing.menus.items;

import jabberpoint.io.xml.readers.ItemReader;
import jabberpoint.io.xml.readers.PresentationReader;
import jabberpoint.io.xml.readers.SlideReader;
import jabberpoint.swing.MainFrame;
import jabberpoint.swing.SlideViewer;

import javax.swing.*;
import java.awt.*;

public class Open extends MenuItem
{
    private static final String TEXT = "Open";
    private static final String TEST_FILE = "presentations/testPresentation.xml";
    private static final String IO_EXCEPTION = "IO Exception: ";
    private static final String LOAD_ERROR = "Load Error";

    public Open(MainFrame parent, SlideViewer drawer) throws HeadlessException
    {
        super(TEXT, new MenuShortcut(TEXT.charAt(0)));

        addActionListener(listener ->
        {
            try
            {
                drawer.presentation(new PresentationReader(new SlideReader(new ItemReader())).read(TEST_FILE));
            }
            catch (PresentationReader.LoadingFailed exc)
            {
                JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exc, LOAD_ERROR, JOptionPane.ERROR_MESSAGE);
            }

            drawer.repaint();
            parent.repaint();
        });
    }
}