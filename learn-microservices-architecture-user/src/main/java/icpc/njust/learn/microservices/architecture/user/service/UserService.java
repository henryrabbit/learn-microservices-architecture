package icpc.njust.learn.microservices.architecture.user.service;

public interface UserService {
    public String login(String username, String password);
    public String register(String username, String password, String phonenumber);
}
