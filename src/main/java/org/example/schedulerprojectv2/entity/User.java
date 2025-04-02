package org.example.schedulerprojectv2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Email
    private String email;


}
