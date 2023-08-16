package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.CoordinatorDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoResponse;
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

@WebMvcTest(SquadController.class)
class SquadControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SquadService squadService;

    @Test
    void postSquad() throws Exception {
        SquadDtoRequest mockRequest = new SquadDtoRequest(/* initialize fields */);

        mockMvc.perform(post("/v1/squads/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Squad successfully saved!"));

        verify(squadService, times(1)).save(Mockito.any(SquadDtoRequest.class));
    }

    @Test
    void addStudentToSquad() {
        Long mockSquadId = 1L;
        Long mockStudentId = 2L;

        try {
            mockMvc.perform(put("/v1/squads/add/{id_squad}/students/{id_student}", mockSquadId, mockStudentId))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Student successfully added to squad!"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        verify(squadService, times(1)).addStudentToSquad(mockSquadId, mockStudentId);
    }

    @Test
    void getSquad() throws Exception {
        Long mockSquadId = 1L;
        SquadDtoResponse mockResponse = new SquadDtoResponse(/* initialize fields */);

        // Mock the service's response for getById method
        when(squadService.getById(mockSquadId)).thenReturn(mockResponse);

        // Perform a GET request to the endpoint
        mockMvc.perform(get("/v1/squads/get/{id_squad}", mockSquadId))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(mockResponse)));
    }

    @Test
    void deleteSquad() throws Exception {
        Long mockSquadId = 1L;

        // Perform a DELETE request to the endpoint
        mockMvc.perform(delete("/v1/squads/delete/{id_squad}", mockSquadId))
                .andExpect(status().isOk())
                .andExpect(content().string("Squad successfully deleted!"));

        // Verify that the service's delete method was called
        verify(squadService, times(1)).delete(mockSquadId);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}