package jabberpoint.io.xml.readers;

import jabberpoint.core.Image;
import jabberpoint.core.Item;
import jabberpoint.core.Text;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ItemReader
{
    public ArrayList<Item> readItems(Element slideElement) throws UnknownItem
    {
        var itemNodes = slideElement.getElementsByTagName("item");
        var items = new ArrayList<Item>();
        var maxItems = itemNodes.getLength();
        for (var itemNumber = 0; itemNumber < maxItems; itemNumber++)
            items.add(getSlideItem(itemNodes, itemNumber));
        return items;
    }

    private Item getSlideItem(NodeList slideItems, int itemNumber) throws UnknownItem
    {
        var item = (Element) slideItems.item(itemNumber);
        var attributes = item.getAttributes();
        var levelText = attributes.getNamedItem("level").getTextContent();
        var level = getLevel(levelText);
        var type = attributes.getNamedItem("kind").getTextContent();
        return getSlideByType(type, item, level);
    }

    private int getLevel(String levelText)
    {
        try
        {
            return Integer.parseInt(levelText);
        }
        catch (Exception e)
        {
            return 1;
        }
    }

    private Item getSlideByType(String type, Element item, int level) throws UnknownItem
    {
        return switch (type)
        {
            case "text" -> new Text(level, item.getTextContent());
            case "image" -> new Image(level, item.getTextContent());
            default -> throw new UnknownItem(type);
        };
    }

    public static class UnknownItem extends Throwable
    {
        public UnknownItem(String type)
        {
            super("Unknown element type:" + type);
        }
    }
}