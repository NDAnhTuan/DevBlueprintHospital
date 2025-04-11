package com.devteria.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devteria.swagger.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {}
