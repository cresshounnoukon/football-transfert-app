package tech.omeganumeric.beninsoccerapp.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    // Other properties, getters, setters, etc.
}
