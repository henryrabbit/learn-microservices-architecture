package icpc.njust.learn.microservices.architecture.admin.dao;


import icpc.njust.learn.microservices.architecture.admin.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, String> {

}
