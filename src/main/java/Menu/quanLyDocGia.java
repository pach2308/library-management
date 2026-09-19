package Menu;

import DAO.readersDAO;
import model.readers;

import java.util.ArrayList;
import java.util.Scanner;

public class quanLyDocGia {
    public static void quanLyDocGia(){
        System.out.println("1.Thêm độc giả" +
                "2.Hiện thị tất cả độc giả\n" +
                "3.sửa\n" +
                "4.xóa độc giả\n" +
                "5.Tìm độc giả theo tên\n" +
                "6.Tìm độc giả theo email\n" +
                "7.Tìm độc giả theo số điện thoại");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                try {
                    System.out.println("Nhập tên của độc giả: ");
                    String full_name = sc.nextLine();
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String address = sc.nextLine();
                    readers readers = new readers(full_name, email, phone, address);
                    readersDAO.getInstance().them(readers);
                    System.out.println("Thêm thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2:{
                try{
                    ArrayList<readers> ketqua = readersDAO.getInstance().hienThiTatCa();
                    for(readers readers : ketqua){
                        System.out.println(readers);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3:{
                try{
                    System.out.println("Nhập id của sách mà bạn muốn sửa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên độc giả mới: ");
                    String full_name = sc.nextLine();
                    System.out.println("Nhập email mới: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập số điện thoại mới: ");
                    String phone = sc.nextLine();
                    System.out.println("Nhập địa chỉ mới: ");
                    String address = sc.nextLine();
                    readers readers = new readers(full_name,email,phone,address);
                    readersDAO.getInstance().sua(readers,id);
                    System.out.println("Sửa thành công");
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 4:{
                try {
                    System.out.println("Nhập id của độc giả mà bạn muốn xóa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    readersDAO.getInstance().xoa(id);
                    System.out.println("Xóa thành công");
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 5:{
                try {
                    System.out.println("Nhập tên của độc giả: ");
                    String name = sc.nextLine();
                    readersDAO.getInstance().timTheoTen(name);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 6:{
                try {
                    System.out.println("Nhập email: ");
                    String email = sc.nextLine();
                    readersDAO.getInstance().timTheoemail(email);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 7:{
                try {
                    System.out.println("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    readersDAO.getInstance().timTheosdt(phone);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}

