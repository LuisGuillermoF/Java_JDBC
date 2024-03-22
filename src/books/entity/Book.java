package books.entity;

import autors.entity.Autor;

public class Book {
    private int id ;

    private String title ;

    private String year_published ;

    private double price ;

    private int idAutor ;


    public Book(int id, String title, String year_published, double price, int idAutor) {
        this.id = id;
        this.title = title;
        this.year_published = year_published;
        this.price = price;
        this.idAutor = idAutor;
    }

    public Book() {
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

    public String getYear_published() {
        return year_published;
    }

    public void setYear_published(String year_published) {
        this.year_published = year_published;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year_published='" + year_published + '\'' +
                ", price=" + price +
                ", idAutor=" + idAutor +
                '}';
    }
}
