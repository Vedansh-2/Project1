/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.westminsterskinconsultationmanager;

/**
 *
 * @author vedansh
 */
public class Patient extends Person {

    private long PatientUniqueID;

    public Patient(long PatientID, String Firstname, String SurName) {
        super(Firstname, SurName);
        this.PatientUniqueID = PatientID;
    }

    public long getPatientUniqueID() {
        return PatientUniqueID;
    }

    public void setPatientUniqueID(long PatientUniqueID) {
        this.PatientUniqueID = PatientUniqueID;
    }

}
