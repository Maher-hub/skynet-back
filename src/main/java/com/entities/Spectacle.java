package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Spectacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String titre;
    private String auteur;
    // class place est reservé ou pas
    private String nbrPlace;
    @OneToMany(mappedBy = "spectacle",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Collection<Reservation> reservations;
}
