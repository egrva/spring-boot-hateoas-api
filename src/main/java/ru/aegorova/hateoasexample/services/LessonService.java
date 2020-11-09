package ru.aegorova.hateoasexample.services;

import ru.aegorova.hateoasexample.models.Lesson;

public interface LessonService {
    Lesson conduct(Long lessonId);
    Lesson cancel(Long lessonId);
}
