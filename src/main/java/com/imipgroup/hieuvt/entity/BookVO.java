package com.imipgroup.hieuvt.entity;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BookVO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column
    private String bookName;

    @Column
    private String author;

    public BookVO(){

    }

    public BookVO (int bookId, String bookName, String author){
        setBookId(bookId);
        setBookName(bookName);
        setAuthor(author);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", name='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}