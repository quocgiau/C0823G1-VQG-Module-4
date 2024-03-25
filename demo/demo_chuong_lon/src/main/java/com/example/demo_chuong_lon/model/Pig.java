package com.example.demo_chuong_lon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pig")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int weight;
    private int age;
    private Boolean gender;

    @ManyToOne
    @JoinColumn(name = "cage_id", referencedColumnName = "id")
    private Cage cage;
}
