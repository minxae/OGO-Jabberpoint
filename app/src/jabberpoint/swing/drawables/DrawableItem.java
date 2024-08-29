package jabberpoint.swing.drawables;

public interface DrawableItem
{
    int height() throws DrawFailed;
    void draw(int x, int y) throws DrawFailed;

    class DrawFailed extends Exception
    {
        public DrawFailed(String message)
        {
            super(message);
        }
    }
}