package com.devteria.swagger.repository.httpCilent;

import com.devteria.swagger.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devteria.swagger.dto.response.DoctorCreationResponse;

@FeignClient(name = "doctor-service", url = "${app.services.doctor}")
public interface DoctorService {
    @GetMapping(value = "/internal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<DoctorCreationResponse> getDoctorResponse(@PathVariable("id") String id);
}
