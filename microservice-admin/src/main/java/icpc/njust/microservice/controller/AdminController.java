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

    @RequestMapping(value="/login/{username}/{password}", method = RequestMethod.POST)
    public Boolean getadmin(  @PathVariable(name="username") String username,
                            @PathVariable(name="password") String password){
        return adminService.logincheck(username, password);
    }
}
