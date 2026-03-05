package adventureGame;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        // Create rooms
        Room startroom = new Room("Start Room", "You are at the beginning of your journey.");
        Room room1 = new Room("Room One", "This room is dimly lit and there's a strange noise.");
        Room room2 = new Room("Room Two", "A bright room with a math puzzle on the wall.");
        Room room3 = new Room("Room Three", "A room filled with books and equations.");
        Room finalroom = new Room("Final Room", "You see the exit ahead.");

        // Add exits to rooms
        startroom.addExit("Room 1", 1);
        room1.addExit("Room 2", 2);
        room1.addExit("Room 3", 3);
        room2.addExit("Room 3", 3);
        room3.addExit("Final Room", 4);

        // Create the player and game controller
        Player player1 = new Player();
        Room[] rooms = {startroom, room1, room2, room3, finalroom};
        GamCtrl gameController = new GamCtrl(player1, rooms);

        // Start the game
        gameController.newGame();
    }
}