package icpc.njust.learn.microservices.architecture.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AdminService {
    Boolean logincheck(String uername, String password);
}

