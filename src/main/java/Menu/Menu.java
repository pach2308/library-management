package Menu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Library Management\n" +
                    "1.Quản lí thể loại\n" +
                    "2.Quản lí sách\n" +
                    "3.Quản lí độc giả\n" +
                    "4.Mượn Sách\n" +
                    "5.Trả Sách\n" +
                    "6.Tra cứu phiếu mượn\n" +
                    "7.Thoát");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:{

                }
            }

        }while (choice != 7) ;

    }
}
