package DAO;

import library.DatabaseConnection;
import model.borrowing_details;

import java.sql.*;
import java.util.ArrayList;

public class borrowing_detailsDAO {
    public static borrowing_detailsDAO getInstance(){
        return new borrowing_detailsDAO();
    }

    public ArrayList chiTietPhieuMuon(){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowing_details";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int borrowing_id = rs.getInt("borrowing_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                borrowing_details borrowing_details = new borrowing_details(id,borrowing_id,book_id,quantity);
                ketqua.add(borrowing_details);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không xem được chi tiết phiếu mượn");
        }
        return ketqua;
    }

    public void them (int a , int b , int c){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql ="Insert into borrowing_details(borrowing_id,book_id,quantity)" +
                    "values" +
                    "(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            pst.setInt(2,b);
            pst.setInt(3,c);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không thêm được chi tiết phiếu mượn");
        }

    }

    public ArrayList timTheoId(int a){
        ArrayList ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from borrowing_details" +
                    "where borrowing_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int borrowing_id = rs.getInt("borrowing_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                borrowing_details borrowing_details = new borrowing_details(id,borrowing_id,book_id,quantity);
                ketqua.add(borrowing_details);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm được chi tiết phiếu mượn theo ID");
        }
        return ketqua;
    }
}
