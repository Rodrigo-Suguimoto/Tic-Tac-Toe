import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repetition = scanner.nextInt();
        int counter = 0;

        for (int i = 1; i <= repetition; i++) {
            for (int j = 0; j < i && counter < repetition; j++) {
                if (counter + 1 == repetition) {
                    System.out.print(i);
                } else {
                    System.out.print(i + " ");
                }
                counter++;
            }
        }
    }
}