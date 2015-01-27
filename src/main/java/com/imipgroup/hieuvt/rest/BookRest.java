package com.imipgroup.hieuvt.rest;

import com.imipgroup.hieuvt.dao.BookDAO;
import com.imipgroup.hieuvt.entity.BookVO;
import com.imipgroup.hieuvt.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
@Component
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})

public class BookRest {

    @Autowired
    BookService bookService;

    protected final Logger log = LoggerFactory.getLogger(BookRest.class);

    @GET
    @Path("{id}")
    public BookVO getBucket(@PathParam("id") String id) {
        Integer bookId = new Integer(id);
        return bookService.getBucket(bookId);
    }

    @GET
    public List<BookVO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @POST
    public BookVO createBook(BookVO bookVO) {
        return bookService.createBook(bookVO);
    }

    @PUT
    public BookVO updateBookInfo(BookVO bookVO) {
        return bookService.updateBookInfo(bookVO);
    }

    @DELETE
    @Path("{id}")
    public void removeBook(@PathParam("id") String id) {
        Integer bookId = new Integer(id);
        bookService.removeBook(bookId);
    }


}