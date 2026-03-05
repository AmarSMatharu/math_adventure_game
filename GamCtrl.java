package adventureGame;

import java.util.Scanner;

public class GamCtrl {
    private Player player;
    private Room[] rooms;
    private boolean gameOver;

    public GamCtrl(Player player, Room[] rooms) {
        this.player = player;
        this.rooms = rooms;
        this.gameOver = false;
    }

    public void newGame() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You will face several math challenges. Solve them to proceed!");

        while (!gameOver && player.lives > 0) {
            Room currentRoom = rooms[player.getLocation()];
            currentRoom.display();

            System.out.println("Choose an action: navigate, use item, attempt, exit");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "navigate":
                    movePlayer(scanner);
                    break;
                case "attempt":
                    mathChallenge(scanner);
                    break;
                case "exit":
                    gameOver = true;
                    System.out.println("GAME OVER. Try again next time!");
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
                    break;
            }
        }

        if (player.lives == 0) {
            System.out.println("You ran out of lives. GAME OVER.");
        }

        scanner.close();
    }

    private void movePlayer(Scanner scanner) {
        Room currentRoom = rooms[player.getLocation()];
        System.out.println("Available exits: " + currentRoom.getExits().keySet());
        System.out.println("Where do you want to go?");
        String direction = scanner.nextLine();
        int nextRoom = currentRoom.getExit(direction);

        if (nextRoom != -1) {
            player.move(nextRoom);
            System.out.println("You move to " + rooms[nextRoom].getName());
        } else {
            System.out.println("Invalid exit. Try again.");
        }
    }

    private void mathChallenge(Scanner scanner) throws InterruptedException {
        // First Level: Addition
        int attempts = 0;
        int questionAmount = (int) (Math.random() * (5) + 5);

        while (attempts < questionAmount && player.lives > 0) {
            int firstNum = (int) (Math.random() * 50);
            int secondNum = (int) (Math.random() * 50);

            System.out.println("What is " + firstNum + " + " + secondNum + "?");
            int answer = scanner.nextInt();

            if (answer == firstNum + secondNum) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. You lose a life.");
                player.lives--;
            }

            attempts++;
            Thread.sleep(500);
        }

        // Proceed to next level if not dead
        if (player.lives > 0) {
            System.out.println("Level 1 complete. Moving to next challenge.");
            multiplicationChallenge(scanner);
        }
    }

    private void multiplicationChallenge(Scanner scanner) throws InterruptedException {
        // Second Level: Multiplication
        int attempts = 0;
        int questionAmount = (int) (Math.random() * (5) + 5);

        while (attempts < questionAmount && player.lives > 0) {
            int firstNum = (int) (Math.random() * 12);
            int secondNum = (int) (Math.random() * 12);

            System.out.println("What is " + firstNum + " * " + secondNum + "?");
            int answer = scanner.nextInt();

            if (answer == firstNum * secondNum) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. You lose a life.");
                player.lives--;
            }

            attempts++;
            Thread.sleep(500);
        }

        // Proceed to final level if not dead
        if (player.lives > 0) {
            System.out.println("Level 2 complete. Moving to final challenge.");
            exponentChallenge(scanner);
        }
    }

    private void exponentChallenge(Scanner scanner) throws InterruptedException {
        // Third Level: Exponents
        int attempts = 0;
        int questionAmount = (int) (Math.random() * (5) + 5);

        while (attempts < questionAmount && player.lives > 0) {
            int base = (int) (Math.random() * 10);
            int power = 2;

            System.out.println("What is " + base + " ^ " + power + "?");
            int answer = scanner.nextInt();

            if (answer == (int) Math.pow(base, power)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. You lose a life.");
                player.lives--;
            }

            attempts++;
            Thread.sleep(500);
        }

        if (player.lives > 0) {
            System.out.println("Congratulations! You've completed the game.");
        } else {
            System.out.println("You ran out of lives. GAME OVER.");
        }
    }
}