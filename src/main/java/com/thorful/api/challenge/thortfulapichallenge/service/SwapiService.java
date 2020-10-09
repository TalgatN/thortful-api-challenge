package com.thorful.api.challenge.thortfulapichallenge.service;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import com.thorful.api.challenge.thortfulapichallenge.domain.Root;

public interface SwapiService {
    Root getRoot();
    PeopleResult getPeople();
    PeopleResult.People getPeopleById(Long id);
}
