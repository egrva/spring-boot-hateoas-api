package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aegorova.hateoasexample.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
