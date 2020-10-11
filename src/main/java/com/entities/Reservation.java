package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String type;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Spectacle spectacle;

    @OneToMany(mappedBy = "reservation",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Collection<Ticket> tickets;


    // methode calcule prix

}
