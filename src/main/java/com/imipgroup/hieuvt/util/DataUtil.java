package com.imipgroup.hieuvt.util;

import com.imipgroup.hieuvt.entity.BookVO;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by hieu.vutrong on 1/27/2015.
 */
public class DataUtil {

    private static DataUtil instance = new DataUtil();

    public static DataUtil getInstance() {
        return instance;
    }

    private static final int NUM_BOOK = 5;
    public DataUtil(){
        Session session = SessionUtil.getSession();

        for (int i = 0; i < NUM_BOOK; i++){
            Transaction transaction = session.beginTransaction();
            BookVO bookVO = new BookVO();
            bookVO.setBookName("Book " + i);
            bookVO.setAuthor("Author " + i);
            session.save(bookVO);
            transaction.commit();
        }

        session.close();
    }
}
