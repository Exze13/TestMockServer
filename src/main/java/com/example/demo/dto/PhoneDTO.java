package com.example.demo.dto;

public class PhoneDTO {

    private static int lastId = 0;
    private String phone;
    private int id;


    public PhoneDTO(String phone) {
        this.phone = phone;
        lastId++;
        this.id = lastId;
    }

    public PhoneDTO() {
        lastId++;
        this.id = lastId;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
