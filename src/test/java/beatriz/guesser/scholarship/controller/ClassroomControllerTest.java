package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.*;
import beatriz.guesser.scholarship.service.ClassroomService;
import beatriz.guesser.scholarship.service.CoordinatorService;
import beatriz.guesser.scholarship.service.SquadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(ClassroomController.class)
class ClassroomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassroomService classroomService;

    @Test
    void postClass() throws Exception {
        ClassroomDtoRequest mockRequest = new ClassroomDtoRequest(/* initialize fields */);

        mockMvc.perform(post("/v1/classes/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Class successfully saved!"));

        verify(classroomService, times(1)).save(Mockito.any(ClassroomDtoRequest.class));
    }

    @Test
    void getClassroom() throws Exception {
        Long mockClassroomId = 1L;
        ClassroomDtoResponse mockResponse = new ClassroomDtoResponse(/* initialize fields */);

        // Mock the service's response for getById method
        when(classroomService.getById(mockClassroomId)).thenReturn(mockResponse);

        // Perform a GET request to the endpoint
        mockMvc.perform(get("/v1/classes/get/{id_class}", mockClassroomId))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(mockResponse)));
    }

    @Test
    void deleteClass() throws Exception {
        Long mockClassroomId = 1L;

        mockMvc.perform(delete("/v1/classes/delete/{id_class}", mockClassroomId))
                .andExpect(status().isOk())
                .andExpect(content().string("Class successfully deleted!"));

        verify(classroomService, times(1)).delete(mockClassroomId);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}