import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] arr = input.toCharArray();
        int[] freq = new int[65536]; 

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (freq[c] < 999)
                freq[c]++;
        }

        char[] topChars = new char[10];
        int[] topFreq = new int[10];

        for (int i = 0; i < freq.length; i++) {
            int count = freq[i];
            if (count == 0)
                continue;

            for (int j = 0; j < 10; j++) {
                if (count > topFreq[j] ||
                   (count == topFreq[j] && i < topChars[j])) {


                    for (int k = 9; k > j; k--) {
                        topFreq[k] = topFreq[k - 1];
                        topChars[k] = topChars[k - 1];
                    }

                    topFreq[j] = count;
                    topChars[j] = (char) i;
                    break;
                }
            }
        }

        int max = topFreq[0];
        int[] heights = new int[10];

        for (int i = 0; i < 10; i++) {
            if (topFreq[i] > 0)
                heights[i] = (topFreq[i] * 10 + max - 1) / max; 
        }

        for (int level = 10; level > 0; level--) {
            for (int i = 0; i < 10; i++) {
                if (heights[i] >= level) {
                    if (heights[i] == level)
                        System.out.print(topFreq[i] + "\t");
                    else
                        System.out.print("#\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            if (topFreq[i] > 0)
                System.out.print(topChars[i] + "\t");
        }
        System.out.println();
    }
}
