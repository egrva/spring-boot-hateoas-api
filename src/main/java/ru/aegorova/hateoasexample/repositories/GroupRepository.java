package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.aegorova.hateoasexample.models.Group;

import java.util.List;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
    @RestResource(path = "byCourse", rel = "course")
    List<Group> findAllByCourse_Number(int number);
}
