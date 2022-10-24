package com.resource.information.system.service;

import com.resource.information.system.domain.Teacher;
import com.resource.information.system.dto.request.TeacherRequest;
import com.resource.information.system.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    TeacherRepository repository;

    public Teacher saveTeacher(TeacherRequest teacherRequest){
        Teacher teacher = new Teacher();
        teacher.setBirthDate(teacherRequest.getBirthDate());
        teacher.setCity(teacherRequest.getCity());
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setCounty(teacherRequest.getCounty());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setSubjects(teacherRequest.getSubjects());
        Teacher t = repository.save(teacher);

        return t;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        repository.save(teacher);
        return true;
    }

    @Override
    public boolean deleteTeacherById(Teacher teacher) {
        repository.delete(teacher);
        return true;
    }

    public Teacher getTeacherDetailsById(String id ){
        return repository.findById(id).get();
    }

    @Override
    public List<Teacher> getAllTeachers() {
       return repository.findAll();
    }
}
