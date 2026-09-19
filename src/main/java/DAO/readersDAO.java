package DAO;

import library.DatabaseConnection;
import model.readers;

import java.sql.*;
import java.util.ArrayList;

public class readersDAO {
    public static readersDAO getInstance(){
        return new readersDAO();
    }
    public void them(readers r){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Insert into readers(full_name,email,phone,address,created_at)" +
                    "Values" +
                    "(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,r.getFull_name());
            pst.setString(2,r.getEmail());
            pst.setString(3,r.getPhone());
            pst.setString(4,r.getAddress());
            pst.setTimestamp(5, Timestamp.valueOf(r.getCreated_at()));
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không thêm được sách");
        }
    }

    public void xoa (int s){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "delete from readers" +
                    "where full_name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,s);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không xóa được sách");
        }
    }

    public void sua(readers r, int a){
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "update readers" +
                    "set" +
                    "full_name = ?" +
                    "email = ?" +
                    "phone = ?" +
                    "address = ?" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,r.getFull_name());
            pst.setString(2,r.getEmail());
            pst.setString(3,r.getPhone());
            pst.setString(4,r.getAddress());
            pst.setInt(5,a);
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không sửa được sách");
        }
    }

    public ArrayList<readers> hienThiTatCa(){
        ArrayList<readers> ketqua = new ArrayList<>();
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "Select * from readers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                readers readers = new readers(id,full_name,email,phone,address, created_at.toLocalDateTime());
                ketqua.add(readers);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không hiển thị được tất cả sách");
        }
        return ketqua;
    }
    public readers timTheoTen(String s){
        readers ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from readers" +
                    "where full_name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,s);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                ketqua = new readers(id,full_name,email,phone,address, created_at.toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm được sách theo tên");
        }
        return ketqua;
    }

    public readers timTheoemail(String s){
        readers ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from readers" +
                    "where email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,s);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                ketqua = new readers(id,full_name,email,phone,address, created_at.toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm được sách theo email");
        }
        return ketqua;
    }

    public readers timTheosdt(String s){
        readers ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from readers" +
                    "where phone = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,s);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                ketqua = new readers(id,full_name,email,phone,address, created_at.toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm được sách theo sđt");
        }
        return ketqua;
    }

    public readers timTheoId(int a){
        readers ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "select * from readers" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Timestamp created_at = rs.getTimestamp("created_at");
                ketqua = new readers(id,full_name,email,phone,address, created_at.toLocalDateTime());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm sách theo ID");
        }
        return ketqua;
    }
}
