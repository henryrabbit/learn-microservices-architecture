package icpc.njust.learn.microservices.architecture.user.service;

import icpc.njust.learn.microservices.architecture.user.dao.UserDao;
import icpc.njust.learn.microservices.architecture.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public String login(String username, String password) {
        Optional<User> optionalUser = userDao.findById(username);
        if(optionalUser.isPresent() && optionalUser.get().getPassword().equals(password))
            return "登录成功";
        else if(optionalUser.isPresent())
            return "密码错误";
        else
            return  "用户名不存在";
    }

    @Override
    public String register(String username, String password, String phonenumber) {
        Optional<User> optionalUser = userDao.findById(username);
        if(optionalUser.isPresent()) return "用户名已存在";
        User user=new User(username,password,phonenumber,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),null);
        userDao.save(user);
        return  "注册成功";
    }
}
