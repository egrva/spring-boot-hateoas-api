package ru.aegorova.hateoasexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.aegorova.hateoasexample.controllers.LessonController;
import ru.aegorova.hateoasexample.models.Lesson;
import ru.aegorova.hateoasexample.models.LessonStatus;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LessonRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Lesson>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Override
    public EntityModel<Lesson> process(EntityModel<Lesson> model) {
        Lesson lesson = model.getContent();
        if (lesson != null && lesson.getLessonStatus().equals(LessonStatus.PLANED)) {
            model.add(linkTo(methodOn(LessonController.class)
                            .conduct(lesson.getId())).withRel("conduct"),
                    linkTo(methodOn(LessonController.class)
                            .cancel(lesson.getId())).withRel("cancel"));
        }
        if (lesson != null && lesson.getLessonStatus().equals(LessonStatus.CANCELED)) {
            model.add(links.linkToItemResource(Lesson.class, lesson.getId()).
                    withRel("delete"));
        }
        return model;
    }
}