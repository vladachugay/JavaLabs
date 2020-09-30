package com.vlados.SecondLabMid;

import java.util.Date;
import java.util.PrimitiveIterator;

public class Student {
    private String surname;
    private String name;
    private Date dateOfBirth;
    private String telNum;
    private String street;
    private int building;
    private int flat;


    Student() {}

    Student(String surname, String name, Date dateOfBirth, String telNum, String street, int building, int flat) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telNum = telNum;
        this.street = street;
        this.building = building;
        this.flat = flat;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Date getDateOfBirth() {
        return  this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getStreet() {
        return this.street;
    }

    public int getBuilding() {
        return this.building;
    }

    public int getFlat() {
        return this.flat;
    }

    public void setStreet(int building) {
        this.building = building;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

}
