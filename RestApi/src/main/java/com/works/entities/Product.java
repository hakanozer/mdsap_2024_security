package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Product extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String title;
    @Max(100000)
    @Min(2)
    @NotNull
    private Integer price;

}
