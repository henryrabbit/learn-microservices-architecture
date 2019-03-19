package icpc.njust.microservice.service;

import icpc.njust.microservice.dao.AdminDao;
import icpc.njust.microservice.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AdminService {
    Admin get(String uername);
}
