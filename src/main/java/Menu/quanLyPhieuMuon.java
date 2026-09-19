package Menu;

import model.borrowings;
import DAO.borrowingsDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class quanLyPhieuMuon {
    public static void quanLyPhieuMuon() {
        System.out.println("1.Danh sách tất cả phiếu mượn\n" +
                "2.Các phiếu đang mượn\n" +
                "3.Các phiếu đã trả\n" +
                "4.Các phiếu đã hết hạn\n" +
                "5.Phiếu mượn của 1 độc giả cụ thể\n" +
                "6.Chi tiết các phiêu");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                try {
                    ArrayList<borrowings> borrowingsArrayList = borrowingsDAO.getInstance().hienThiTatCa();
                    for (borrowings borrowings : borrowingsArrayList) {
                        System.out.println(borrowings);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    ArrayList<borrowings> borrowingsArrayList = borrowingsDAO.getInstance().cacPhieuDangMuon();
                    for (borrowings borrowings : borrowingsArrayList) {
                        System.out.println(borrowings);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {
                    ArrayList<borrowings> borrowingsArrayList = borrowingsDAO.getInstance().cacPhieuDaTra();
                    for (borrowings borrowings : borrowingsArrayList) {
                        System.out.println(borrowings);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 4:{
                try {
                    ArrayList<borrowings> borrowingsArrayList = borrowingsDAO.getInstance().cacPhieuDaQuaHan();
                    for (borrowings borrowings : borrowingsArrayList) {
                        System.out.println(borrowings);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 5:{
                try {
                    System.out.println("Nhập id của độc giả bạn muốn xem: ");
                    int id = sc.nextInt();
                    ArrayList<borrowings> borrowingsArrayList = borrowingsDAO.getInstance().phieuMuonCuaDocGiaCuThe(id);
                    for (borrowings borrowings : borrowingsArrayList) {
                        System.out.println(borrowings);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 6:{
                try{
                    System.out.println("Nhập id của phiếu mà bạn muốn xem chi tiết: ");
                    int id = sc.nextInt();
                    borrowingsDAO.getInstance().chiTietPhieu(id);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
