package com.theironyard.novauc.entities;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 3/18/17.
 */
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String birthDay;

    @Column(nullable = false)
    String email;

    public Person() {
    }

    public Person(String name, String address, String phone, String birthDay, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthDay = birthDay;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }







}


