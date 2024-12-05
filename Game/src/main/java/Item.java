import java.util.List;
import java.util.ArrayList;

// Define types of items that share actions / properties
enum ItemType {
    Weapon,
    Healing,
    Key,
    Animal,
    Plant,
    Item;

    public static ItemType toType(String s) {
        switch (s) {
            case "Weapon":
                return ItemType.Weapon;
            case "Healing":
                return ItemType.Healing;
            case "Key":
                return ItemType.Key;
            case "Animal":
                return ItemType.Animal;
            case "Plant":
                return ItemType.Plant;
            default:
                return ItemType.Item;
        }
    }
}

// Object defining how general items work in your game
// All other item classes should inherit this class
public class Item {
    String name;
    ArrayList<ItemType> types = new ArrayList<ItemType>();
    String desc;
    String use;
    String action;
    Boolean used = false;
    protected GameState gameState;  

    Item(String n, List<String> ts, String d, String u, String a) {
        name = n;
        for (String ty : ts) types.add(ItemType.valueOf(ty));
        desc = d;
        use = u;
        action = a;
    }

    public String inspect() {
        String alltypes = "";
        for (ItemType t: types) alltypes += t.name() + " ";
        String message = "This is a " + this.name + ", a kind of " + alltypes + ". Description: " + this.desc;
        return message;
    }

    public void use() {
        used = true;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
