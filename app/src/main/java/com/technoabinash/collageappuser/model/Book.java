package com.technoabinash.collageappuser.model;

public class Book {
    private String BookName,downloadLink;

    public Book() {
    }

    public Book(String bookName, String downloadLink) {
        BookName = bookName;
        this.downloadLink = downloadLink;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
