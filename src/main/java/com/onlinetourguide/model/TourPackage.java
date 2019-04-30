package com.onlinetourguide.model;

public class TourPackage {

    private String id;
    private String tour_name;
    private String location_from;
    private String location_to;
    private String date;
    private String price;
    private String desp1, desp2;
    private String imageURL_1, ImageURL_2;
    private String transport_type;
    private String hotel_type;

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public String getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(String hotel_type) {
        this.hotel_type = hotel_type;
    }

    public String getImageURL_1() {
        return imageURL_1;
    }

    public void setImageURL_1(String imageURL_1) {
        this.imageURL_1 = imageURL_1;
    }

    public String getImageURL_2() {
        return ImageURL_2;
    }

    public void setImageURL_2(String imageURL_2) {
        this.ImageURL_2 = imageURL_2;
    }

    public String getDesp1() {
        return desp1;
    }

    public void setDesp1(String desp1) {
        this.desp1 = desp1;
    }

    public String getDesp2() {
        return desp2;
    }

    public void setDesp2(String desp2) {
        this.desp2 = desp2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getLocation_from() {
        return location_from;
    }

    public void setLocation_from(String location_from) {
        this.location_from = location_from;
    }

    public String getLocation_to() {
        return location_to;
    }

    public void setLocation_to(String location_to) {
        this.location_to = location_to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
