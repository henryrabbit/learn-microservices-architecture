package icpc.njust.learn.microservices.architecture.webui.controller;

import icpc.njust.learn.microservices.architecture.webui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebuiController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login(  @RequestParam(name="username") String username,
                          @RequestParam(name="password") String password){
        return adminService.login(username, password);
    }
}
