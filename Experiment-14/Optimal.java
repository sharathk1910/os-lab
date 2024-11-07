import java.util.Scanner;
import java.util.Arrays;

public class Optimal {
    static int[] fr;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of the reference string: ");
        n = sc.nextInt();
        int[] page = new int[n];
        System.out.print("Enter the reference string: ");
        for (int i = 0; i < n; i++) {
            page[i] = sc.nextInt();
        }
        System.out.print("Enter number of frames: ");
        m = sc.nextInt();
        fr = new int[m];
        Arrays.fill(fr, -1);
        int pf = m;
        int[] lg = new int[m];
        int flag1, flag2, max, index, found;
        float pr;

        for (int j = 0; j < n; j++) {
            flag1 = 0;
            flag2 = 0;
            for (int i = 0; i < m; i++) {
                if (fr[i] == page[j]) {
                    flag1 = 1;
                    flag2 = 1;
                    break;
                }
            }
            if (flag1 == 0) {
                for (int i = 0; i < m; i++) {
                    if (fr[i] == -1) {
                        fr[i] = page[j];
                        flag2 = 1;
                        break;
                    }
                }
            }
            if (flag2 == 0) {
                Arrays.fill(lg, 0);
                for (int i = 0; i < m; i++) {
                    for (int k = j + 1; k < n; k++) {
                        if (fr[i] == page[k]) {
                            lg[i] = k - j;
                            break;
                        }
                    }
                }
                found = 0;
		index = 0;
                for (int i = 0; i < m; i++) {
                    if (lg[i] == 0) {
                        index = i;
                        found = 1;
                        break;
                    }
                }
                if (found == 0) {
                    max = lg[0];
                   
                    for (int i = 0; i < m; i++) {
                        if (max < lg[i]) {
                            max = lg[i];
                            index = i;
                        }
                    }
                }
                fr[index] = page[j];
                pf++;
            }
            display();
        }
        System.out.println("Number of page faults: " + pf);
        pr = (float) pf / n * 100;
        System.out.println("Page fault rate = " + pr);
        sc.close();
    }

    static void display() {
        for (int i = 0; i < m; i++) {
            System.out.print(fr[i] + "\t");
        }
        System.out.println();
    }
}
