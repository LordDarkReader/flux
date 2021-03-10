package com.czaki.web.flux.repository;

import com.czaki.web.flux.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepoStudent extends ReactiveMongoRepository<Student, String> {
}
