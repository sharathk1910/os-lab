package exp1;
import java.util.Scanner;
public class FCFS {
	public static void main(String [] args) {
		        int n, i;
		        double wta = 0, tata = 0;
		        Scanner sc = new Scanner(System.in);
		        int[] bt = new int[20],wt = new int[20],tat = new int[20];

		        System.out.print("Enter the number of processes: ");
		        n = sc.nextInt();

		        

		        for (i = 0; i < n; i++) {
		            System.out.print("Enter burst time for process " + i + ": ");
		            bt[i] = sc.nextInt();
		        }

		        wt[0] =0;
		        wta = 0.0;
		        tat[0] = bt[0];
		        tata = bt[0];

		        for (i = 1; i < n; i++) {
		            wt[i] = wt[i - 1] + bt[i - 1];
		            tat[i] = tat[i - 1] + bt[i];
		            wta += wt[i];
		            tata += tat[i];
		        }

		        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
		        for (i = 0; i < n; i++) {
		            System.out.println("\nP" + i + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
		        }

		        System.out.println("\nAverage Waiting Time = " + (wta/ n));
		        System.out.println("Average Turnaround Time = " + (tata / n));
		    }
		}
