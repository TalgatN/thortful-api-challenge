package com.thorful.api.challenge.thortfulapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private String films;
    private String people;
    private String planets;
    private String species;
    private String starships;
    private String vehicles;
}
