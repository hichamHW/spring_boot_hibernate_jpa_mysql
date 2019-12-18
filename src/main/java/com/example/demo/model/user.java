package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name="user_table")

public class user {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name_user")
    private String name;
    @Column(name = "departement")
    private String depratement ;

    public user(@JsonProperty("id") UUID id,  @JsonProperty("name") String name, @JsonProperty("dep") String depratement) {


        this.id = id;
        this.name = name;
        this.depratement = depratement;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepratement() {
        return depratement;
    }

    public void setDepratement(String depratement) {
        this.depratement = depratement;
    }
}
