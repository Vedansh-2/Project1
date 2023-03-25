/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.westminsterskinconsultationmanager;

/**
 *
 * @author vedansh
 */
public class Doctor extends Person {

    private int LicenseNumber;
    private String Specialisation;
    private static int count = 0;

    public Doctor(String firstName, String surname) {
        super(firstName, surname);
        count++;
        LicenseNumber = count;
    }

    public long getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(int LicenseNumber) {
        this.LicenseNumber = LicenseNumber;
    }

    public String getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(String Specialisation) {
        this.Specialisation = Specialisation;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() +  " " + getSurName() + " phone number: " + getPhoneNumber() + " DOB: " + getDateOfBirth() + " Specialisation: " + getSpecialisation() + " licence number: " + getLicenseNumber(); 
    }
    
    public String save() {
        return getFirstName() +  "," + getSurName() + "," + getDateOfBirth() + "," + getPhoneNumber() + "," + getSpecialisation() + "," + getLicenseNumber()+"\n"; 
    }

}
