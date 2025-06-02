package ru.onuchin.MTS.App.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.onuchin.MTS.App.dto.ReadingDTO;
import ru.onuchin.MTS.App.service.ReadingsService;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReadingsController.class)
class ReadingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReadingsService readingsService;

    @Autowired
    private ObjectMapper objectMapper;  // для преобразования объектов в JSON

    @Test
    public void testGetLatestReading() throws Exception {
        // Подготовка тестовых данных
        ReadingDTO mockReading = new ReadingDTO();
        mockReading.setId(5L);
        mockReading.setTs(LocalDateTime.parse("2025-05-19T12:00:00"));
        mockReading.setValue(42);

        Mockito.when(readingsService.getReading()).thenReturn(mockReading);

        mockMvc.perform(get("/api/readings/latest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockReading)));
    }
}