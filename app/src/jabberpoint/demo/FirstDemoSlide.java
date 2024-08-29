package jabberpoint.demo;

import jabberpoint.core.Slide;

public class FirstDemoSlide extends Slide
{
    public FirstDemoSlide()
    {
        title("JabberPoint");
        append(1, "The Java presentation tool");
        append(2, "Copyright (c) 1996-2000: Ian Darwin");
        append(2, "Copyright (c) 2000-now:");
        append(2, "Gert Florijn and Sylvia Stuurman");
        append(4, "Calling Jabberpoint without a filename");
        append(4, "will show this presentation");
        append(1, "Navigate:");
        append(3, "Next slide: PgDn or Enter");
        append(3, "Previous slide: PgUp or up-arrow");
        append(3, "Quit: q or Q");
    }
}