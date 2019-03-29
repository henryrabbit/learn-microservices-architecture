package icpc.njust.learn.microservices.architecture.webui.controller;

import icpc.njust.learn.microservices.architecture.webui.pojo.Book;
import icpc.njust.learn.microservices.architecture.webui.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    BookService bookService;
    @RequestMapping(value = "/test/book")
    public Object testbook(){
        return bookService.findall(0,1000);
    }

    @RequestMapping(value = "findbyid")
    public Book findbyid(){
        return bookService.getbyid("1");
    }
}
