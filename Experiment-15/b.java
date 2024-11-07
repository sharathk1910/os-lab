import java.util.Scanner;

class Directory {
    String dname;
    String[] fname = new String[10];
    int fcnt;

    Directory() {
        fcnt = 0;
    }
}

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directory[] dir = new Directory[10];
        for (int i = 0; i < 10; i++) {
            dir[i] = new Directory();
        }
        int i, ch, dcnt = 0, k;
        String f, d;

        while (true) {
            System.out.println("\n\n1. Create Directory\t2. Create File\t3. Delete File");
            System.out.println("4. Search File\t\t5. Display\t6. Exit\t Enter your choice --");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter name of directory -- ");
                    dir[dcnt].dname = sc.next();
                    dir[dcnt].fcnt = 0;
                    dcnt++;
                    System.out.println("Directory created");
                    break;
                case 2:
                    System.out.print("Enter name of the directory -- ");
                    d = sc.next();
                    for (i = 0; i < dcnt; i++) {
                        if (d.equals(dir[i].dname)) {
                            System.out.print("Enter name of the file -- ");
                            dir[i].fname[dir[i].fcnt] = sc.next();
                            dir[i].fcnt++;
                            System.out.println("File created");
                            break;
                        }
                    }
                    if (i == dcnt)
                        System.out.println("Directory " + d + " not found");
                    break;
                case 3:
                    System.out.print("Enter name of the directory -- ");
                    d = sc.next();
                    for (i = 0; i < dcnt; i++) {
                        if (d.equals(dir[i].dname)) {
                            System.out.print("Enter name of the file -- ");
                            f = sc.next();
                            for (k = 0; k < dir[i].fcnt; k++) {
                                if (f.equals(dir[i].fname[k])) {
                                    System.out.println("File " + f + " is deleted");
                                    dir[i].fcnt--;
                                    dir[i].fname[k] = dir[i].fname[dir[i].fcnt];
                                    break;
                                }
                            }
                            if (k == dir[i].fcnt)
                                System.out.println("File " + f + " not found");
                            break;
                        }
                    }
                    if (i == dcnt)
                        System.out.println("Directory " + d + " not found");
                    break;
                case 4:
                    System.out.print("Enter name of the directory -- ");
                    d = sc.next();
                    for (i = 0; i < dcnt; i++) {
                        if (d.equals(dir[i].dname)) {
                            System.out.print("Enter the name of the file -- ");
                            f = sc.next();
                            for (k = 0; k < dir[i].fcnt; k++) {
                                if (f.equals(dir[i].fname[k])) {
                                    System.out.println("File " + f + " is found");
                                    break;
                                }
                            }
                            if (k == dir[i].fcnt)
                                System.out.println("File " + f + " not found");
                            break;
                        }
                    }
                    if (i == dcnt)
                        System.out.println("Directory " + d + " not found");
                    break;
                case 5:
                    if (dcnt == 0)
                        System.out.println("No Directories");
                    else {
                        System.out.println("Directory\tFiles");
                        for (i = 0; i < dcnt; i++) {
                            System.out.print(dir[i].dname + "\t\t");
                            for (k = 0; k < dir[i].fcnt; k++) {
                                System.out.print("\t" + dir[i].fname[k]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
