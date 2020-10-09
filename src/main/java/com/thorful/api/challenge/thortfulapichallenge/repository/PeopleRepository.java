package com.thorful.api.challenge.thortfulapichallenge.repository;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;

public interface PeopleRepository {
    PeopleResult getPeople();
    PeopleResult.People getPeopleById(Long id);
}
