import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coffeeCount = 0;
        
        while (true) {
            System.out.print("-> ");
            int number = scanner.nextInt();
            if (number == 42) {
                break;
            }
            
            if (isCoffeeRequest(number)) {
                coffeeCount++;
            }
        }
        
        System.out.println("Count of coffee-request : " + coffeeCount);
        scanner.close();
    }
    
    private static boolean isCoffeeRequest(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return isPrime(sum);
    }   
    

    private static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}