package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.aegorova.hateoasexample.models.Auditory;

public interface AuditoryRepository extends PagingAndSortingRepository<Auditory, Long> {
    @RestResource(path = "byCapacity", rel = "capacity")
    @Query("from Auditory auditory where auditory.capasity > 40 ")
    Page<Auditory> findSpaciousAuditories(Pageable pageable);
}
