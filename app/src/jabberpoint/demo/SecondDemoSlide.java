package jabberpoint.demo;

import jabberpoint.core.Slide;

public class SecondDemoSlide extends Slide
{
    public SecondDemoSlide()
    {
        title("Demonstration of levels and styles");
        append(1, "Level 1");
        append(2, "Level 2");
        append(1, "Again level 1");
        append(1, "Level 1 has style number 1");
        append(2, "Level 2 has style number 2");
        append(3, "This is how level 3 looks like");
        append(4, "And this is level 4");
    }
}