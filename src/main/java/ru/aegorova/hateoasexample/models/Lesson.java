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
@Table(name = "lesson")

//lessons
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //auditory
    @ManyToOne
    @JoinColumn(name = "auditory_id")
    private Auditory auditory;
    //professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    //subject
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    //group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    // lesson status
    private LessonStatus lessonStatus;

    public void conduct() {
        if (this.lessonStatus.equals(LessonStatus.PLANED)) {
            this.lessonStatus = LessonStatus.HELD;
        } else if (this.lessonStatus.equals(LessonStatus.CANCELED)) {
            throw new IllegalStateException();
        }
    }

    public void cancel() {
        if (this.lessonStatus.equals(LessonStatus.PLANED)) {
            this.lessonStatus = LessonStatus.CANCELED;
        } else if (this.lessonStatus.equals(LessonStatus.HELD)) {
            throw new IllegalStateException();
        }
    }
}
