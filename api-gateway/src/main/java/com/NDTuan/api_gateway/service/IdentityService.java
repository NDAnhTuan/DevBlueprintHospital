package com.NDTuan.api_gateway.service;

import com.NDTuan.api_gateway.dto.request.IntrospectRequest;
import com.NDTuan.api_gateway.dto.response.ApiResponse;
import com.NDTuan.api_gateway.dto.response.IntrospectResponse;
import com.NDTuan.api_gateway.repository.IdentityClient;
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
    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return identityClient.introspect(
                IntrospectRequest.builder()
                        .token(token)
                        .build()
        );
    }
}
