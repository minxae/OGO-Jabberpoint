package jabberpoint.demo;

import jabberpoint.core.Presentation;

public class DemoPresentation extends Presentation
{
	public DemoPresentation()
	{
		super("Demo Presentation", 0);
		append(new FirstDemoSlide());
		append(new SecondDemoSlide());
		append(new ThirdDemoSlide());
	}
}