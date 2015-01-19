package com.imipgroup.hieuvt.rest;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="Book")
public class BookVO implements Serializable{

    private int bookId;
    private String bookName;
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
}