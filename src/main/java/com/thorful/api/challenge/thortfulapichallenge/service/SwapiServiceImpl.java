package com.thorful.api.challenge.thortfulapichallenge.service;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import com.thorful.api.challenge.thortfulapichallenge.domain.Root;
import com.thorful.api.challenge.thortfulapichallenge.repository.PeopleRepository;
import com.thorful.api.challenge.thortfulapichallenge.repository.RootRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SwapiServiceImpl implements SwapiService {
    private final RootRepository rootRepository;
    private final PeopleRepository peopleRepository;

    public SwapiServiceImpl(RootRepository rootRepository, PeopleRepository peopleRepository) {
        this.rootRepository = rootRepository;
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Root getRoot() {
        log.debug("Getting all available resources");
        return rootRepository.getRoot();
    }

    @Override
    public PeopleResult getPeople() {
        log.debug("Getting all people");
        return peopleRepository.getPeople();
    }

    @Override
    public PeopleResult.People getPeopleById(@NonNull Long id) {
        log.debug("Getting people by id: {}", id);
        return peopleRepository.getPeopleById(id);
    }
}
