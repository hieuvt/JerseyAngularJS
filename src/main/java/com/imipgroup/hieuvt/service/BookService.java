package com.imipgroup.hieuvt.service;

import com.imipgroup.hieuvt.dao.BookDAO;
import com.imipgroup.hieuvt.entity.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hieu.vutrong on 1/27/2015.
 */
@Component
public class BookService {

    @Autowired
    BookDAO bookDAO;
    public BookService(){
    }

    public List<BookVO> getAllBooks() {
        return bookDAO.listBooks();
    }

    public BookVO getBucket(int id) {
        return bookDAO.getBook(id);
    }

    public BookVO createBook(BookVO bookVO){
        return bookDAO.createNewBook(bookVO);
    }

    public BookVO updateBookInfo(BookVO bookVO) {
        return bookDAO.updateBookInfo(bookVO);
    }

    public void removeBook(int id) {
        bookDAO.removeBook(id);
    }
}
