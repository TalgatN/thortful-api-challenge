package com.thorful.api.challenge.thortfulapichallenge.repository;

import com.thorful.api.challenge.thortfulapichallenge.domain.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RootRepositoryImplTest {
    @Value("${swapi.base.url}")
    private String baseUrl;

    @Mock
    private RestTemplate restTemplate;
    private RootRepository subject;

    @BeforeEach
    public void setup() {
        this.subject = new RootRepositoryImpl(restTemplate);
    }

    @Test
    public void testGetRoot() {
        //Given
        Root expected = Root.builder().films("test-films").people("test-people").planets("test-planets").build();

        //And
        when(restTemplate.getForObject(baseUrl, Root.class)).thenReturn(expected);

        //When
        Root actual = subject.getRoot();

        //Then
        assertEquals(expected, actual);

        verify(restTemplate).getForObject(baseUrl, Root.class);
    }

}