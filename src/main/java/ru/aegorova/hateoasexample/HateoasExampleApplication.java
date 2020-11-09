package ru.aegorova.hateoasexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.aegorova.hateoasexample.models.*;
import ru.aegorova.hateoasexample.repositories.*;

import static java.util.Arrays.asList;

@SpringBootApplication
public class HateoasExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasExampleApplication.class, args);

        AuditoryRepository auditoryRepository = context.getBean(AuditoryRepository.class);
        CourseRepository courseRepository = context.getBean(CourseRepository.class);
        GroupRepository groupRepository = context.getBean(GroupRepository.class);
        LessonRepository lessonRepository = context.getBean(LessonRepository.class);
        ProfessorsRepository professorsRepository = context.getBean(ProfessorsRepository.class);
        SubjectsRepository subjectsRepository = context.getBean(SubjectsRepository.class);

        Auditory auditory1305 = Auditory.builder()
                .capasity(20)
                .number(1305)
                .build();

        Auditory auditory1310 = Auditory.builder()
                .capasity(40)
                .number(1310)
                .build();

        Auditory auditory108 = Auditory.builder()
                .capasity(200)
                .number(108)
                .build();

        auditoryRepository.saveAll(asList(auditory108, auditory1305, auditory1310));

        Course course1 = Course.builder()
                .number(1)
                .build();
        Course course2 = Course.builder()
                .number(2)
                .build();

        courseRepository.saveAll(asList(
                course1, course2
        ));

        Group group11_901 = Group.builder()
                .course(course1)
                .number("11-901")
                .build();

        Group group11_902 = Group.builder()
                .course(course1)
                .number("11-902")
                .build();

        Group group11_801 = Group.builder()
                .course(course2)
                .number("11-801")
                .build();

        Group group11_802 = Group.builder()
                .course(course2)
                .number("11-802")
                .build();

        groupRepository.saveAll(asList(group11_801, group11_802, group11_901, group11_902));

        Subject algem = Subject.builder()
                .course(course1)
                .title("algem")
                .build();

        Subject discretka = Subject.builder()
                .course(course1)
                .title("discretka")
                .build();

        Subject matan = Subject.builder()
                .course(course1)
                .title("matan")
                .build();

        Subject dataBases = Subject.builder()
                .course(course2)
                .title("dataBases")
                .build();

        Subject machineLearning = Subject.builder()
                .course(course2)
                .title("machineLearning")
                .build();

        Subject terVer = Subject.builder()
                .course(course2)
                .title("terVer")
                .build();

        subjectsRepository.saveAll(asList(algem, discretka, matan, machineLearning, terVer, dataBases));

        Professor professor1 = Professor.builder()
                .name("Ivan")
                .build();

        Professor professor2 = Professor.builder()
                .name("Andrey")
                .build();

        Professor professor3 = Professor.builder()
                .name("Kostya")
                .build();

        professorsRepository.saveAll(asList(professor1, professor2, professor3));

        Lesson lesson1 = Lesson.builder()
                .auditory(auditory1310)
                .group(group11_901)
                .subject(algem)
                .professor(professor1)
                .lessonStatus(LessonStatus.PLANED)
                .build();

        Lesson lesson2 = Lesson.builder()
                .auditory(auditory1305)
                .group(group11_902)
                .subject(matan)
                .professor(professor2)
                .lessonStatus(LessonStatus.PLANED)
                .build();

        Lesson lesson3 = Lesson.builder()
                .auditory(auditory108)
                .group(group11_901)
                .lessonStatus(LessonStatus.CANCELED)
                .subject(discretka)
                .professor(professor3)
                .build();

        Lesson lesson4 = Lesson.builder()
                .lessonStatus(LessonStatus.PLANED)
                .auditory(auditory108)
                .group(group11_801)
                .professor(professor1)
                .subject(machineLearning)
                .build();

        Lesson lesson5 = Lesson.builder()
                .lessonStatus(LessonStatus.CANCELED)
                .auditory(auditory1305)
                .group(group11_802)
                .professor(professor2)
                .subject(terVer)
                .build();

        Lesson lesson6 = Lesson.builder()
                .lessonStatus(LessonStatus.PLANED)
                .auditory(auditory1310)
                .group(group11_801)
                .professor(professor3)
                .subject(dataBases)
                .build();

        lessonRepository.saveAll(asList(lesson1, lesson2, lesson3, lesson4, lesson5, lesson6));
    }

}