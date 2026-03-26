import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        boolean isPrime = true;
        int iterations = 0;

        for (int i = 2; i <= number / 2; i++) {
            iterations++; // count comparison

            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime + " " + iterations);
    }
}