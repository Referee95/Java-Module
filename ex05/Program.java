import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collect students
        ArrayList<String> students = new ArrayList<>();
        String input;
        
        while (!(input = scanner.nextLine()).equals(".")) {
            students.add(input);
        }
        
        // Collect schedule
        ArrayList<String> classTimes = new ArrayList<>();
        ArrayList<String> classDays = new ArrayList<>();
        
        while (!(input = scanner.nextLine()).equals(".")) {
            String[] parts = input.split(" ");
            classTimes.add(parts[0]);
            classDays.add(parts[1]);
        }
        
        // Attendance matrix
        int[][] attendance = new int[students.size()][classTimes.size()];
        
        // Record attendance
        while (!(input = scanner.nextLine()).equals(".")) {
            String[] parts = input.split(" ");
            String studentName = parts[0];
            int timeIndex = findClassIndex(parts[1], parts[2], classTimes, classDays);
            
            if (timeIndex != -1) {
                int studentIndex = students.indexOf(studentName);
                attendance[studentIndex][timeIndex] = parts[4].equals("HERE") ? 1 : -1;
            }
        }
        
        // Display header
        for (int i = 0; i < classTimes.size(); i++) {
            System.out.print(classTimes.get(i) + ":00 " + classDays.get(i) + " 2|");
        }
        System.out.println();
        
        // Display attendance
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i) + " ");
            for (int j = 0; j < 10 - students.get(i).length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            
            for (int j = 0; j < classTimes.size(); j++) {
                if (attendance[i][j] == 1) {
                    System.out.print(" 1|");
                } else if (attendance[i][j] == -1) {
                    System.out.print(" -1|");
                } else {
                    System.out.print("  |");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static int findClassIndex(String hour, String day, 
                                      ArrayList<String> times, 
                                      ArrayList<String> days) {
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).equals(hour) && days.get(i).equals(day)) {
                return i;
            }
        }
        return -1;
    }
}