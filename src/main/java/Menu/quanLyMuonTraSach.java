package Menu;

import DAO.borrowingsDAO;
import model.books;
import DAO.booksDAO;
import model.borrowing_details;
import model.borrowings;
import service.BorrowingService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quanLyMuonTraSach {
    static Scanner sc = new Scanner(System.in);
    public static void quanLyMuonSach(){
        try {
            System.out.println("Nhập id sách mà bạn muốn mượn: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập số lượng sách mà bạn muốn mượn: ");
            int count = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập id của người đọc: ");
            int reader_id = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập ngày trả: ");
            Date due_date = Date.valueOf(sc.nextLine());
            books b = booksDAO.getInstance().timTheoId(id);
            borrowings borrowings = new borrowings(reader_id, due_date);
            List<borrowing_details> details = new ArrayList<>();
            details.add(new borrowing_details(count, b.getId(), borrowings.getId()));
            BorrowingService.muonSach(borrowings, count, b.getTitle(), details);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void quanLyTraSach(){
        try {
            System.out.println("Nhập id sách mà bạn muốn trả: ");
            int id = sc.nextInt();
            borrowings b = borrowingsDAO.getInstance().timTheoId(id);
            BorrowingService.traSach(b);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
