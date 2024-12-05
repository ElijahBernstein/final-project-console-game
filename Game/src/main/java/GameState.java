import java.util.*;

// Tracks global game state
// Useful for implementing state-based behavior (ex: see something new on second visit to room)

public class GameState {
    HashMap<Room, Boolean> visited = new HashMap<Room, Boolean>();
    String name;
    boolean finished;
    Room room;
    List<Item> inventory = new ArrayList<Item>();
    Map<String, Room> rooms; // global list of rooms
    Map<String, Item> items; // global list of known items

    Map<String, Boolean> roomStates = new HashMap<>();  // track room states like "cleaned"
    int playerHealth = 100;  // for weapon damage
    Set<String> unlockedDoors = new HashSet<>();

    // update state and check for winning condition
    public String update() {
        if (
            room.contents.contains(items.get("poison frog")) &&
            room.contents.contains(items.get("fear")) &&
            room.name.equals("Locked Room")){
            finished = true;
            String finaltext =  """
                                Your standing alone in this scary room. for some reason you cant stop shaking. Your filled with fear. To top it off you placed a posion frog in the middle of the room and you have a intense phobia of frogs so you pass out. Your eyes open, you look around and realize you have woken up in a Subway! Eat fresh!
                                """;
            return finaltext;
        }
        return "";
    }

    public GameState(String name) {
        this.name = name;
        finished = false;
        LoadYAML yl = new LoadYAML(this);
        rooms = yl.rooms;
        items = yl.items;
        room = rooms.get("Starting Room");
        visited.put(room, true);
        inventory.add(items.get("book"));
    }
}
