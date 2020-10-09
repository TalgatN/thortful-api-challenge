package com.thorful.api.challenge.thortfulapichallenge.repository;

import com.thorful.api.challenge.thortfulapichallenge.domain.PeopleResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleRepositoryTest {
    @Value("${swapi.base.url}")
    private String baseUrl;

    @Value("${swapi.people}")
    private String peopleUrl;

    @Mock
    private RestTemplate restTemplate;
    private PeopleRepository subject;

    @BeforeEach
    public void setup() {
        this.subject = new PeopleRepositoryImpl(restTemplate);
    }

    @Test
    public void getPeople() {
        //Given
        PeopleResult expected = PeopleResult.builder().results(asList(aPeople())).count(1).build();

        //And
        when(restTemplate.getForObject(baseUrl + peopleUrl, PeopleResult.class)).thenReturn(expected);

        //When
        PeopleResult actual = subject.getPeople();

        //Then
        assertEquals(expected, actual);

        verify(restTemplate).getForObject(baseUrl + peopleUrl, PeopleResult.class);
    }

    @Test
    public void getPeopleById() {
        //Given
        PeopleResult.People expected = aPeople();
        Long id = 1L;

        //And
        when(restTemplate.getForObject(baseUrl + peopleUrl + id, PeopleResult.People.class)).thenReturn(expected);

        //When
        PeopleResult.People actual = subject.getPeopleById(id);

        //Then
        assertEquals(expected, actual);

        verify(restTemplate).getForObject(baseUrl + peopleUrl + id, PeopleResult.People.class);
    }

    private PeopleResult.People aPeople() {
        return PeopleResult.People.builder().birthYear("test-year").name("test-name")
                .hairColor("test-hair-color").build();
    }
}