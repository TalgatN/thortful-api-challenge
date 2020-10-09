package com.thorful.api.challenge.thortfulapichallenge.controller;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import com.thorful.api.challenge.thortfulapichallenge.domain.Root;
import com.thorful.api.challenge.thortfulapichallenge.service.SwapiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/swapi/")
@Slf4j
public class SwapiController {
    private final SwapiService swapiService;

    public SwapiController(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    @GetMapping(value = "/root", produces = APPLICATION_JSON_VALUE)
    public Root getRoot() {
        return swapiService.getRoot();
    }

    @GetMapping(value = "/people", produces = APPLICATION_JSON_VALUE)
    public PeopleResult getPeople() {
        return swapiService.getPeople();
    }

    @GetMapping(value = "/people/{id}", produces = APPLICATION_JSON_VALUE)
    public PeopleResult.People getPeopleById(@PathVariable Long id) {
        return swapiService.getPeopleById(id);
    }
}
