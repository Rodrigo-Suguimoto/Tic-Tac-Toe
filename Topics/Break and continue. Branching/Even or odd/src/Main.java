import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int inputtedNumber = scanner.nextInt();
            if (inputtedNumber == 0) {
                break;
            }
            String evenOrOdd = inputtedNumber % 2 == 0 ? "even" : "odd";
            System.out.println(evenOrOdd);
        }
    }
}