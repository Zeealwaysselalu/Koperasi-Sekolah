package jdbc.Inheritance;

import jdbc.*;
import java.util.Scanner;

public class CobaJDBC extends inheritance {

    public static void mai(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO code application logic here
        inheritance call = new inheritance();
        call.connect();

        System.out.println("OPSI MYSQL");
        System.out.println("1. Select");
        System.out.println("2. Insert");
        System.out.print("MASUKKAN PILIHAN :");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                call.select();
                break;
            case 2:
                System.out.print("Masukkan Nama :");
                String nama = sc.nextLine();
                nama = sc.nextLine();
                System.out.print("Masukkan Kelamin (L/P) :");
                String kelamin = sc.nextLine();
                call.insert(nama, kelamin);
        }

    }

}
