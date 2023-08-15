package tech.omeganumeric.beninsoccerapp.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private Date startDate;
    private Date endDate;

    // Other properties, getters, setters, and methods
}