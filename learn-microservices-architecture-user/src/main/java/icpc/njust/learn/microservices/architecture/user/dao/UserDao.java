package icpc.njust.learn.microservices.architecture.user.dao;

import icpc.njust.learn.microservices.architecture.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
