package com.works.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Size(min = 1, max = 100)
    @NotEmpty
    @NotNull
    private String name;

    @Email
    @Size(min = 5, max = 100)
    @NotEmpty
    @NotNull
    private String email;

    @Size(min = 2, max = 10)
    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String city;
    private String remember;

}
