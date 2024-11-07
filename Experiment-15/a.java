import java.util.Scanner;

class Directory {
    String dname;
    String[] fname = new String[10];
    int fcnt;

    Directory() {
        fcnt = 0;
    }
}

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directory dir = new Directory();
        int i, ch;
        String f;

        System.out.print("Enter name of directory -- ");
        dir.dname = sc.next();

        while (true) {
            System.out.println("\n\n1. Create File\t2. Delete File\t3. Search File \n4. Display Files\t5. Exit\nEnter your choice -- ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the name of the file -- ");
                    dir.fname[dir.fcnt] = sc.next();
                    dir.fcnt++;
                    break;
                case 2:
                    System.out.print("Enter the name of the file -- ");
                    f = sc.next();
                    for (i = 0; i < dir.fcnt; i++) {
                        if (f.equals(dir.fname[i])) {
                            System.out.println("File " + f + " is deleted");
                            dir.fname[i] = dir.fname[dir.fcnt - 1];
                            break;
                        }
                    }
                    if (i == dir.fcnt)
                        System.out.println("File " + f + " not found");
                    else
                        dir.fcnt--;
                    break;
                case 3:
                    System.out.print("Enter the name of the file -- ");
                    f = sc.next();
                    for (i = 0; i < dir.fcnt; i++) {
                        if (f.equals(dir.fname[i])) {
                            System.out.println("File " + f + " is found");
                            break;
                        }
                    }
                    if (i == dir.fcnt)
                        System.out.println("File " + f + " not found");
                    break;
                case 4:
                    if (dir.fcnt == 0)
                        System.out.println("Directory Empty");
                    else {
                        System.out.println("The Files are -- ");
                        for (i = 0; i < dir.fcnt; i++)
                            System.out.println("\t" + dir.fname[i]);
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
