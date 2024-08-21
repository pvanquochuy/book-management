package com.example.api_getway.repository;

import com.example.api_getway.dto.request.IntrospectRequest;
import com.example.api_getway.dto.responsse.ApiResponse;
import com.example.api_getway.dto.responsse.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);
}
