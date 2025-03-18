package com.devblueprint.patient_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Node("user_profile")
@Entity
public class UserProfile {
    @Id
//    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

//    @Property("userId")
    @Column(name = "userId")
    String userId;
    String email;

    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
