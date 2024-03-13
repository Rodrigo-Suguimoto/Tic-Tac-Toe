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

        findWinner(ticTacToeMatrix);
    }

    public static String findWinner(char[][] ticTacToeMatrix) {
        int counterXFirstColumn = 0;
        int counterXSecondColumn = 0;
        int counterXThirdColumn = 0;

        int counterOFirstColumn = 0;
        int counterOSecondColumn = 0;
        int counterOThirdColumn = 0;

        for (int row = 0; row < ticTacToeMatrix.length; row++) {
            if (ticTacToeMatrix[row][0] == 'X') {
                counterXFirstColumn++;
            }
            if (ticTacToeMatrix[row][1] == 'X') {
                counterXSecondColumn++;
            }
            if (ticTacToeMatrix[row][2] == 'X') {
                counterXThirdColumn++;
            }

            if (ticTacToeMatrix[row][0] == 'O') {
                counterOFirstColumn++;
            }
            if (ticTacToeMatrix[row][1] == 'O') {
                counterOSecondColumn++;
            }
            if (ticTacToeMatrix[row][2] == 'O') {
                counterOThirdColumn++;
            }
        }

        System.out.println("Counter X");
        System.out.print(counterXFirstColumn + " " + counterXSecondColumn + " " + counterXThirdColumn);
        System.out.println();

        System.out.println("Counter O");
        System.out.print(counterOFirstColumn + " " + counterOSecondColumn + " " + counterOThirdColumn);

        return "winner";
    }
}