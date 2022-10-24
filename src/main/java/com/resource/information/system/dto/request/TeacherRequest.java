package com.resource.information.system.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String city;
    private String county;
    private List<String> subjects;
}
