package com.resource.information.system.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Teacher")
public class Teacher {
    @Id
    private String teacherId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String city;
    private String county;
    private List<String> subjects;
}
