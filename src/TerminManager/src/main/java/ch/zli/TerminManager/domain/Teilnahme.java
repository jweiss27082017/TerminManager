package ch.zli.TerminManager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class Teilnahme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    //@JsonBackReference(value = "Termin")
    @ManyToOne(optional = false)
    private Termin termin;

    //@JsonBackReference(value = "User")
    @ManyToOne(optional = false)
    private User user;
}
