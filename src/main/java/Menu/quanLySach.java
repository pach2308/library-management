package Menu;

import DAO.booksDAO;
import model.books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class quanLySach {
    public static void quanLySach() {
        System.out.println("1.Thêm sách\n" +
                "2.Hiển thị sách\n" +
                "3.Xem chi tiết sách\n" +
                "4.Sủa sách\n" +
                "5.Xóa sách\n" +
                "6.Tìm sách theo tên gần đúng\n" +
                "7.Tìm sách theo tên tác giả\n" +
                "8.Lọc sách theo thể loại\n" +
                "9.Hiển thị các sách còn hàng\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                try {
                    System.out.println("Tên sách: ");
                    String title = sc.nextLine();
                    System.out.println("tên tác giả: ");
                    String author = sc.nextLine();
                    System.out.println("Nhà xuất bản: ");
                    String publisher = sc.nextLine();
                    System.out.println("Năm xuất bản: ");
                    int published_year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Số lượng: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Loại sách: ");
                    int category_id = sc.nextInt();
                    sc.nextLine();
                    books books = new books(title, author, publisher, published_year, quantity, category_id);
                    booksDAO.getInstance().them(books);
                    System.out.println("Thêm thành công");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 2: {
                try {
                    ArrayList<books> booksArrayList = booksDAO.getInstance().hienThiTatCa();
                    for(books books : booksArrayList){
                        System.out.println(books);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 3: {
                try {
                    System.out.println("Nhập id sách bạn muốn xem chi tiết: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    booksDAO.getInstance().xemChiTiet(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 4: {
                try {
                    System.out.println("Nhập id sách mà bạn muốn sửa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Sửa tên sách thành: ");
                    String title = sc.nextLine();
                    System.out.println("Sửa tên tác giả thành: ");
                    String author = sc.nextLine();
                    System.out.println("Sửa Nhà xuất bản thành: ");
                    String publisher = sc.nextLine();
                    System.out.println("Sửa năm xuất bản thành: ");
                    int published_year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Sửa số lượng thành: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Sửa loại sách thành: ");
                    int category_id = sc.nextInt();
                    sc.nextLine();
                    books books = new books(title, author, publisher, published_year, quantity, category_id);
                    booksDAO.getInstance().sua(books , id);
                    System.out.println("Sửa thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 5: {
                try {
                    System.out.println("Nhập id sách bạn muốn xóa");
                    int id = sc.nextInt();
                    booksDAO.getInstance().xoa(id);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Xóa thành công");
                }
            }
            case 6: {
                try {
                    System.out.println("Nhập tên sách: ");
                    String title = sc.nextLine();
                    booksDAO.getInstance().timTenGanDung(title);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 7: {
                try {
                    System.out.println("Nhập tên tác giả");
                    String author = sc.nextLine();
                    booksDAO.getInstance().timTheoTenTacGia(author);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 8: {
                try {
                    System.out.println("Nhập id thể loại ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    booksDAO.getInstance().locTheoTheLoai(id);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            case 9:{
                try{
                    ArrayList<books> booksArrayList = booksDAO.getInstance().sachConHang();
                    for(books books : booksArrayList){
                        System.out.println(books);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
