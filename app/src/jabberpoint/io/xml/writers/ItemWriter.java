package jabberpoint.io.xml.writers;

import jabberpoint.core.Image;
import jabberpoint.core.Item;
import jabberpoint.core.Slide;
import jabberpoint.core.Text;

public class ItemWriter
{
    private StringBuilder stringBuilder;

    public String write(Slide slide)
    {
        stringBuilder = new StringBuilder();
        for (var item : slide.getItems())
            slideItem(item);
        return stringBuilder.toString();
    }

    private void slideItem(Item item)
    {
        stringBuilder.append("<item kind=");
        writeSlideItemByType(item);
        stringBuilder.append("</item>").append("\n");
    }

    private void writeSlideItemByType(Item item)
    {
        if (item instanceof Text)
            writeText(item);
        else if (item instanceof Image)
            writeImage(item);
    }

    private void writeText(Item item)
    {
        stringBuilder.append("\"text\" level=\"");
        stringBuilder.append(item.level()).append("\">");
        stringBuilder.append(((Text) item).text());
    }

    private void writeImage(Item item)
    {
        stringBuilder.append("\"image\" level=\"");
        stringBuilder.append(item.level()).append("\">");
        stringBuilder.append(((Image) item).path());
    }
}