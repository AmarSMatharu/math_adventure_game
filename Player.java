package adventureGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public int lives;
    public List<String> inventory;
    public int location;

    public Player() {
        this.lives = 3;
        this.inventory = new ArrayList<>();
        this.location = 0; 
    }

    public void move(int newLocation) {
        this.location = newLocation;
    }

    public void addItem(String item) {
        this.inventory.add(item);
    }

    public List<String> getInventory() {
        return inventory;
    }

    public int getLocation() {
        return location;
    }
}