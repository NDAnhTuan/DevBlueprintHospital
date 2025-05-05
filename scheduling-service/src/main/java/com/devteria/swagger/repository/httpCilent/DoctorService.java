package com.devteria.swagger.repository.httpCilent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devteria.swagger.dto.response.DoctorCreationResponse;

@FeignClient(name = "doctor-service", url = "${app.services.doctor}")
public interface DoctorService {
    @PostMapping(value = "/doctors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DoctorCreationResponse getDoctorResponse(@PathVariable("id") String id);
}
