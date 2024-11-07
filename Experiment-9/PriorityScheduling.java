import java.util.Scanner;

public class PriorityScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, temp;
        float wtavg = 0, tatavg = 0;

        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();

        int[] p = new int[n];
        int[] bt = new int[n];
        int[] pri = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i + 1;  // Process IDs (1, 2, 3, ...)
            System.out.print("Enter the Burst Time & Priority of Process " + (i + 1) + ": ");
            bt[i] = scanner.nextInt();
            pri[i] = scanner.nextInt();
        }

        // Sorting based on priority
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (pri[i] > pri[k]) {
                    // Swap process numbers
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;

                    // Swap burst times
                    temp = bt[i];
                    bt[i] = bt[k];
                    bt[k] = temp;

                    // Swap priorities
                    temp = pri[i];
                    pri[i] = pri[k];
                    pri[k] = temp;
                }
            }
        }

        // Calculating waiting time and turnaround time
        wt[0] = 0;
        tat[0] = bt[0];
        wtavg = 0;
        tatavg = tat[0];

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtavg += wt[i];
            tatavg += tat[i];
        }

        // Output results
        System.out.println("\nPROCESS\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t\t" + pri[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        System.out.println("\nAverage Waiting Time is: " + (wtavg / n));
        System.out.println("Average Turnaround Time is: " + (tatavg / n));

        scanner.close();
    }
}
