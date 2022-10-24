package com.resource.information.system.service;

import com.resource.information.system.domain.Teacher;
import com.resource.information.system.dto.request.TeacherRequest;

import java.util.List;

public interface ResourceService {
    Teacher saveTeacher(TeacherRequest teacherRequest);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacherById(Teacher teacher);

    Teacher getTeacherDetailsById(String id );

    List<Teacher> getAllTeachers();
}
