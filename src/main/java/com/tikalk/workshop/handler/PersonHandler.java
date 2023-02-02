package com.tikalk.workshop.handler;

import com.tikalk.workshop.entity.Person;
import com.tikalk.workshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by sigals on 06/10/2018.
 */
@Service
public class PersonHandler {
    private final PersonService personService;

    @Autowired
    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> getPerson(ServerRequest serverRequest) {
        return ok().body(personService.get(Long.parseLong(serverRequest.pathVariable("id"))), Person.class);
    }

    public Mono<ServerResponse> listPeople(ServerRequest serverRequest) {
        return ok().body(personService.getAll(), Person.class);
    }

    public Mono<ServerResponse> createPerson(ServerRequest serverRequest) {
        return serverRequest.bodyToFlux(Person.class)
                .doOnNext(personService::storePerson)
                .then(ok().build());
    }
}
