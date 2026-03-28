import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int week = 1;
        long storage = 0; // stores all min grades
        int countWeeks = 0;

        while (true) {
            String input = sc.next();

            if (input.equals("42"))
                break;

            if (!input.equals("Week")) {
                error();
            }

            int weekNumber = sc.nextInt();

            if (weekNumber != week) {
                error();
            }

            int min = 10;

            for (int i = 0; i < 5; i++) {
                int grade = sc.nextInt();

                if (grade < 1 || grade > 9)
                    error();

                if (grade < min)
                    min = grade;
            }

            storage = storage * 10 + min;
            week++;
            countWeeks++;

            if (countWeeks > 18)
                break;
        }

        printResult(storage, countWeeks);
    }

    public static void printResult(long storage, int weeks) {
        long divisor = 1;

        // get divisor like 1000 for 4 digits
        for (int i = 1; i < weeks; i++)
            divisor *= 10;

        for (int i = 1; i <= weeks; i++) {
            int digit = (int)(storage / divisor);

            System.out.print("Week " + i + " ");

            for (int j = 0; j < digit; j++)
                System.out.print("=");

            System.out.println(">");

            storage %= divisor;
            divisor /= 10;
        }
    }

    public static void error() {
        System.err.println("IllegalArgument");
        System.exit(-1);
    }
}