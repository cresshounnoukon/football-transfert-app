package tech.omeganumeric.beninsoccerapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    private int yearOfEstablishment;

    @OneToMany(mappedBy = "club")
    private List<Player> players;

    @OneToMany(mappedBy = "fromClub")
    private List<PlayerTransfer> outgoingTransfers;

    @OneToMany(mappedBy = "toClub")
    private List<PlayerTransfer> incomingTransfers;

    // Other properties, getters, setters, etc.
}
