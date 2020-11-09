package ru.aegorova.hateoasexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.aegorova.hateoasexample.models.*;
import ru.aegorova.hateoasexample.services.LessonService;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class LessonTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;

    @BeforeEach
    public void setUp() {
        when(lessonService.conduct(1L)).thenReturn(heldLesson());
        when(lessonService.cancel(1L)).thenReturn(canceledLesson());
    }

    @Test
    public void lessonConductTest() throws Exception {
        mockMvc.perform(put("/lessons/1/conduct")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lessonStatus").value(heldLesson().getLessonStatus().toString()))
                .andDo(document("conduct_lesson",
                        responseFields(fieldWithPath("lessonStatus").description("Статус урока"))));
    }

    @Test
    public void lessonCancelTest() throws Exception {
        mockMvc.perform(put("/lessons/1/cancel")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lessonStatus").value(canceledLesson().getLessonStatus().toString()))
                .andDo(document("cancel_lesson",
                        responseFields(
                                fieldWithPath("lessonStatus").description("Статус урока"),
                                subsectionWithPath("_links").description("Ссылки на другие ресурсы")
                        )));
    }


    private Lesson planedLesson() {
        Lesson lesson = defaultLesson();
        lesson.setLessonStatus(LessonStatus.PLANED);
        return lesson;
    }

    private Lesson canceledLesson() {
        Lesson lesson = defaultLesson();
        lesson.setLessonStatus(LessonStatus.CANCELED);
        return lesson;
    }

    private Lesson heldLesson() {
        Lesson lesson = defaultLesson();
        lesson.setLessonStatus(LessonStatus.HELD);
        return lesson;
    }

    private Lesson defaultLesson() {
        Course course = Course.builder().id(1L).number(1).build();
        Group group = Group.builder().id(1L).course(course).number("11-805").build();
        Subject subject = Subject.builder().course(course).title("Javalab").id(1L).build();
        Professor professor = Professor.builder().id(1L).name("Alesha").build();
        Auditory auditory = Auditory.builder().id(1L).number(1301).capasity(20).build();
        return Lesson.builder()
                .subject(subject)
                .professor(professor)
                .group(group)
                .auditory(auditory)
                .id(1L)
                .build();
    }
}

