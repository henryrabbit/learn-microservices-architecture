package icpc.njust.learn.microservices.architecture.webui.service;

import icpc.njust.learn.microservices.architecture.webui.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "learn-microservices-architecture-book")
@RequestMapping("/book")
public interface BookService {

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    public Book getbyid(@PathVariable(name="id") String id);

    @RequestMapping(value="/all/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Object findall(@PathVariable(name="pagenumber") int pagenumber,
                              @PathVariable(name="pagesize") int pagesize );

    @RequestMapping(value = "/findbyname/{bookname}", method = RequestMethod.GET)
    public Object findbyname(@PathVariable(name = "bookname") String bookname);

    @RequestMapping(value = "/find/{book}/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Object find( @PathVariable(name = "book") Book book,
                            @PathVariable(name="pagenumber") int pagenumber,
                            @PathVariable(name="pagesize") int pagesize );

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
            @PathVariable(name="lent")int lent);

    @RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.POST)
    public boolean deletebyid(@PathVariable(name="id") String id);

    @RequestMapping(value = "/update/{book}", method = RequestMethod.POST)
    public boolean updatebyid(@PathVariable(name="book") Book book);
}
