package model;

import DAO.borrowingsDAO;

import java.sql.Date;
import java.sql.Timestamp;

public class borrowings {
    private int id;
    private  int reader_id;
    private Date borrow_date;
    private Date due_date;
    private Date return_date;
    private String status;

    public borrowings(int id, int reader_id, Date borrow_date,
                      Date due_date, Date return_date, String status) {
        this.id = id;
        this.reader_id = reader_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.status = status;
        borrowingsDAO.getInstance().capNhatQuaHan();
    }

    public borrowings(int reader_id, Date due_date) {
        this.reader_id = reader_id;
        this.borrow_date = new Date(System.currentTimeMillis());
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
