package com.thorful.api.challenge.thortfulapichallenge.repository;

import com.thorful.api.challenge.thortfulapichallenge.domain.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class RootRepositoryImpl implements RootRepository {

    @Value("${swapi.base.url}")
    private String url;
    private final RestTemplate restTemplate;

    public RootRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Root getRoot() {
        log.debug("{} Getting all available resources within the API", url);
        return restTemplate.getForObject(url, Root.class);
    }
}
