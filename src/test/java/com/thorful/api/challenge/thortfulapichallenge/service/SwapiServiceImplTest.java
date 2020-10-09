package com.thorful.api.challenge.thortfulapichallenge.service;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import com.thorful.api.challenge.thortfulapichallenge.domain.Root;
import com.thorful.api.challenge.thortfulapichallenge.repository.PeopleRepository;
import com.thorful.api.challenge.thortfulapichallenge.repository.RootRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SwapiServiceImplTest {

    @Mock
    private PeopleRepository peopleRepository;
    @Mock
    private RootRepository rootRepository;
    private SwapiService subject;

    @BeforeEach
    public void setup() {
        subject = new SwapiServiceImpl(rootRepository, peopleRepository);
    }

    @Test
    public void getRoot() {
        //Given
        Root expected = Root.builder().films("test-films").people("test-people").planets("test-planets").build();

        //And
        when(rootRepository.getRoot()).thenReturn(expected);

        //When
        Root actual = subject.getRoot();

        //Then
        assertEquals(expected, actual);
        verify(rootRepository).getRoot();
    }

    @Test
    public void getPeople() {
        //Given
        PeopleResult expected = PeopleResult.builder().results(asList(aPeople())).count(1).build();

        //And
        when(peopleRepository.getPeople()).thenReturn(expected);

        //When
        PeopleResult actual = subject.getPeople();

        //Then
        assertEquals(expected, actual);
        verify(peopleRepository).getPeople();
    }

    @Test
    public void getPeopleById() {
        //Given
        PeopleResult.People expected = aPeople();
        Long id = 1L;

        //And
        when(peopleRepository.getPeopleById(id)).thenReturn(expected);

        //When
        PeopleResult.People actual = subject.getPeopleById(id);

        //Then
        assertEquals(expected, actual);

        verify(peopleRepository).getPeopleById(id);
    }

    private PeopleResult.People aPeople() {
        return PeopleResult.People.builder().birthYear("test-year").name("test-name")
                .hairColor("test-hair-color").build();
    }
}