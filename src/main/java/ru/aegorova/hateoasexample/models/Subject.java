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
@Table(name = "subject")

//subjects
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //subject name
    private String title;
    // subject course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}