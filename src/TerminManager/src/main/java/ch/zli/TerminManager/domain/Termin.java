package ch.zli.TerminManager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Titel;

    @Column(nullable = false)
    private String Ort;

    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(nullable = false)
    @Past
    private LocalDateTime Datum;

    //@JsonBackReference(value = "Teilnahme")
    @OneToMany(mappedBy = "termin")
    @Column(nullable = false)
    private List<Teilnahme> teilnahmen;

}
