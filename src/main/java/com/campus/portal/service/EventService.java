package com.campus.portal.service;

import com.campus.portal.dto.EventRequestDto;
import com.campus.portal.dto.EventResponseDto;
import com.campus.portal.entity.EventEntity;
import com.campus.portal.exception.ResourceNotFoundException;
import com.campus.portal.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponseDto createEvent(EventRequestDto requestDto) {
        EventEntity entity = new EventEntity();
        entity.setTitle(requestDto.getTitle());
        entity.setOrganizerEmail(requestDto.getOrganizerEmail());

        EventEntity saved = eventRepository.save(entity);
        return mapToDto(saved);
    }

    public EventResponseDto getEventById(Long id) {
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return mapToDto(entity);
    }

    public List<EventResponseDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteEvent(Long id) {
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        eventRepository.delete(entity);
    }

    private EventResponseDto mapToDto(EventEntity entity) {
        return new EventResponseDto(entity.getId(), entity.getTitle(), entity.getOrganizerEmail());
    }
}