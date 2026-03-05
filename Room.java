package adventureGame;

import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private HashMap<String, Integer> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, int roomNumber) {
        exits.put(direction, roomNumber);
    }

    public HashMap<String, Integer> getExits() {
        return exits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getExit(String direction) {
        return exits.getOrDefault(direction, -1);
    }

    public void display() {
        System.out.println("This is the " + name + ". " + description);
        System.out.println("Exits: " + exits.keySet());
    }
}