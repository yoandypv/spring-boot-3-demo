package com.yoandypv.boot3demo.controller;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class SampleController {

    private final ObservationRegistry observationRegistry;

    public SampleController(ObservationRegistry observationRegistry) {
        this.observationRegistry = observationRegistry;
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {

        if (name.startsWith("pe")) {
            throw new RuntimeException("el nombre no puede empezar con pe");
        }

       return Observation
               .createNotStarted("miapi.sayhello", observationRegistry)
               .observe(() -> "Hello:  " + name);
    }

}
