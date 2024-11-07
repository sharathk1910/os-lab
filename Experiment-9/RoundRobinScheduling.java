import java.util.Scanner;

public class RoundRobinScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, t, max;
        float awt = 0, att = 0, temp = 0;

        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();

        int[] bu = new int[n];
        int[] wa = new int[n];
        int[] tat = new int[n];
        int[] ct = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Burst Time for process " + (i + 1) + ": ");
            bu[i] = scanner.nextInt();
            ct[i] = bu[i];
        }

        System.out.print("\nEnter the size of time slice: ");
        t = scanner.nextInt();

        max = bu[0];
        for (int i = 1; i < n; i++) {
            if (max < bu[i]) {
                max = bu[i];
            }
        }

        for (int j = 0; j < (max / t) + 1; j++) {
            for (int i = 0; i < n; i++) {
                if (bu[i] != 0) {
                    if (bu[i] <= t) {
                        tat[i] = (int) temp + bu[i];
                        temp += bu[i];
                        bu[i] = 0;
                    } else {
                        bu[i] -= t;
                        temp += t;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            wa[i] = tat[i] - ct[i];
            att += tat[i];
            awt += wa[i];
        }

        System.out.println("\nThe Average Turnaround time is: " + att / n);
        System.out.println("The Average Waiting time is: " + awt / n);

        System.out.println("\n\tPROCESS\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (int i = 0; i < n; i++) {
            System.out.println("\t" + (i + 1) + "\t" + ct[i] + "\t\t" + wa[i] + "\t\t" + tat[i]);
        }

        scanner.close();
    }
}
