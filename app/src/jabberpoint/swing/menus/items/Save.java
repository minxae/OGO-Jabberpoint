package jabberpoint.swing.menus.items;

import jabberpoint.io.xml.writers.ItemWriter;
import jabberpoint.io.xml.writers.PresentationWriter;
import jabberpoint.io.xml.writers.SlideWriter;
import jabberpoint.swing.MainFrame;
import jabberpoint.swing.SlideViewer;

import javax.swing.*;
import java.awt.*;

public class Save extends MenuItem
{
    protected static final String TEXT = "Save";
    protected static final String SAVED_FILE = "presentations/savedPresentation.xml";
    protected static final String IO_EXCEPTION = "IO Exception: ";
    protected static final String ERROR_MESSAGE = "Save Error";

    public Save(MainFrame parent, SlideViewer drawer)
    {
        super(TEXT, new MenuShortcut(TEXT.charAt(0)));

        addActionListener(listener ->
        {
            try
            {
                new PresentationWriter(new SlideWriter(new ItemWriter())).write(SAVED_FILE, drawer.presentation());
            }
            catch (PresentationWriter.WritingFailed e)
            {
                JOptionPane.showMessageDialog(parent, IO_EXCEPTION + e, ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}