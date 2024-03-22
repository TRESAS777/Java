package entity;

public class Book {

    private int id;
    private String title;
    private int yearPublication;
    private double price;
    private int idAuthor;

    public Book() {
    }

    public Book(int id, String title, int yearPublication, double price, int idAuthor) {
        this.id = id;
        this.title = title;
        this.yearPublication = yearPublication;
        this.price = price;
        this.idAuthor = idAuthor;
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

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Override
    public String  toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                ", price=" + price +
                ", idAuthor=" + idAuthor +
                '}';
    }
}
