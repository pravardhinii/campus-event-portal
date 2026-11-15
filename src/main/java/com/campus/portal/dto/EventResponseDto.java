package com.campus.portal.dto;

public class EventResponseDto {
    private Long id;
    private String title;
    private String organizerEmail;

    public EventResponseDto() {}

    public EventResponseDto(Long id, String title, String organizerEmail) {
        this.id = id;
        this.title = title;
        this.organizerEmail = organizerEmail;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getOrganizerEmail() { return organizerEmail; }
    public void setOrganizerEmail(String organizerEmail) { this.organizerEmail = organizerEmail; }
}