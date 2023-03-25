/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.westminsterskinconsultationmanager;

import java.io.*;
import java.util.*;

/**
 *
 * @author vedansh
 */
public class WestminsterSkinConsultationmanager implements SkinConsultationManager {
// array list
    private ArrayList<Doctor> Listofdoc;
    private int MaxDoctor = 10;
    Scanner in = new Scanner(System.in);

    //constuctor
    public WestminsterSkinConsultationmanager() {
        Listofdoc = new ArrayList<>(MaxDoctor);
    }

    public ArrayList<Doctor> getListofdoc() {
        return Listofdoc;
    }

    public void add(Doctor doc) {
        if (Listofdoc.size() < MaxDoctor) {
            Listofdoc.add(doc);
        } else {
            System.out.println("List is full.");
        }
    }

    public static void main(String[] args) {

        WestminsterSkinConsultationmanager cm = new WestminsterSkinConsultationmanager();
        boolean cancel = false;

        while (!cancel) {
            cm.loopformenu();
        }
    }

    //method
    public void add() {
        System.out.println("First name: ");
        String fname = in.nextLine();
        System.out.println("Surname: ");
        String sname = in.nextLine();
        System.out.println("Date of birth: ");
        int date = Integer.valueOf(in.nextLine());
        System.out.println("Month of birth: ");
        int month = Integer.valueOf(in.nextLine());
        System.out.println("Year of birth: ");
        int year = Integer.valueOf(in.nextLine());
        System.out.println("Specialisation: ");
        String Specialisation = in.nextLine();
        System.out.println("Mobile Number: ");
        String Phonenumber = in.nextLine();
        Doctor doc = new Doctor(fname, sname);
        Date docDOB = new Date(date, month, year);
        doc.setDateOfBirth(docDOB);
        doc.setSpecialisation(Specialisation);
        doc.setPhoneNumber(Phonenumber);
        add(doc);
        System.out.println("Doctor has been saved");

    }
//methods
    public void delete() {
        System.out.println("Delete");
        boolean deleted = false;
        System.out.println("Enter doctors Medical license Number");
        int licenseNumber = Integer.valueOf(in.nextLine());

        for (int i = 0; i < Listofdoc.size(); i++) {
            if (Listofdoc.get(i).getLicenseNumber() == (licenseNumber)) {
                Listofdoc.remove(i);
                System.out.println("Doctor has been Deleted");

                break;
            } else if ((Listofdoc.get(i).getLicenseNumber() != licenseNumber) && i == Listofdoc.size()) {
                System.out.println("Doctor Not found");
            }
        }
    }

    public void view() {
        if (Listofdoc.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < Listofdoc.size(); i++) {
                System.out.println(Listofdoc.get(i).toString());
            }
        }
    }

    public void save() {
        try {
            FileWriter filewriter = new FileWriter("doctorInfo.csv");
            BufferedWriter bufferreader = new BufferedWriter(filewriter);
            for (int i = 0; i < Listofdoc.size(); i++) {
                bufferreader.write(Listofdoc.get(i).save());
                bufferreader.flush();
            }
            bufferreader.close();
            filewriter.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void load() {
        String line;
        String spliter = ",";
        String[] retireveinfo;
        try {
            BufferedReader br = new BufferedReader(new FileReader("doctorInfo.csv"));
            boolean retireveconfirm = false;
            while ((line = br.readLine()) != null) {

                retireveinfo = line.split(spliter);

                String fn = retireveinfo[0];
                String sn = retireveinfo[1];
                Doctor doctor = new Doctor(fn, sn);

                String Date = retireveinfo[2];
                String[] dateretireve;
                dateretireve = Date.split("/");

                int date = Integer.parseInt(dateretireve[0]);
                int month = Integer.parseInt(dateretireve[1]);
                int year = Integer.parseInt(dateretireve[2]);
                doctor.setDateOfBirth(new Date(date, month, year));

                doctor.setPhoneNumber(retireveinfo[3]);

                doctor.setSpecialisation(retireveinfo[4]);
                int MedicalNumber = Integer.valueOf(retireveinfo[5]);

                doctor.setLicenseNumber(MedicalNumber);
                add(doctor);
                retireveconfirm = true;
            }
            if (retireveconfirm) {
                System.out.println("data has been retireved");
            } else {
                System.out.println("there is no data to retireve from file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("unable to load file.");
        }

    }

    public static void menuoption() {
        System.out.println("To add  press 1 ");
        System.out.println("To delete press 2");
        System.out.println("To view press 3");
        System.out.println("To save press 4");
        System.out.println("To load press 5");
        System.out.println("To load table 6");
        System.out.println("To exit press 7");

    }
// methods for switch cases to run the menu options
    public void loopformenu() {
        menuoption();
        try {
            int option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1 ->
                    add();
                case 2 ->
                    delete();
                case 3 ->
                    view();
                case 4 -> {
                    save();
                    System.out.println("Data saved");
                }
                case 5 ->
                    load();
                case 6 -> {
                    listing list = new listing(Listofdoc);
                    list.runtable(Listofdoc);
                }
                case 7 ->
                    System.exit(0);
                default ->
                    System.out.println("invalid input entered.");
            }
        } catch (NumberFormatException error) {
            System.out.println("please enter a number");
        }
    }
}
