package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.aegorova.hateoasexample.models.Subject;

import java.util.List;

public interface SubjectsRepository extends PagingAndSortingRepository<Subject, Long> {

    @RestResource(path = "byCourse", rel = "course")
    List<Subject> findAllByCourse_Number(int number);
}
