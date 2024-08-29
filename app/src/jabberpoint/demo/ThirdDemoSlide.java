package jabberpoint.demo;

import jabberpoint.core.Image;
import jabberpoint.core.Slide;

public class ThirdDemoSlide extends Slide
{
    public ThirdDemoSlide()
    {
        title("The third slide");
        append(1, "To open a new presentation,");
        append(2, "use File->Open from the menu.");
        append(1, "");
        append(1, "This is the end of the presentation.");
        append(new Image(1, "img/Jabberpoint.jpg"));
    }
}