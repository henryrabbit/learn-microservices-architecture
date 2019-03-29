package icpc.njust.learn.microservices.architecture.webui.controller;

import icpc.njust.learn.microservices.architecture.webui.pojo.Book;
import icpc.njust.learn.microservices.architecture.webui.pojo.User;
import icpc.njust.learn.microservices.architecture.webui.service.AdminService;
import icpc.njust.learn.microservices.architecture.webui.service.BookService;
import icpc.njust.learn.microservices.architecture.webui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/th")
public class WebuiController {
    @Autowired
    AdminService adminService;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView ind(ModelAndView modelAndView){
        modelAndView.addObject("bookpage",bookService.findall(0,1000));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/managerLogin", method = RequestMethod.GET)
    public ModelAndView managerLogin(ModelAndView modelAndView){
        User user = new User();
        user.setUsername("");
        user.setPassword("");
        modelAndView.addObject(user);
        modelAndView.setViewName("managerlogin");
        return modelAndView;
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public ModelAndView userLogin(ModelAndView modelAndView){
        User user = new User();
        user.setUsername("");
        user.setPassword("");
        modelAndView.addObject(user);
        modelAndView.setViewName("userLogin");
        return modelAndView;
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public ModelAndView userRegister(ModelAndView modelAndView){
        User user = new User();
        user.setUsername("");
        user.setPassword("");
        modelAndView.addObject(user);
        String psw="";
        modelAndView.addObject(psw);
        modelAndView.setViewName("userRegister");
        return modelAndView;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ModelAndView userregister(User user, ModelAndView modelAndView){
        if(user==null || user.getPassword()==null || user.getPassword().equals("") || user.getUsername()==null || user.getUsername().equals("")){
            modelAndView.addObject("error","用户名密码不能为空！");
            modelAndView.setViewName("userRegister");
            return modelAndView;
        }
        String psw = user.getPhonenumber();
        if(psw==null || psw.equals("") || !user.getPassword().equals(psw)){
            modelAndView.addObject("error","两遍密码不一致！");
            modelAndView.setViewName("userRegister");
            return modelAndView;
        }
        String s = userService.register(user.getUsername(),user.getPassword(),psw);
        System.out.println(s);
        if(s.equals("注册成功")){
            modelAndView.addObject("error","注册成功，请登录！");
            modelAndView.setViewName("userLogin");
        }
        else{
            modelAndView.addObject("error",s);
            modelAndView.setViewName("userRegister");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ModelAndView userlogin(User user, ModelAndView modelAndView){
        if(user==null || user.getPassword()==null || user.getPassword().equals("") || user.getUsername()==null || user.getUsername().equals("")){
            modelAndView.addObject("error","用户名密码不能为空！");
            modelAndView.setViewName("userLogin");
            return modelAndView;
        }
        String s = userService.login(user.getUsername(), user.getPassword());
        System.out.println(s);
        if(s.equals("登录成功")){
            modelAndView.addObject("username",user.getUsername());
            modelAndView.addObject("bookpage",bookService.findall(0,1000));
            user.setPassword("");
            modelAndView.addObject(user);
            modelAndView.setViewName("index");
        }
        else{
            modelAndView.addObject("error",s);
            modelAndView.setViewName("userLogin");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/manager/login", method = RequestMethod.POST)
    public ModelAndView managerlogin(User user, ModelAndView modelAndView){
        if(user==null || user.getPassword()==null || user.getPassword().equals("") || user.getUsername()==null || user.getUsername().equals("")){
            modelAndView.addObject("error","用户名密码不能为空！");
            modelAndView.setViewName("managerlogin");
            return modelAndView;
        }
        String s = adminService.login(user.getUsername(), user.getPassword());
        System.out.println(s);
        if(s.equals("success")){
            modelAndView.addObject("username",user.getUsername());
            modelAndView.setViewName("deletebook");
        }
        else{
            modelAndView.addObject("error","用户名或密码错误");
            modelAndView.setViewName("managerlogin");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/book/find", method = RequestMethod.GET)
    public ModelAndView bookfind(User user, ModelAndView modelAndView){
        System.out.println(user.getPassword()+user.getUsername());
        modelAndView.addObject("bookpage",bookService.findbyname(user.getPassword()));
        modelAndView.addObject("username",user.getUsername());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
