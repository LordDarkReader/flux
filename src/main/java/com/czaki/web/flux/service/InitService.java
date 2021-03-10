package com.czaki.web.flux.service;

import com.czaki.web.flux.model.Student;
import com.czaki.web.flux.repository.RepoStudent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {

    private RepoStudent repoStudent;

    public InitService(RepoStudent repoStudent) {
        this.repoStudent = repoStudent;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {

        repoStudent.deleteAll()
                .thenMany(Flux.just("Michał", "Zuzanna", "Jadwiga", "Karol", "Wojtek" , "Ewelina")
                ).map(name ->  new Student(name))
                .flatMap(repoStudent::save)
                .thenMany(repoStudent.findAll())
                .subscribe(System.out::println);

        repoStudent.save(new Student("Wiesio")).subscribe();
    }
}
