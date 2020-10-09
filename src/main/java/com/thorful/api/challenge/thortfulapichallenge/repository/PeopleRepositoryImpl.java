package com.thorful.api.challenge.thortfulapichallenge.repository;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class PeopleRepositoryImpl implements PeopleRepository {
    @Value("${swapi.base.url}")
    private String baseUrl;

    @Value("${swapi.people}")
    private String peopleUrl;

    private final RestTemplate restTemplate;

    public PeopleRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PeopleResult getPeople() {
        log.debug("{} Getting all people", baseUrl + peopleUrl);
        return restTemplate.getForObject(baseUrl + peopleUrl, PeopleResult.class);
    }

    @Override
    public PeopleResult.People getPeopleById(Long id) {
        log.debug("{} Getting people by id: {}", baseUrl + peopleUrl, id);
        return restTemplate.getForObject(baseUrl + peopleUrl + id, PeopleResult.People.class);
    }
}
