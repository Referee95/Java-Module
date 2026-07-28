import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int week = 1;
        int data = 0;

        while (true) {

            System.out.print("-> ");
            String input = scanner.next();
            if (input.equals("42")) {
                break;
            }

            if (!input.equals("Week")) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            int currentWeek = scanner.nextInt();

            if (currentWeek != week) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            int min = 9;
            System.out.print("-> ");
            for (int i = 0; i < 5; i++) {
                int grade = scanner.nextInt();
                if (grade < min) {
                    min = grade;
                }
            }

            data = data * 10 + min;
            week++;
        }

        int i = 1;

        while (data > 0) {
            int min = data % 10;

            System.out.print("Week " + i + " ");

            for (int j = 0; j < min; j++) {
                System.out.print("=");
            }

            System.out.println(">");

            data /= 10;
            i++;
        }
    }
}