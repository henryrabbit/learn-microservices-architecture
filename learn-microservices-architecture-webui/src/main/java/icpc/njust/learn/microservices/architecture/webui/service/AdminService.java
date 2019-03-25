package icpc.njust.learn.microservices.architecture.webui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "learn-microservices-architecture-admin")
@RequestMapping("/admin")
public interface AdminService {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password);

}
