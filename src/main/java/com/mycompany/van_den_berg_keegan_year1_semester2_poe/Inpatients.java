/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

/**
 *
 * @author Heave
 */
public class Inpatients extends Patients{
    private String wardNumber;
    private String bedNumber;
    // Defines a constructor with no args
    public Inpatients(){
        
    }
    
    //Defines a constructor with args
    public Inpatients(String patientID, String firstName, String lastName,
    int age, String gender, String condition, Category category, String wardNumber, String bedNumber){
        super(patientID, firstName, lastName, age, gender, condition, category);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }
}
