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
@Table(name = "grouppa")

//groups
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //group number
    private String number;
    // course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
