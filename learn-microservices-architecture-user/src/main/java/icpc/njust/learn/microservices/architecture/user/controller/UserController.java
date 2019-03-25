package icpc.njust.learn.microservices.architecture.user.controller;

import icpc.njust.learn.microservices.architecture.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login/{username}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable(name="username") String username,
                           @PathVariable(name="password") String password){
        return userService.login(username,password);
    }

    @RequestMapping(value="/register/{username}/{password}/{phonenumber}", method = RequestMethod.GET)
    public String register( @PathVariable(name="username") String username,
                            @PathVariable(name="password") String password,
                            @PathVariable(name="phonenumber") String phonenumber){
        return userService.register(username,password,phonenumber);
    }
}
