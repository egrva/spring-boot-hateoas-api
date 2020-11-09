package ru.aegorova.hateoasexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aegorova.hateoasexample.models.Professor;

public interface ProfessorsRepository extends JpaRepository<Professor, Long> {
}