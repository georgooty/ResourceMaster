package com.resource.information.system.controller;

import com.resource.information.system.domain.Teacher;
import com.resource.information.system.dto.request.TeacherRequest;
import com.resource.information.system.dto.response.TeacherResponse;
import com.resource.information.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherDetailsById(@PathVariable(value = "id") String id){
        return new ResponseEntity<Teacher>(resourceService.getTeacherDetailsById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/teacher")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<Teacher>();
        resourceService.getAllTeachers().forEach(teachers::add);

        TeacherRequest request = new TeacherRequest();
        ResponseEntity<TeacherResponse> teacherResponse = restTemplate.postForEntity("", request, TeacherResponse.class);
        if(teacherResponse.getStatusCode().is2xxSuccessful()){

        }
        webClient = WebClient.builder().baseUrl("").build();
//      // .onStatus(HttpStatus::is5xxServerError,teacherResponse1 ->{
        TeacherResponse response = webClient.post().uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request),TeacherRequest.class)
                .retrieve()
               // .onStatus()
                .bodyToMono(TeacherResponse.class)
                .block();

        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/teacher/create")
    public ResponseEntity<TeacherResponse> createTeacher(@Valid @RequestBody TeacherRequest teacherRequest){
        Teacher teacher = resourceService.saveTeacher(teacherRequest);
        TeacherResponse response = new TeacherResponse();
        if(teacher == null){
            response.setMessage("Failed to create teacher");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setMessage("Successfully created");
        response.setTeacherId(teacher.getTeacherId());
        return new ResponseEntity<TeacherResponse>(response,HttpStatus.CREATED);
    }
}
