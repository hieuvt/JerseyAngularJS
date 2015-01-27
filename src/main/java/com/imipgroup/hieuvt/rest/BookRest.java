package com.imipgroup.hieuvt.rest;

import com.imipgroup.hieuvt.dao.BookDAO;
import com.imipgroup.hieuvt.entity.BookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})

public class BookRest {

    protected final Logger log = LoggerFactory.getLogger(BookRest.class);

    @GET
    @Path("{id}")
    public BookVO getBucket(@PathParam("id") String id) {

        log.debug("id : " + id);
        Integer bookId = new Integer(id);
        BookVO bookVO = null;
        try {
            bookVO = BookDAO.getInstance().getBook(bookId);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return bookVO;
    }

    @GET
    public List<BookVO> getAllBooks() {
        return BookDAO.getInstance().listBooks();
    }

    @POST

    public BookVO createBook(BookVO bookVO) {
        return BookDAO.getInstance().createNewBook(bookVO);
    }

    @PUT
    public BookVO updateBookInfo(BookVO bookVO) {
        return BookDAO.getInstance().updateBookInfo(bookVO);
    }

    @DELETE
    @Path("{id}")
    public void removeBook(@PathParam("id") String id) {
        Integer bookId = new Integer(id);
        BookDAO.getInstance().removeBook(bookId);
    }


}