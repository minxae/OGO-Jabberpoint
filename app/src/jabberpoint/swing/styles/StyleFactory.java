package jabberpoint.swing.styles;

import jabberpoint.swing.drawables.DrawableItem;

public class StyleFactory
{
    public static Style create(int level) throws LevelNotImplemented
    {
        return switch (level)
        {
            case 0 -> new Largest();
            case 1 -> new Large();
            case 2 -> new Medium();
            case 3 -> new Small();
            case 4 -> new Smallest();
            default -> throw new LevelNotImplemented(level);
        };
    }

    public static class LevelNotImplemented extends DrawableItem.DrawFailed
    {
        public LevelNotImplemented(int level)
        {
            super("Level: " + level);
        }
    }
}