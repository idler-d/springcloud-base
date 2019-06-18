package com.idler.demo.auth.client;

import com.idler.demo.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}