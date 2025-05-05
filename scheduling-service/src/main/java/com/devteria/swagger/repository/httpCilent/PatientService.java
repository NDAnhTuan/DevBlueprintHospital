package com.devteria.swagger.repository.httpCilent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devteria.swagger.dto.response.PatientResponse;

@FeignClient(name = "patient-service", url = "${app.services.patient}")
public interface PatientService {
    @PostMapping(value = "/patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientResponse getPatientResponse(@PathVariable("id") String id);
}
