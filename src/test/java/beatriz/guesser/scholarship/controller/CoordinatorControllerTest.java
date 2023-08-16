package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.CoordinatorDtoRequest;
import beatriz.guesser.scholarship.service.CoordinatorService;
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

@WebMvcTest(CoordinatorController.class)
class CoordinatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoordinatorService coordinatorService;

    @Test
    void postCoordinator() throws Exception {
        CoordinatorDtoRequest mockRequest = new CoordinatorDtoRequest(/* initialize fields */);

        mockMvc.perform(post("/v1/coordinators/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Coordinator successfully saved!"));

        verify(coordinatorService, times(1)).save(Mockito.any(CoordinatorDtoRequest.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}