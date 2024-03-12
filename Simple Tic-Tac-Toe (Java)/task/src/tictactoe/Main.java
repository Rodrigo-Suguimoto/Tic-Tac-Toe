package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        final int GRID_LIMIT = 9;
        char[][] ticTacToeMatrix = new char[3][3];

        System.out.println("---------"); // Print first divider

        for (int i = 0; i < GRID_LIMIT; i += 3) {
            System.out.printf("| %c %c %c |\n", userInput.charAt(i), userInput.charAt(i+1), userInput.charAt(i+2));
        }

        System.out.println("---------"); // Print second divider

        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) {
                if (i == 0) {
                    ticTacToeMatrix[i][j] = userInput.charAt(i + j);
                } else if (i == 1) {
                    ticTacToeMatrix[i][j] = userInput.charAt(j + 3);
                } else {
                    ticTacToeMatrix[i][j] = userInput.charAt(j + 6);
                }
            }
        }
    }
}