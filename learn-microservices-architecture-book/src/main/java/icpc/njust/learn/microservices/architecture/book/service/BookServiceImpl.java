package icpc.njust.learn.microservices.architecture.book.service;

import icpc.njust.learn.microservices.architecture.book.dao.BookDao;
import icpc.njust.learn.microservices.architecture.book.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void createbook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void updatebook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deletebook(String id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book findbyid(String id) {
        return bookDao.findById(id).get();
    }

    @Override
    public Page<Book> findbook(Book book, int pageNumber, int pageSize) {
        System.out.println(book.getBookname());
        Pageable pageable=PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        Specification<Book> spec = new Specification<Book>() {        //查询条件构造
        @Override
        public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            List<Predicate> list = new ArrayList<Predicate>();
            if (book.getBookname()!=null && !book.getBookname().isEmpty()) {
                list.add(cb.like(root.get("bookname").as(String.class), "%" + book.getBookname() + "%"));
            }
            if (book.getAuthor()!=null && !book.getAuthor().isEmpty()) {
                list.add(cb.like(root.get("author").as(String.class), "%" + book.getAuthor() + "%"));
            }
            if(book.getPublish()!=null && !book.getPublish().isEmpty()){
                list.add(cb.like(root.get("publish").as(String.class), "%" + book.getPublish() + "%"));
            }
            if(book.getIsbn()!=null && !book.getIsbn().isEmpty()){
                list.add(cb.equal(root.get("isbn").as(String.class), book.getIsbn()));
            }
            if(book.getEdition()!=null && !book.getEdition().isEmpty()){
                list.add(cb.equal(root.get("edition").as(String.class), book.getEdition()));
            }
            return cb.and(list.toArray(new Predicate[list.size()]));
        }
    };
    return bookDao.findAll(spec, pageable);
}

    @Override
    public Page<Book> findall(int pageNumber, int pageSize) {
        Pageable pageable=PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
        return bookDao.findAll(pageable);
    }

    @Override
    public boolean lentbook(String id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        if(optionalBook.isPresent()==false) return false;
        Book book=optionalBook.get();
        if(book.getLent()>=book.getNumber()) return false;
        book.setLent(book.getLent()+1);
        return true;
    }

    @Override
    public boolean returnbook(String id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        if(optionalBook.isPresent()==false) return false;
        Book book=optionalBook.get();
        if(book.getLent()==0) return false;
        book.setLent(book.getLent()-1);
        return true;
    }
}
