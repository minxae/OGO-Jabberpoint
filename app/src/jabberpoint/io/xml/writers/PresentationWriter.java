package jabberpoint.io.xml.writers;

import jabberpoint.core.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PresentationWriter
{
    private final SlideWriter slideWriter;

    public PresentationWriter(SlideWriter slideWriter)
    {
        this.slideWriter = slideWriter;
    }

    public void write(String path, Presentation presentation) throws WritingFailed
    {
        try
        {
            var printWriter = new PrintWriter(new FileWriter(path));
            printWriter.println("<?xml version=\"1.0\"?>");
            printWriter.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
            printWriter.println("<presentation>");
            printWriter.print("<showtitle>");
            printWriter.print(presentation.title());
            printWriter.println("</showtitle>");
            printWriter.print(slideWriter.write(presentation));
            printWriter.println("</presentation>");
            printWriter.close();
        }
        catch (IOException e)
        {
            throw new WritingFailed(e.getMessage());
        }
    }

    public static class WritingFailed extends Exception
    {
        public WritingFailed(String message)
        {
            super(message);
        }
    }
}