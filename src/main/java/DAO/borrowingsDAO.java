package DAO;

import library.DatabaseConnection;
import model.borrowing_details;
import model.borrowings;

import java.sql.*;
import java.util.ArrayList;

public class borrowingsDAO {
    public static borrowingsDAO getInstance(){
        return new borrowingsDAO();
    }

    public void them(borrowings b, int soLuongMuon , String tensach){
        if(b.getReader_id() != 0 && tensach != null && soLuongMuon>0 && b.getReturn_date().before(b.getBorrow_date())) {
            try {
                Connection con = DatabaseConnection.getConnection();
                String sql = "Insert into borrowings(reader_id,borrow_date,due_date,return_date,status)" +
                        "values" +
                        "(?,?,?,?,?) ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, b.getReader_id());
                pst.setDate(2, b.getBorrow_date());
                pst.setDate(3, b.getDue_date());
                pst.setDate(4, b.getReturn_date());
                pst.setString(5, b.getStatus());
                pst.executeUpdate();
                DatabaseConnection.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else throw new RuntimeException("không hợp lệ");
    }

    public void xoa(int b){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql ="delete from borrowings" +
                    "where id = ?";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1,b);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList hienThiTatCa(){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowings";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int reader_id = rs.getInt("reader_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date due_date = rs.getDate("due_date");
                Date return_date = rs.getDate("return_date");
                String status = rs.getString("status");
                borrowings borrowings = new borrowings(id,reader_id,borrow_date,due_date,return_date,status);
                ketqua.add(borrowings);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList cacPhieuDaTra(){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowings" +
                    "where status = RETURNED ";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int reader_id = rs.getInt("reader_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date due_date = rs.getDate("due_date");
                Date return_date = rs.getDate("return_date");
                String status = rs.getString("status");
                borrowings borrowings = new borrowings(id,reader_id,borrow_date,due_date,return_date,status);
                ketqua.add(borrowings);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList cacPhieuDaQuaHan(){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowings" +
                    "where status = OVERDUE ";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int reader_id = rs.getInt("reader_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date due_date = rs.getDate("due_date");
                Date return_date = rs.getDate("return_date");
                String status = rs.getString("status");
                borrowings borrowings = new borrowings(id,reader_id,borrow_date,due_date,return_date,status);
                ketqua.add(borrowings);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList phieuMuonCuaDocGiaCuThe(int s){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowings" +
                    "where status = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,s);
            ResultSet rs = pst.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int reader_id = rs.getInt("reader_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date due_date = rs.getDate("due_date");
                Date return_date = rs.getDate("return_date");
                String status = rs.getString("status");
                borrowings borrowings = new borrowings(id,reader_id,borrow_date,due_date,return_date,status);
                ketqua.add(borrowings);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public borrowings timTheoId(int a){
        borrowings ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from borrowings" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int reader_id = rs.getInt("reader_id");
                Date borrow_date = rs.getDate("borrow_date");
                Date due_date = rs.getDate("due_date");
                Date return_date = rs.getDate("return_date");
                String status = rs.getString("status");
                ketqua = new borrowings(id,reader_id,borrow_date,due_date,return_date,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public void chiTietPhieu(int a){
        int b = borrowingsDAO.getInstance().timTheoId(a).getReader_id();
        System.out.println("Thông tin độc giả: ");
        readersDAO.getInstance().timTheoId(b);
        ArrayList<borrowing_details> details = borrowing_detailsDAO.getInstance().timTheoId(a);
        System.out.println("Các sách đã mượn: ");
        for(borrowing_details detail : details){
            String title = booksDAO.getInstance().timTheoId(detail.getBook_id()).getTitle();
            System.out.println(title);
        }






    }
}
