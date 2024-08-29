package jabberpoint.core;

public abstract class Item
{
	private final int level;

	public Item(int level)
	{
		this.level = level;
	}

	public int level()
	{
		return level;
	}
}