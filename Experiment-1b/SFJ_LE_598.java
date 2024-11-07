package exp1;
import java.util.Scanner;
public class SFJ {
	
	    public static void main(String[] args) {
	        int[] p = new int[20], bt = new int[20], wt = new int[20], tat = new int[20];
	        int n, i, k, temp;
	        float wtavg, tatavg;

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of processes: ");
	        n = scanner.nextInt();

	        for (i = 0; i < n; i++) {
	            p[i] = i;
	            System.out.print("Enter Burst Time for Process " + i + ": ");
	            bt[i] = scanner.nextInt();
	        }

	        // Sorting processes based on burst time
	        for (i = 0; i < n; i++) {
	            for (k = i + 1; k < n; k++) {
	                if (bt[i] > bt[k]) {
	                    temp = bt[i];
	                    bt[i] = bt[k];
	                    bt[k] = temp;

	                    temp = p[i];
	                    p[i] = p[k];
	                    p[k] = temp;
	                }
	            }
	        }

	        wt[0] = 0;
	        wtavg = 0;
	        tat[0] =bt[0];
	        tatavg = bt[0];
	        for (i = 1; i < n; i++) {
	            wt[i] = wt[i - 1] + bt[i - 1];
	            tat[i] = tat[i - 1] + bt[i];
	            wtavg += wt[i];
	            tatavg += tat[i];
	        }

	        System.out.println("\n\t PROCESS \t BURST TIME \t WAITING TIME \t TURNAROUND TIME");
	        for (i = 0; i < n; i++) {
	            System.out.println("\n\t P" + p[i] + "\t\t " + bt[i] + "\t\t " + wt[i] + "\t\t " + tat[i]);
	        }
	        System.out.println("\nAverage Waiting Time: " + wtavg / n);
	        System.out.println("Average Turnaround Time: " + tatavg / n);

	        scanner.close();
	    }
	}

