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
@Table(name = "auditory")

//auditories
public class Auditory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //auditory number
    private int number;
    //auditory capasity
    private int capasity;

}
