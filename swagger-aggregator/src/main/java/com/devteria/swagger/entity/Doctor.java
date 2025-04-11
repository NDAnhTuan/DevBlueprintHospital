package com.devteria.swagger.entity;

// import org.springframework.data.neo4j.core.schema.GeneratedValue;
// import org.springframework.data.neo4j.core.schema.Id;
// import org.springframework.data.neo4j.core.schema.Node;
// import org.springframework.data.neo4j.core.schema.Property;
// import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// @Node("user_profile")

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String firstName;
    String lastName;
    String specialty;
    String phoneNumber;
    String email;
}
