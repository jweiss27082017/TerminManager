package ch.zli.TerminManager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.aspectj.lang.annotation.Before;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    //@JsonBackReference(value = "Rolle")
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(nullable = false)
    @JsonIgnore
    private List<Rolle> rollen;

    //@JsonBackReference(value = "Teilnahme")
    @OneToMany(mappedBy = "user")
    @Column(nullable = false)
    @JsonIgnore
    private List<Teilnahme> teilnahmen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rolle> getRollen() {
        return rollen;
    }

    public void setRollen(List<Rolle> rollen) {
        this.rollen = rollen;
    }

    public List<Teilnahme> getTeilnahmen() {
        return teilnahmen;
    }

    public void setTeilnahmen(List<Teilnahme> teilnahmen) {
        this.teilnahmen = teilnahmen;
    }
}
