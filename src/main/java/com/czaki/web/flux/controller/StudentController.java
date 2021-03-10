package com.czaki.web.flux.controller;

import com.czaki.web.flux.model.Student;
import com.czaki.web.flux.repository.RepoStudent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudentController {

    private RepoStudent repoStudent;

    public StudentController(RepoStudent repoStudent) {
        this.repoStudent = repoStudent;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> getStudent(){
       return repoStudent.findAll().delayElements(Duration.ofSeconds(1));
    }
}
