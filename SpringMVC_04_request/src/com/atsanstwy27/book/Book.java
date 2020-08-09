package com.atkjs927.book;

public class Book {

    /**
     *     書名:<input type="text" name="bookName"/><br/>
     *     作者:<input type="text" name="author"/><br/>
     *     價格:<input type="text" name="price"/><br/>
     *     庫存:<input type="text" name="stock"/><br/>
     *     銷量:<input type="text" name="sales"/><br/>
     */

    private String bookName;
    private String author;
    private Double price;
    private Integer stock;
    private Integer sales;
    private Address address;

    public Book(String bookName, String author, Double price, Integer stock, Integer sales, Address address) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.address = address;
    }

    public Book() {
        super();
        System.out.println("book被創建...");
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", address=" + address +
                '}';
    }

}
