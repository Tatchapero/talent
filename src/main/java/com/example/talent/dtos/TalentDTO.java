package com.example.talent.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.net.URI;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("profileText")
    private String profileText;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("github")
    private URI github;

    @JsonProperty("linkedin")
    private URI linkedin;
}
