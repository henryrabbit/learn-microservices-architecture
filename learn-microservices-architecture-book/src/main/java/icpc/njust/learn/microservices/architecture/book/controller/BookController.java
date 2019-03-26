package icpc.njust.learn.microservices.architecture.book.controller;

import icpc.njust.learn.microservices.architecture.book.pojo.Book;
import icpc.njust.learn.microservices.architecture.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Book getbyid(@PathVariable(name="id") String id){
        Book book = bookService.findbyid(id);
        return book;
    }

    @RequestMapping(value="/all/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Page<Book> getadmin(@PathVariable(name="pagenumber") int pagenumber,
                               @PathVariable(name="pagesize") int pagesize ){
        return bookService.findall(pagenumber,pagesize);
    }

    @RequestMapping(value = "/find/{book}/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Page<Book> find( @PathVariable(name = "book") Book book,
                            @PathVariable(name="pagenumber") int pagenumber,
                            @PathVariable(name="pagesize") int pagesize ){
        return bookService.findbook(book, pagenumber, pagesize);
    }

    @RequestMapping(value="/add/{book}", method = RequestMethod.POST)
    public boolean addbook(@PathVariable(name="book") Book book){
        bookService.createbook(book);
        return true;
    }

    @RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.POST)
    public boolean deletebyid(@PathVariable(name="id") String id){
        bookService.deletebook(id);
        return true;
    }

    @RequestMapping(value = "/update/{book}", method = RequestMethod.POST)
    public boolean updatebyid(@PathVariable(name="book") Book book){
        bookService.updatebook(book);
        return true;
    }

}
