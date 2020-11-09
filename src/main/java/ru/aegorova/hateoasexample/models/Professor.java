package ru.aegorova.hateoasexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "professor")

//professors
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //professor name
    private String name;
}