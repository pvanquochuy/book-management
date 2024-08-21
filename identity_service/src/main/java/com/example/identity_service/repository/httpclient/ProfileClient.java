package com.example.identity_service.repository.httpclient;

import com.example.identity_service.configuration.AuthenticationRequestIntereptor;
import com.example.identity_service.dto.request.ApiResponse;
import com.example.identity_service.dto.request.ProfileCreationRequest;
import com.example.identity_service.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "profile-service", url = "${app.services.profile}",
                configuration = { AuthenticationRequestIntereptor.class })
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreationRequest request);

}
