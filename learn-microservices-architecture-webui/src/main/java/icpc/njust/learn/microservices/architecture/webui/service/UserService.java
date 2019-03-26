package icpc.njust.learn.microservices.architecture.webui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "learn-microservices-architecture-user")
@RequestMapping("/user")
public interface UserService {
    @RequestMapping(value="/login/{username}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable(name="username") String username,
                        @PathVariable(name="password") String password);

    @RequestMapping(value="/register/{username}/{password}/{phonenumber}", method = RequestMethod.POST)
    public String register( @PathVariable(name="username") String username,
                            @PathVariable(name="password") String password,
                            @PathVariable(name="phonenumber") String phonenumber);
}
