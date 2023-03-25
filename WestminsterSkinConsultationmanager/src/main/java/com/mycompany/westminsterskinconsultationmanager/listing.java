package com.mycompany.westminsterskinconsultationmanager;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vedansh
 */
public class listing extends AbstractTableModel {

    ArrayList<Doctor> Doctolist; // array list create for a table
    //name of the columns in table stored in array
    String[] columncontent = {"MLN", "first Name", "Surname", "Date of Birth", "Mobile Number", "Specialisation"};
    //constructor
listing(ArrayList<Doctor> dlist) {
    //copying from doclist array in main to the arraylist in this class 
        Doctolist = dlist;
    }
//row counter which is set based on arraylist size
    @Override
    public int getRowCount() {
        return Doctolist.size();
    }

    @Override // this for column size of the table
    public int getColumnCount() {
        return columncontent.length;
    }

    @Override
    //retireve the values from arraylist doctor
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        switch (columnIndex) {
            case 0 ->
                temp = Doctolist.get(rowIndex).getLicenseNumber();

            case 1 ->
                temp = Doctolist.get(rowIndex).getFirstName();

            case 2 ->
                temp = Doctolist.get(rowIndex).getSurName();

            case 3 ->
                temp = Doctolist.get(rowIndex).getDateOfBirth();

            case 4 ->
                temp = Doctolist.get(rowIndex).getPhoneNumber();

            case 5 -> {
                temp = Doctolist.get(rowIndex).getSpecialisation();
                break;

            }
            default ->
                System.out.println("error");

        }
        return temp;
    }
    public String getColumnName(int col){
        return columncontent[col];
    }
    //create a jframe for the table and a jscroll that is added to the frame and displayed
    public void runtable(ArrayList<Doctor> dlist){
        listing list=new listing(dlist);
        JTable tabledoc=new JTable(list);
        JScrollPane table=new JScrollPane(tabledoc);
        JFrame frame=new JFrame("Doctor list");
        frame.add(table);
        frame.setVisible(true);
        frame.setSize(700,700);
    }
    
}
