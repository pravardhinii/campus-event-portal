package com.campus.portal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EventRequestDto {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Organizer email is required")
    @Email(message = "Invalid email format")
    private String organizerEmail;

    public EventRequestDto() {}

    public EventRequestDto(String title, String organizerEmail) {
        this.title = title;
        this.organizerEmail = organizerEmail;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getOrganizerEmail() { return organizerEmail; }
    public void setOrganizerEmail(String organizerEmail) { this.organizerEmail = organizerEmail; }
}