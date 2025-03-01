package com.example.PetProject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "email", unique = true, columnDefinition = "VARCHAR(255)")
    String email;

    String password;

    @ManyToMany
    // Tự động tạo bảng user_role và tự động
    // thực hiện add dữ liệu vào bảng user_role
    // cũng như khi get và delete
    Set<Role> roles;
}
