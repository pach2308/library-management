package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
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
                    quanLyTheLoai.quanLyTheLoai();
                    break;
                }
                case 2:{
                    quanLySach.quanLySach();
                    break;
                }
                case 3:{
                    quanLyDocGia.quanLyDocGia();
                    break;
                }
                case 4: {
                    quanLyMuonTraSach.quanLyMuonSach();
                    break;
                }
                case 5: {
                    quanLyMuonTraSach.quanLyTraSach();
                    break;
                }
                case 6: {
                    quanLyPhieuMuon.quanLyPhieuMuon();
                    break;
                }
            }
            System.out.println("Bạn muốn tiếp tục/thoát: \n" +
                    "1.tiếp tục \n" +
                    "2.thoát");
            int traloi = sc.nextInt();
            sc.nextLine();
            if(traloi == 1);
            else {
                choice = 7;
                System.out.println("Bạn đã thoát khỏi chương trình.");
            }
        }while (choice != 7) ;
    }
}
