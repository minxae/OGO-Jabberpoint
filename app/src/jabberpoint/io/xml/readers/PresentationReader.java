package jabberpoint.io.xml.readers;

import jabberpoint.core.*;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class PresentationReader
{
    private final SlideReader slideReader;

    public PresentationReader(SlideReader slideReader)
    {
        this.slideReader = slideReader;
    }

    public Presentation read(String path) throws LoadingFailed
    {
        try
        {
            var builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            var document = builder.parse(new File(path));;
            var doc = document.getDocumentElement();
            var presentation = new Presentation(getTitle(doc), 0);
            for (var slide : slideReader.readSlides(doc))
                presentation.append(slide);
            return presentation;
        }
        catch (SlideReader.LoadingFailed | ParserConfigurationException | SAXException | IOException e)
        {
            throw new LoadingFailed(e.getMessage());
        }
    }

    private String getTitle(Element element)
    {
        var titles = element.getElementsByTagName("showtitle");
        return titles.item(0).getTextContent();
    }

    public static class LoadingFailed extends Exception
    {
        public LoadingFailed(String message)
        {
            super(message);
        }
    }
}