package com.devteria.profile.entity;

import java.time.LocalDate;

//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.data.neo4j.core.schema.Property;
//import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
