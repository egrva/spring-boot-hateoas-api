package ru.aegorova.hateoasexample.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course")

//course
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // course number
    private int number;
    // list of groups
    @OneToMany(mappedBy = "course")
    private List<Group> groups;
    // list of subjects
    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

}