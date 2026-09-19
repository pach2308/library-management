package Menu;

import DAO.categoriesDAO;
import model.categories;

import java.util.ArrayList;
import java.util.Scanner;

public class quanLyTheLoai {
    public static void quanLyTheLoai() {
        System.out.println("1.Thêm thể loại\n" +
                "2.hiện thị tất cả\n" +
                "3.sửa\n" +
                "4.xóa\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                try {
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập sự miêu tả");
                    String description = sc.nextLine();
                    categories categories = new categories(name, description);
                    categoriesDAO.getInstance().them(categories);
                    System.out.println("Thêm thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try{
                    ArrayList<categories> categoriesArrayList = categoriesDAO.getInstance().hienThiTatCa();
                    for (categories categories : categoriesArrayList){
                        System.out.println(categories);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 3:{
                try{
                    System.out.println("Nhập id của sách mà bạn muốn sửa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên khi sửa lại: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập sự miêu tả khi sửa lại: ");
                    String description = sc.nextLine();
                    categories categories = new categories(name,description);
                    categoriesDAO.getInstance().sua(categories, id);
                    System.out.println("Sửa thành công");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 4:{
                try{
                    System.out.println("Nhập id của thể loại mà bạn muốn xóa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    categoriesDAO.getInstance().xoa(id);
                    System.out.println("Xóa thành công");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
