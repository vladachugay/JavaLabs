package com.vlados.SecondLabMid;

import java.util.Date;

public class Student {
    private String surname;
    private String name;
    private Date dateOfBirth;
    private String telNum;
    private static class Address {
        private String street;
        private int building;
        private int flat;

        Address(String street, int building, int flat) {
            this.street = street;
            this.building = building;
            this.flat = flat;
        }

        public int getBuilding() {
            return building;
        }

        public void setBuilding(int building) {
            this.building = building;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getFlat() {
            return flat;
        }

        public void setFlat(int flat) {
            this.flat = flat;
        }
    }

    Student(String surname, String name, Date dateOfBirth, String telNum) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telNum = telNum;
    }

    Student(String surname, String name, Date dateOfBirth, String telNum, String street, int building, int flat) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telNum = telNum;
        Address address = new Address(street, building, flat);
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.name;
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
}
