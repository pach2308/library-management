package DAO;

import library.DatabaseConnection;
import model.books;

import java.sql.*;
import java.util.ArrayList;

public class booksDAO {
    public static booksDAO getInstance(){
        return new booksDAO();
    }

    public void them(books b) throws SQLException {
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "INSERT INTO books(title,author,publisher,publisher_year,quantity,category_id)" +
                    "VALUES" +
                    "(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,b.getTitle());
            pst.setString(2,b.getAuthor());
            pst.setString(3,b.getPublisher());
            pst.setInt(4,b.getPublisher_year());
            pst.setInt(5,b.getQuantity());
            pst.setInt(6,b.getCategory_id());
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoa(Integer s){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "delete from books" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,s);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sua(books b){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Update books" +
                    "set" +
                    "title = ?" +
                    "author = ?" +
                    "publisher = ?" +
                    "publisher_year = ?" +
                    "quantity = ?" +
                    "category_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,b.getTitle());
            pst.setString(2,b.getAuthor());
            pst.setString(3,b.getPublisher());
            pst.setInt(4,b.getPublisher_year());
            pst.setInt(5,b.getQuantity());
            pst.setInt(6,b.getCategory_id());
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public books xemChiTiet(books b){
        books ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql ="Select * from books" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,b.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                ketqua = new books(id,title,author,publisher,publisher_year,quantity,category_id);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList<books> hienThiTatCa(){
        ArrayList<books> ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "Select * from books";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                books ketqua2 = new books(id,title,author,publisher,publisher_year,quantity,category_id);
                ketqua.add(ketqua2);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public books timTheoTenTacGia(String s){
        books ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from books" +
                    "where author = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                ketqua = new books(id,title,author,publisher,publisher_year,quantity,category_id);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList sachConHang(){
        ArrayList<books> ketqua1 = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from books" +
                    "where quantity > 0 ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                books ketqua2 = new books(id,title,author,publisher,publisher_year,quantity,category_id);
                ketqua1.add(ketqua2);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua1;
    }

    public books timTenGanDung(String s){
        books ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from books" +
                    "where title = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"%" + s + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                ketqua = new books(id,title,author,publisher,publisher_year,quantity,category_id);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList<books> locTheoTheLoai(Integer i){
        ArrayList<books> ketqua1 = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from books" +
                    "where category_id = " + i;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                books ketqua2 = new books(id,title,author,publisher,publisher_year,quantity,category_id);
                ketqua1.add(ketqua2);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua1;
    }

    public void themSoLuong(int a, int b){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "update books" +
                    "where id = ?" +
                    "set" +
                    "quantity += ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            pst.setInt(2,b);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void giamSoLuong(int a, int b){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "update books" +
                    "where id = ?" +
                    "set" +
                    "quantity -= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            pst.setInt(2,b);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public books timTheoId(int a){
        books ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from books" +
                    "where int = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publisher_year = rs.getInt("publisher_year");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                ketqua = new books(id,title,author,publisher,publisher_year,quantity,category_id);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}

