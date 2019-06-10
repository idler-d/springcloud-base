package com.idler.demo.passport.client;

import com.idler.demo.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient("user-service")
@Component
public interface UserClient extends UserApi {
}
