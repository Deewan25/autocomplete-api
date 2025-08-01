package com.assignment.autocomplete_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "name")
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String val;

    public String getValue() {
        return val;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", val='" + val + '\'' +
                '}';
    }
}
