package service;

import DAO.booksDAO;
import DAO.borrowing_detailsDAO;
import DAO.borrowingsDAO;
import library.DatabaseConnection;
import model.borrowing_details;
import model.borrowings;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowingService {
    public void muonSach(borrowings b, int soLuong, String tenSach, List<borrowing_details> details) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        try{
            con.setAutoCommit(false);
            borrowingsDAO.getInstance().them(b,soLuong,tenSach);
            for(borrowing_details detail : details){
                borrowing_detailsDAO.getInstance().them(b.getId(),detail.getBook_id(),detail.getQuantity());
            }
            for(borrowing_details detail :details ){
                booksDAO.getInstance().giamSoLuong(detail.getBook_id(),detail.getQuantity());
            }
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        }
        finally {
            con.setAutoCommit(true);
            DatabaseConnection.closeConnection(con);
        }
    }

    public void traSach(borrowings b) throws SQLException{
        Connection con = DatabaseConnection.getConnection();
        try{
            con.setAutoCommit(false);
            borrowingsDAO.getInstance().xoa(b.getId());
            ArrayList<borrowing_details> details = borrowing_detailsDAO.getInstance().timTheoId(b.getId());
            for(borrowing_details detail : details){
                booksDAO.getInstance().themSoLuong(detail.getBook_id(),detail.getQuantity());
            }
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        }
        finally {
            con.setAutoCommit(true);
            DatabaseConnection.closeConnection(con);
        }
    }
}
