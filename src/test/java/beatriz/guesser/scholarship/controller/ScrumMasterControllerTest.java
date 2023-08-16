package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ScrumMasterDtoRequest;
import beatriz.guesser.scholarship.service.ScrumMasterService;
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

@WebMvcTest(ScrumMasterController.class)
class ScrumMasterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScrumMasterService scrumMasterService;

    @Test
    void postScrumMaster() throws Exception {
        ScrumMasterDtoRequest mockRequest = new ScrumMasterDtoRequest(/* initialize fields */);

        mockMvc.perform(post("/v1/scrum-masters/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Scrum Master successfully saved!"));

        verify(scrumMasterService, times(1)).save(Mockito.any(ScrumMasterDtoRequest.class));
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}