package icpc.njust.learn.microservices.architecture.admin.controller;


import icpc.njust.learn.microservices.architecture.admin.service.AdminService;
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
        if(adminService.logincheck(username, password)){
            System.out.println("success");
            return true;
        }
        else{
            System.out.println("psw wrong");
            return false;
        }
    }
}
