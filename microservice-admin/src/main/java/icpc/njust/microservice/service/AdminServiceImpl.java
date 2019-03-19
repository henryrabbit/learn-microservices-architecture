package icpc.njust.microservice.service;

import icpc.njust.microservice.dao.AdminDao;
import icpc.njust.microservice.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin get(String uername) {
        return adminDao.findOne(uername);
    }
}
