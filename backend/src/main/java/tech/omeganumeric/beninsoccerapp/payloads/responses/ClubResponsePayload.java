package tech.omeganumeric.beninsoccerapp.payloads.responses;

import lombok.Data;

@Data
public class ClubResponsePayload {
    private Long id;
    private String name;
    private String city;
    private int yearOfEstablishment;

    // Other payload fields to match response requirements
}
