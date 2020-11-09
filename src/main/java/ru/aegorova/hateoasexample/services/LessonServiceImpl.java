package ru.aegorova.hateoasexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aegorova.hateoasexample.models.Lesson;
import ru.aegorova.hateoasexample.repositories.LessonRepository;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson conduct(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(IllegalArgumentException::new);
        lesson.conduct();
        lessonRepository.save(lesson);
        return lesson;
    }

    @Override
    public Lesson cancel(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(IllegalArgumentException::new);
        lesson.cancel();
        lessonRepository.save(lesson);
        return lesson;
    }
}
