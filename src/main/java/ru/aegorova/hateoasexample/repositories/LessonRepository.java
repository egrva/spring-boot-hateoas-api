package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.aegorova.hateoasexample.models.Lesson;

import java.util.List;

@RepositoryRestResource
public interface LessonRepository extends PagingAndSortingRepository<Lesson, Long> {
    @RestResource(path = "held", rel = "held")
    @Query("from Lesson lesson where lesson.lessonStatus = 'HELD'")
    Page<Lesson> findAllHeld(Pageable pageable);

    @RestResource(path = "byGroup", rel = "group")
    List<Lesson> findAllByGroup_Number(String number);

    @RestResource(path = "byProfessor", rel = "professor")
    List<Lesson> findAllByProfessor_Name(String name);

    @RestResource(path = "byAuditory", rel = "auditory")
    List<Lesson> findAllByAuditory_Number(int number);

}
