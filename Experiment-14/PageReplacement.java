import java.util.Scanner;

public class PageReplacement {
    static int[] fr = new int[3]; // Initialize the frame array with size 3

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] page = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int flag1 = 0, flag2 = 0, pf = 0, frsize = 3, top = 0;

        for (int i = 0; i < frsize; i++) {
            fr[i] = -1;
        }

        for (int j = 0; j < page.length; j++) {
            flag1 = 0;
            flag2 = 0;
            for (int i = 0; i < frsize; i++) { // Loop should be within frsize
                if (fr[i] == page[j]) {
                    flag1 = 1;
                    flag2 = 1;
                    break;
                }
            }
            if (flag1 == 0) {
                for (int i = 0; i < frsize; i++) {
                    if (fr[i] == -1) {
                        fr[i] = page[j];
                        flag2 = 1;
                        break;
                    }
                }
            }
            if (flag2 == 0) {
                fr[top] = page[j];
                top++;
                pf++;
                if (top >= frsize)
                    top = 0;
            }
            display();
        }
        System.out.println("Number of page faults: " + (pf + frsize));
    }

    static void display() {
        for (int i = 0; i < fr.length; i++) {
            System.out.print(fr[i] + "\t");
        }
        System.out.println();
    }
}
