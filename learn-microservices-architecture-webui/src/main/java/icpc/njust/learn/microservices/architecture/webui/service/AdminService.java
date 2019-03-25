package icpc.njust.learn.microservices.architecture.webui.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "learn-microservices-architecture-admin")
public interface AdminService {

}
