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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String nom;
    private String Prenom;
    private String Numero_Telephone;
    private String Adresse;
    private boolean Abonne;
    private String mdp;
    private String mail;
    @ManyToMany
    Collection<Service> Services;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Collection<Reservation> reservations;


}
