package jabberpoint.core;

import java.util.ArrayList;

public class Presentation
{
	private final String title;

	private final ArrayList<Slide> slides;
	
	private int currentSlideIndex;

	public Presentation(String title, int initialSlideIndex)
	{
		this.title = title;
		currentSlideIndex = initialSlideIndex;
		slides = new ArrayList<>();
	}

	public int size()
	{
		return slides.size();
	}

	public ArrayList<Slide> slides()
	{
		return slides;
	}

	public String title()
	{
		return title;
	}

	public void currentSlideIndex(int index)
	{
		currentSlideIndex = index;
	}

	public void append(Slide slide)
	{
		slides.add(slide);
	}

	public void nextSlide()
	{
		if (currentSlideIndex < slides.size() - 1)
			currentSlideIndex(currentSlideIndex + 1);
	}

	public void previousSlide()
	{
		if (currentSlideIndex > 0)
			currentSlideIndex(currentSlideIndex - 1);
	}

	public Slide currentSlide()
	{
		return slide(currentSlideIndex);
	}

	public Slide slide(int index)
	{
		if (index < 0 || index >= size())
			return null;
		return slides.get(index);
	}

	public String slideIndicator()
	{
		return "Slide " + (currentSlideIndex + 1) + " of " + size();
	}
}