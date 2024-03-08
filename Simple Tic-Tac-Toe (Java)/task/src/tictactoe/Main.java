package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        final int GRID_LIMIT = 9;

        System.out.println("---------"); // Print first divider

        for (int i = 0; i < GRID_LIMIT; i += 3) {
            System.out.printf("| %c %c %c |\n", userInput.charAt(i), userInput.charAt(i+1), userInput.charAt(i+2));
        }

        System.out.println("---------"); // Print second divider
    }
}