/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.westminsterskinconsultationmanager;

/**
 *
 * @author vedansh
 */
public abstract class Person {

    private String FirstName;
    private String SurName;
    private String phoneNumber;
    private Date DateOfBirth;

    public Person(String Firstname, String SurName) {
        this.FirstName = Firstname;
        this.SurName = SurName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String SurName) {
        this.SurName = SurName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }
}
