package com.example.api_getway.service;


import com.example.api_getway.dto.request.IntrospectRequest;
import com.example.api_getway.dto.responsse.ApiResponse;
import com.example.api_getway.dto.responsse.IntrospectResponse;
import com.example.api_getway.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){

        return identityClient.introspect(IntrospectRequest.builder()
                        .token(token)
                .build());
    }
}
