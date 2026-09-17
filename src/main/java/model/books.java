package model;

public class books {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publisher_year;
    private int quantity;
    private int category_id;

    public books(int id, String title, String author, String publisher, int publisher_year, int quantity, int category_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publisher_year = publisher_year;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public books(String title, String author, String publisher, int publisher_year, int quantity, int category_id) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publisher_year = publisher_year;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublisher_year() {
        return publisher_year;
    }

    public void setPublisher_year(int publisher_year) {
        this.publisher_year = publisher_year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "books: " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", publisher = '" + publisher + '\'' +
                ", publisher_year = " + publisher_year +
                ", quantity = " + quantity +
                ", category_id = " + category_id ;
    }
}
