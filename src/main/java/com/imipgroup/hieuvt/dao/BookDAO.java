package com.imipgroup.hieuvt.dao;

import com.imipgroup.hieuvt.entity.BookVO;
import com.imipgroup.hieuvt.util.DataUtil;
import com.imipgroup.hieuvt.util.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
public class BookDAO {

    private static BookDAO instance = new BookDAO();
    public static BookDAO getInstance() {
        return instance;
    }

    private List<BookVO> books;

    public BookDAO() {
        DataUtil.getInstance();
    }

  /*  public BookVO getBookByName(String bookName){
        for (BookVO book: books){
            if (book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }*/

    public BookVO getBook(int bookId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        BookVO bookVO = (BookVO) session.get(BookVO.class, bookId);

        transaction.commit();
        session.close();
        return bookVO;
    }

    public BookVO createNewBook(BookVO bookVO){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(bookVO);

        transaction.commit();
        session.close();
        return bookVO;
    }

    public BookVO updateBookInfo(BookVO bookVO){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        BookVO tmpBook = (BookVO)session.get(BookVO.class, bookVO.getBookId());
        tmpBook.setAuthor(bookVO.getAuthor());
        tmpBook.setBookName(bookVO.getBookName());

        transaction.commit();
        session.close();
        return tmpBook;
    }

    public void removeBook(int bookId){

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        BookVO bookVO = (BookVO) session.get(BookVO.class, bookId);
        session.delete(bookVO);

        transaction.commit();
        session.close();
    }

    public List<BookVO> listBooks() {

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BookVO b");
        List<BookVO> bookVOs = query.list();
        transaction.commit();
        session.close();
        return bookVOs;
    }

}
