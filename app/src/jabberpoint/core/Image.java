package jabberpoint.core;

public class Image extends Item
{
    protected final String path;

    public Image(int level, String path)
    {
        super(level);
        this.path = path;
    }

    public String path()
    {
        return path;
    }

    public String toString()
    {
        return "Jabberpoint.Image["+level()+","+path+"]";
    }
}