package icpc.njust.learn.microservices.architecture.book.service;

import icpc.njust.learn.microservices.architecture.book.pojo.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    public void createbook(Book book);
    public void updatebook(Book book);
    public void deletebook(String id);
    public Book findbyid(String id);
    public Page<Book> findbook(Book book, int pagenumber, int pagesize);
    public Page<Book> findall(int pagenumber, int pagesize);
    public boolean lentbook(String id);
    public boolean returnbook(String id);
}
