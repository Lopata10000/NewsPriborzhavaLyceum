package com.fanta.newspriborzhavalyceum.database.dto;

public class EventPlaceDTO {
    private Long id;
    private String placeName;
    private String placeAddress;
    private int capacity;
    private boolean accessibility;

    public EventPlaceDTO(Long id, String placeName, String placeAddress, int capacity, boolean accessibility) {
        this.id = id;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.capacity = capacity;
        this.accessibility = accessibility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }
}
