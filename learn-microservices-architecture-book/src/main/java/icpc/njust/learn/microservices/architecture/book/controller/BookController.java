package icpc.njust.learn.microservices.architecture.book.controller;

import icpc.njust.learn.microservices.architecture.book.pojo.Book;
import icpc.njust.learn.microservices.architecture.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Book getadmin(@PathVariable(name="id") String id){
        Book book = bookService.findbyid(id);
        return book;
    }

    @RequestMapping(value="/all/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Page<Book> getadmin( @PathVariable(name="pagenumber") int pagenumber,
                                @PathVariable(name="pagesize") int pagesize ){
        return bookService.findall(pagenumber,pagesize);
    }


}
