package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        int gridLimit = 3;
        System.out.println("---------"); // First divider

        for (int i = 0; i < userInput.length(); i++) {
            if (i == 0) { // Beginning of the grid
                System.out.print("| ");
                System.out.print(userInput.charAt(i) + " ");
            } else if (i % gridLimit == 0) { // When i % 3 == 0, break the line and add a '|'
                System.out.println();
                System.out.print("| ");
                System.out.print(userInput.charAt(i) + " ");
            } else {
                if (i == 2 || i == 5 | i == 8) { // If the i position is at the end of the line, add a '|' to signal the end of the line
                    System.out.print(userInput.charAt(i) + " |");
                } else {
                    System.out.print(userInput.charAt(i) + " ");
                }
            }
        }
        System.out.println();
        System.out.println("---------"); // Second divider
    }
}
