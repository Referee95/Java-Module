import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] student = new String[10];

        for(int i = 0; i <= 9; i++){
            student[i] = sc.nextLine();
            if(student[i] == ".")
                break;
        }
        String[] hours = new String[10];
        String[] days = new String[10];
         for(int i = 0; i <= 9; i++){
            String line = sc.nextLine();
            String[] arr = line.toCharArray();
            if(arr[0] == ".")
                break;
            hours[i] = line[0];
            days[i] = line[2] + line[3];    
            System.out.print(hours[i] + "   " + days[i] + "\n");
        }
    }
}   