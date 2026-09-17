package DAO;

import library.DatabaseConnection;
import model.categories;

import java.sql.*;
import java.util.ArrayList;

public class categoriesDAO {
    public static categoriesDAO getInstance(){
        return new categoriesDAO();
    }

    public void them(categories c){
        ArrayList<categories> arrayList = categoriesDAO.getInstance().hienThiTatCa();
        for(categories categories : arrayList){
            if(c.getName().equals(categories.getName())){
                System.out.println("Thể loại này đã được thêm vào");
                return;
            }
        }
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "insert into categories(name,description)" +
                    "values" +
                    "(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,c.getName());
            pst.setString(2,c.getDescription());
            pst.executeUpdate();
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không thể thêm thể loại");
        }
    }

    public void xoa(int a){
        ArrayList<categories> arrayList = categoriesDAO.getInstance().hienThiTatCa();
        for(categories categories : arrayList){
            if(categoriesDAO.getInstance().timTheoId(a).getId() == categories.getId()){
                System.out.println("Không thể xóa thể loại đang có sách");
                return;
            }
        }

        try{
            Connection con = DatabaseConnection.getConnection();
            String sql = "delete from categories" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
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
            String sql = "select * from categories";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                categories categories = new categories(id,name,description);
                ketqua.add(categories);
            }
            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi không thể hiện thị tất cả thể loại đang có");
        }
        return ketqua;
    }

    public categories timTheoId(int a){
        categories ketqua = null;
        try{
            Connection con = DatabaseConnection.getConnection();
            String sql ="Select * from categories" +
                    "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,a);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                ketqua = new categories(id, name, description);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi không tìm được thể loại");
        }
        return ketqua;
    }
}
