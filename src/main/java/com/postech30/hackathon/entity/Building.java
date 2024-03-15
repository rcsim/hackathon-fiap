package com.postech30.hackathon.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String idLocalidade;
    private String nome;
}
