package Menu;

import DAO.booksDAO;
import model.books;

import java.sql.SQLException;
import java.util.Scanner;

public class quanLySach {
    public static void menuTheLoai()  {
        System.out.println("1.Thêm sách\n" +
                "2.Hiển thị sách\n" +
                "3.Xem chi tiết sách\n" +
                "4.Sủa sách\n" +
                "5.Xóa sách");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:{
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
                }catch (SQLException e){
                    System.out.println("Lỗi không thêm được sách");
                    e.printStackTrace();
                }
            }
            case 2: {
                try {
                    booksDAO.getInstance().hienThiTatCa();
                }catch (Exception e){
                    System.out.println("Lỗi hiển thị tất cả");
                    e.printStackTrace();
                }
            }
            case 3:{
                try {
                    System.out.println("Nhập id sách bạn muốn xem chi tiết: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    booksDAO.getInstance().xemChiTiet(id);
                }catch (Exception e){
                    System.out.println("Lỗi xem sách chi tiết");
                    e.printStackTrace();
                }
            }
            case 4:{
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
                    booksDAO.getInstance().sua(books);
                }
                catch (Exception e){
                    System.out.println("Lỗi sửa sách");
                    e.printStackTrace();
                }
            }
            case 5:{
                try {
                    System.out.println("Nhập id sách bạn muốn xóa");
                    int id = sc.nextInt();
                    booksDAO.getInstance().xoa(id);
                }catch (Exception e){
                    System.out.println("Lỗi xóa sách");
                    e.printStackTrace();
                }
            }
        }
    }
}
