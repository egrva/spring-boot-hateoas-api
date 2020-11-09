package ru.aegorova.hateoasexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.aegorova.hateoasexample.services.LessonService;

@RepositoryRestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "/lessons/{lesson-id}/conduct", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> conduct(@PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity.ok(
                EntityModel.of(lessonService.conduct(lessonId)));
    }

    @RequestMapping(value = "/lessons/{lesson-id}/cancel", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> cancel(@PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity.ok(
                EntityModel.of(lessonService.cancel(lessonId)));
    }
}
