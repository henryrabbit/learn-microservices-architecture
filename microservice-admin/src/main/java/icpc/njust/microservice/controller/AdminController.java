package icpc.njust.microservice.controller;

import icpc.njust.microservice.dao.AdminDao;
import icpc.njust.microservice.pojo.Admin;
import icpc.njust.microservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public Admin getadmin(@PathVariable(name="username") String username){
        return adminService.get(username);
    }
}