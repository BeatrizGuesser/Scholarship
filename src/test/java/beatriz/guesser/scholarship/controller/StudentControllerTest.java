package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.StudentDtoRequest;
import beatriz.guesser.scholarship.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void postStudent() throws Exception {
        // Create a mock StudentDtoRequest
        StudentDtoRequest mockRequest = new StudentDtoRequest(/* initialize fields */);

        // Perform a POST request to the endpoint
        mockMvc.perform(post("/v1/students/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Student successfully saved!"));

        // Verify that the service's save method was called
        verify(studentService, times(1)).save(Mockito.any(StudentDtoRequest.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}