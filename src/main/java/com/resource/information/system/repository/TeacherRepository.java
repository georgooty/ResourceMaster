package com.resource.information.system.repository;

import com.resource.information.system.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface TeacherRepository extends MongoRepository<Teacher,String> {

}
