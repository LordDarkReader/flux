package com.czaki.web.flux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class FluxApplicationTests {

    @Test
    void contextLoads() {

        Flux.just("dupa", "dasd", "dsadsad", "dasdsad", "adsad" , "asdawecx")
                .filter( name  -> name.startsWith("a"))
                .subscribe(System.out::println);
    }

}
