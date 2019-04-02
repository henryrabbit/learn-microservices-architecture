package icpc.njust.learn.microservices.architecture.book.dao;

import icpc.njust.learn.microservices.architecture.book.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book> {


}
