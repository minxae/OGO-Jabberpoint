package jabberpoint.io.xml.writers;

import jabberpoint.core.*;

public class SlideWriter
{
    private final ItemWriter itemWriter;

    private StringBuilder stringBuilder;

    public SlideWriter(ItemWriter itemWriter)
    {
        this.itemWriter = itemWriter;
    }

    public String write(Presentation presentation)
    {
        stringBuilder = new StringBuilder();
        for (var slide : presentation.slides())
            writeSlide(slide);
        return stringBuilder.toString();
    }

    private void writeSlide(Slide slide)
    {
        stringBuilder.append("<slide>").append("\n");
        stringBuilder.append("<title>").append(slide.title()).append("</title>").append("\n");
        stringBuilder.append(itemWriter.write(slide));
        stringBuilder.append("</slide>").append("\n");
    }
}