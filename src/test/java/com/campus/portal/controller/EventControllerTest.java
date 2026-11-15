package com.campus.portal.controller;

import com.campus.portal.dto.EventRequestDto;
import com.campus.portal.dto.EventResponseDto;
import com.campus.portal.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createEvent_WhenValidInput_ReturnsCreatedStatus() throws Exception {
        EventRequestDto requestDto = new EventRequestDto("Tech Fest", "organizer@campus.edu");
        EventResponseDto responseDto = new EventResponseDto(1L, "Tech Fest", "organizer@campus.edu");

        when(eventService.createEvent(any(EventRequestDto.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Tech Fest"))
                .andExpect(jsonPath("$.organizerEmail").value("organizer@campus.edu"));
    }
}