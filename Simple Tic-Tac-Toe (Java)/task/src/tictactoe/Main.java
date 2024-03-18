package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] ticTacToeMatrix = new char[3][3];
        initialFillOfTicTacToe(ticTacToeMatrix);

        // Print original matrix for the first time
        printTicTacToeMatrix(ticTacToeMatrix);

        boolean isValidMove = true;
        do {
            String playerMove = scanner.nextLine();
            isValidMove = placeUserMove(ticTacToeMatrix, playerMove);
        } while (!isValidMove);

        // Print new matrix considering the user's input
        printTicTacToeMatrix(ticTacToeMatrix);

//        if (!isNumberOfXAndOValid(ticTacToeMatrix)) {
//            System.out.println("Impossible");
//        } else {
//            findWinner(ticTacToeMatrix);
//        }
    }

    public static void initialFillOfTicTacToe(char[][] ticTacToeMatrix) {
        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) {
                ticTacToeMatrix[i][j] = ' ';
            }
        }
    }

    public static char checkIfItsEmpty(char cell) {
        return cell == '_' ? ' ' : cell;
    }

    public static boolean placeUserMove(char[][] ticTacToeMatrix, String userMove) {
        int firstCoordinateZeroIndex;
        int secondCoordinateZeroIndex;

        if (userMove.matches("^\\d \\d$")) {
            String[] coordinates = userMove.split(" ");
            firstCoordinateZeroIndex = Integer.parseInt(coordinates[0]) - 1;
            secondCoordinateZeroIndex = Integer.parseInt(coordinates[1]) - 1;
        } else {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (firstCoordinateZeroIndex > 2 || secondCoordinateZeroIndex > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (ticTacToeMatrix[firstCoordinateZeroIndex][secondCoordinateZeroIndex] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            ticTacToeMatrix[firstCoordinateZeroIndex][secondCoordinateZeroIndex] = 'X';
            return true;
        }
    }

    public static String transform2DArrayIntoString(char[][] ticTacToeMatrix) {
        StringBuilder ticTacToe = new StringBuilder();
        for (int i = 0; i < ticTacToeMatrix.length; i++) {
            for (int j = 0; j < ticTacToeMatrix[i].length; j++) {
                ticTacToe.append(ticTacToeMatrix[i][j]);
            }
        }

        return ticTacToe.toString();
    }

    public static void printTicTacToeMatrix(char[][] ticTacToeMatrix) {
        String ticTacToeMatrixToString = transform2DArrayIntoString(ticTacToeMatrix);

        final int GRID_LIMIT = 9;

        System.out.println("---------"); // Print first divider

        for (int i = 0; i < GRID_LIMIT; i += 3) {
            System.out.printf("| %c %c %c |\n", checkIfItsEmpty(ticTacToeMatrixToString.charAt(i)),
                    checkIfItsEmpty(ticTacToeMatrixToString.charAt(i+1)),
                    checkIfItsEmpty(ticTacToeMatrixToString.charAt(i+2)));
        }

        System.out.println("---------"); // Print second divider

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