package model;

import java.time.LocalDateTime;

public class readers {
    private int id;
    private String full_name;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime created_at;

    public readers(int id, String full_name, String email, String phone, String address, LocalDateTime created_at) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
    }

    public readers(String full_name, String email, String phone, String address) {
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
