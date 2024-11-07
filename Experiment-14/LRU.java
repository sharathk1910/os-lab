import java.util.Arrays;

public class LRU {
    static int[] fr = new int[3];

    public static void main(String[] args) {
        int[] p = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int[] fs = new int[3];
        int index = 0, k, l, flag1, flag2, pf = 0, frsize = 3;

        Arrays.fill(fr, -1);

        for (int j = 0; j < 12; j++) {
            flag1 = 0;
            flag2 = 0;

            for (int i = 0; i < 3; i++) {
                if (fr[i] == p[j]) {
                    flag1 = 1;
                    flag2 = 1;
                    break;
                }
            }

            if (flag1 == 0) {
                for (int i = 0; i < 3; i++) {
                    if (fr[i] == -1) {
                        fr[i] = p[j];
                        flag2 = 1;
                        break;
                    }
                }
            }

            if (flag2 == 0) {
                Arrays.fill(fs, 0);
                for (k = j - 1, l = 1; l <= frsize - 1; l++, k--) {
                    for (int i = 0; i < 3; i++) {
                        if (fr[i] == p[k]) fs[i] = 1;
                    }
                }

                for (int i = 0; i < 3; i++) {
                    if (fs[i] == 0) index = i;
                }
                fr[index] = p[j];
                pf++;
            }
            display();
        }
        System.out.println("\nNumber of page faults: " + (pf + frsize));
    }

    static void display() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("\t" + fr[i]);
        }
    }
}
