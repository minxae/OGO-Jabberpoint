package jabberpoint.io.xml.readers;

import jabberpoint.core.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class SlideReader
{
    private final ItemReader itemReader;

    public SlideReader(ItemReader itemReader)
    {
        this.itemReader = itemReader;
    }

    public ArrayList<Slide> readSlides(Element doc) throws LoadingFailed
    {
        var nodeSlides = doc.getElementsByTagName("slide");
        var slides = new ArrayList<Slide>();
        for (var slideNumber = 0; slideNumber < nodeSlides.getLength(); slideNumber++)
            slides.add(getSlide(nodeSlides, slideNumber));
        return slides;
    }

    private Slide getSlide(NodeList slides, int slideNumber) throws LoadingFailed
    {
        try
        {
            var slideElement = (Element) slides.item(slideNumber);
            var slide = new Slide();
            slide.title(getTitle(slideElement));
            for (var item : itemReader.readItems(slideElement))
                slide.append(item);
            return slide;
        }
        catch (ItemReader.UnknownItem e)
        {
            throw new LoadingFailed(e.getMessage());
        }
    }

    private String getTitle(Element element)
    {
        var titles = element.getElementsByTagName("title");
        return titles.item(0).getTextContent();
    }

    public static class LoadingFailed extends Throwable
    {
        public LoadingFailed(String message)
        {
            super(message);
        }
    }
}