package tech.omeganumeric.beninsoccerapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Country nationality;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    private int jerseyNumber;
    private BigDecimal marketValue;



    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "player")
    private List<PlayerTransfer> transfers;

    @OneToMany(mappedBy = "player")
    private List<Contract> contracts;

    // Other properties, getters, setters, and methods
}