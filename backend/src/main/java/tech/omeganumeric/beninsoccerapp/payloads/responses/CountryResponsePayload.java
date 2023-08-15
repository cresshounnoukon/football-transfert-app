package tech.omeganumeric.beninsoccerapp.payloads.responses;

import lombok.Data;

@Data
public class CountryResponsePayload {
    private Long id;
    private String name;
    private String code;

    // Other payload fields to match response requirements
}
