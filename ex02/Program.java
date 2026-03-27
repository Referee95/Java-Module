import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coffeeCount = 0;
        
        while (true) {
            int number = scanner.nextInt();
            
            // Stop when we encounter 42
            if (number == 42) {
                break;
            }
            
            // Check if the number is related to coffee preparation
            if (isCoffeeRequest(number)) {
                coffeeCount++;
            }
        }
        
        System.out.println("Count of coffee-request : " + coffeeCount);
        scanner.close();
    }
    
    // Check if the sum of digits is a prime number
    private static boolean isCoffeeRequest(int number) {
        // Calculate sum of digits
        int sum = 0;
        int temp = Math.abs(number); // Handle negative numbers if any
        
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        // Check if sum is prime
        return isPrime(sum);
    }
    
    // Check if a number is prime
    private static boolean isPrime(int n) {
        // Numbers less than 2 are not prime
        if (n < 2) {
            return false;
        }
        
        // Check divisibility from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}