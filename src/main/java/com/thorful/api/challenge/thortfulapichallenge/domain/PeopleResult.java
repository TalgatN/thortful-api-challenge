package com.thorful.api.challenge.thortfulapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleResult {
    private List<People> results;
    private Integer count;
    private Integer previous;

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class People {
        private String name;
        private String birthYear;
        private String eyeColor;
        private String gender;
        private String hairColor;
        private String height;
        private String mass;
        private String skinColor;
        private String homeworld;
        private List<String> films;
        private List<String> species;
        private List<String> starships;
        private List<String> vehicles;
        private String url;
        private String created;
        private String edited;
    }
}
