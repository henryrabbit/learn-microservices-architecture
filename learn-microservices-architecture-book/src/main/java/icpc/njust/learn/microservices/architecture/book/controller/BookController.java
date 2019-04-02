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
    public Page<Book> findall(@PathVariable(name="pagenumber") int pagenumber,
                               @PathVariable(name="pagesize") int pagesize ){
        return bookService.findall(pagenumber,pagesize);
    }

    @RequestMapping(value = "/findbyname/{bookname}", method = RequestMethod.GET)
    public Page<Book> findbyname(@PathVariable(name = "bookname") String bookname){
        System.out.println(bookname);
        Book book = new Book();
        book.setBookname(bookname);
        return bookService.findbook(book,0,1000);
    }

    @RequestMapping(value = "/find/{book}/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Page<Book> find( @PathVariable(name = "book") Book book,
                            @PathVariable(name="pagenumber") int pagenumber,
                            @PathVariable(name="pagesize") int pagesize ){
        return bookService.findbook(book, pagenumber, pagesize);
    }

    @RequestMapping(value="/add/{bookname}/{isbn}/{edition}/{booksize}/{publicationtime}/{wordcount}/{language}/{number}/{lent}", method = RequestMethod.POST)
    public boolean addbook(
                           @PathVariable(name="bookname") String bookname,
                           @PathVariable(name="isbn")String isbn,
                           @PathVariable(name="edition") String edition,
                           @PathVariable(name="booksize")String booksize,
                           @PathVariable(name="publicationtime") String publicationtime,
                           @PathVariable(name="wordcount")String wordcount,
                           @PathVariable(name="language")String language,
                           @PathVariable(name="number")int number,
                           @PathVariable(name="lent")int lent){
        Book book=new Book();
        book.setBookname(bookname);
        book.setIsbn(isbn);
        book.setPublicationtime(publicationtime);
        book.setEdition(edition);
        book.setBooksize(booksize);
        book.setWordcount(wordcount);
        book.setLanguage(language);
        book.setNumber(number);
        book.setLent(lent);
        System.out.print("hehe");
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
