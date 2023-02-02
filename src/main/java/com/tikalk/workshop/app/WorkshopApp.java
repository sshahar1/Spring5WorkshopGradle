package com.tikalk.workshop.app;

import com.tikalk.workshop.handler.PersonHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Spring 5 workshop application starter
 * Created by sigals on 03/03/2018.
 */
@SpringBootApplication
@ComponentScan({"com.tikalk.workshop.controller", "com.tikalk.workshop.service", "com.tikalk.workshop.handler"})
@EnableR2dbcRepositories(basePackages = {"com.tikalk.workshop.repository"})
@EnableWebFlux
public class WorkshopApp {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApp.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> controller(PersonHandler handler) {
        return route(GET("/person/handler/{id}").and(accept(APPLICATION_JSON)), handler::getPerson)
                .andRoute(GET("/person/handler").and(accept(APPLICATION_JSON)), handler::listPeople)
                .andRoute(POST("/person/handler").and(accept(APPLICATION_JSON)), handler::createPerson);
    }
}
