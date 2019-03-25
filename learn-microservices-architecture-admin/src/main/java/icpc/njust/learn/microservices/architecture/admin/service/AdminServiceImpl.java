package icpc.njust.learn.microservices.architecture.admin.service;


import icpc.njust.learn.microservices.architecture.admin.dao.AdminDao;
import icpc.njust.learn.microservices.architecture.admin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Boolean logincheck(String uername, String password) {
        Optional<Admin> admin = adminDao.findById(uername);
        return admin.isPresent() && password.equals(admin.get().getPassword());
    }
}

