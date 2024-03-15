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

        if (!isNumberOfXAndOValid(ticTacToeMatrix)) {
            System.out.println("Impossible");
        } else {
            findWinner(ticTacToeMatrix);
        }
    }

    public static void findWinner(char[][] ticTacToeMatrix) {
        int counterXFirstColumn = 0;
        int counterXSecondColumn = 0;
        int counterXThirdColumn = 0;

        int counterOFirstColumn = 0;
        int counterOSecondColumn = 0;
        int counterOThirdColumn = 0;

        int counterXFirstRow = 0;
        int counterXSecondRow = 0;
        int counterXThirdRow = 0;

        int counterOFirstRow = 0;
        int counterOSecondRow = 0;
        int counterOThirdRow = 0;

        final int GRID_LIMIT = 3;
        for (int i = 0; i < GRID_LIMIT; i++) {

            // CHECK WINNERS BY COLUMN
            // CHECK 'X'
            if (ticTacToeMatrix[i][0] == 'X') {
                counterXFirstColumn++;
            }
            if (ticTacToeMatrix[i][1] == 'X') {
                counterXSecondColumn++;
            }
            if (ticTacToeMatrix[i][2] == 'X') {
                counterXThirdColumn++;
            }

            // CHECK 'O'
            if (ticTacToeMatrix[i][0] == 'O') {
                counterOFirstColumn++;
            }
            if (ticTacToeMatrix[i][1] == 'O') {
                counterOSecondColumn++;
            }
            if (ticTacToeMatrix[i][2] == 'O') {
                counterOThirdColumn++;
            }

            // CHECK WINNERS BY ROW
            // CHECK 'X'
            if (ticTacToeMatrix[0][i] == 'X') {
                counterXFirstRow++;
            }
            if (ticTacToeMatrix[1][i] == 'X') {
                counterXSecondRow++;
            }
            if (ticTacToeMatrix[2][i] == 'X') {
                counterXThirdRow++;
            }

            // CHECK 'O'
            if (ticTacToeMatrix[0][i] == 'O') {
                counterOFirstRow++;
            }
            if (ticTacToeMatrix[1][i] == 'O') {
                counterOSecondRow++;
            }
            if (ticTacToeMatrix[2][i] == 'O') {
                counterOThirdRow++;
            }
        }

        char whoWonInDiagonal = findWinnerInDiagonal(ticTacToeMatrix);
        boolean isXWinner = false;
        if (counterXFirstColumn == 3 || counterXSecondColumn == 3
                || counterXThirdColumn == 3 || counterXFirstRow == 3
                || counterXSecondRow == 3 || counterXThirdRow == 3
                || whoWonInDiagonal == 'X') {
            isXWinner = true;
        }

        boolean isOWinner = false;
        if (counterOFirstColumn == 3 || counterOSecondColumn == 3
                || counterOThirdColumn == 3 || counterOFirstRow == 3
                || counterOSecondRow == 3 || counterOThirdRow == 3
                || whoWonInDiagonal == 'O') {
            isOWinner = true;
        }


        if (isXWinner && isOWinner) {
            System.out.println("Impossible");
        } else if (isXWinner) {
            System.out.println("X wins");
        } else if (isOWinner) {
            System.out.println("O wins");
        } else if (areThereEmptyCells(ticTacToeMatrix)) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public static char findWinnerInDiagonal(char[][] ticTacToeMatrix) {
        char whoWonInDiagonal = ' ';
        if (conditionsToWinInDiagonal(ticTacToeMatrix, 'X') == 'X') {
            whoWonInDiagonal = 'X';
        } else if (conditionsToWinInDiagonal(ticTacToeMatrix, 'O') == 'O') {
            whoWonInDiagonal = 'O';
        }

        return whoWonInDiagonal;
    }

    public static char conditionsToWinInDiagonal(char[][] ticTacToeMatrix, char player) {
        if (ticTacToeMatrix[0][0] == player
                && ticTacToeMatrix[1][1] == player
                && ticTacToeMatrix[2][2] == player) {
            return player;
        } else if (ticTacToeMatrix[0][2] == player
                && ticTacToeMatrix[1][1] == player
                && ticTacToeMatrix[2][0] == player) {
            return player;
        } else {
            return ' ';
        }
    }

    public static boolean areThereEmptyCells(char[][] ticTacToeMatrix) {
        int counterOfEmptyCells = 0;

        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) {
                if (ticTacToeMatrix[i][j] == '_') {
                    counterOfEmptyCells++;
                }
            }
        }

        return counterOfEmptyCells != 0;
    }

    public static boolean isNumberOfXAndOValid(char[][] ticTacToeMatrix) {
        int counterOfOs = 0;
        int counterOfXs = 0;

        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) {
                if (ticTacToeMatrix[i][j] == 'O') {
                    counterOfOs++;
                }

                if (ticTacToeMatrix[i][j] == 'X') {
                    counterOfXs++;
                }
            }
        }

        return Math.abs(counterOfXs - counterOfOs) < 2;
    }

}