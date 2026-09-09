package model;

public class borrowing_details {
    private int id;
    private int borrowing_id;
    private int book_id;
    private int quantity;

    public borrowing_details(int id, int borrowing_id,int book_id, int quantity) {
        this.id = id;
        this.borrowing_id = borrowing_id;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrowing_id() {
        return borrowing_id;
    }

    public void setBorrowing_id(int borrowing_id) {
        this.borrowing_id = borrowing_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
