package icpc.njust.microservice.dao;

import icpc.njust.microservice.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AdminDao extends JpaRepository<Admin, String> {

}
