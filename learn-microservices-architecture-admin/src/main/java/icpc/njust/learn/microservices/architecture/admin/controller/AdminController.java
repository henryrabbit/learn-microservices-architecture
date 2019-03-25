package icpc.njust.learn.microservices.architecture.admin.controller;


import icpc.njust.learn.microservices.architecture.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(  @RequestParam(name="username") String username,
                          @RequestParam(name="password") String password){
        if(adminService.logincheck(username, password)){
            return "success";
        }
        else{
            System.out.println("psw wrong");
            return "failed";
        }
    }
}
