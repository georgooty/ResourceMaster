package com.resource.information.system.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String city;
    private String country;
}
