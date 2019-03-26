package icpc.njust.learn.microservices.architecture.webui.service;

import icpc.njust.learn.microservices.architecture.webui.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
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
    public Page<Book> getadmin(@PathVariable(name="pagenumber") int pagenumber,
                               @PathVariable(name="pagesize") int pagesize );

    @RequestMapping(value = "/find/{book}/{pagenumber}/{pagesize}", method = RequestMethod.GET)
    public Page<Book> find( @PathVariable(name = "book") Book book,
                            @PathVariable(name="pagenumber") int pagenumber,
                            @PathVariable(name="pagesize") int pagesize );

    @RequestMapping(value="/add/{book}", method = RequestMethod.POST)
    public boolean addbook(@PathVariable(name="book") Book book);

    @RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.POST)
    public boolean deletebyid(@PathVariable(name="id") String id);

    @RequestMapping(value = "/update/{book}", method = RequestMethod.POST)
    public boolean updatebyid(@PathVariable(name="book") Book book);
}
