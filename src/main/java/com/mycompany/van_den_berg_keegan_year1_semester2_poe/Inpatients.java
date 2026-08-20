/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

/**
 *
 * @author Heave
 */
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
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
    
    @Override
    public String DisplayAllPatients(){
        String report = "";
        try {
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            JSONArray patients = new JSONArray(content);

            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                String cat = obj.getString("Category");

                report += "\n\n";
                report += "Patient ID: " + obj.getString("Patient ID");
                report += "\nPatient Name: " + obj.getString("First Name") + " " + obj.getString("Last Name");
                report += "\nPatient Age: " + obj.getInt("Age");
                report += "\nPatient Gender: " + obj.getString("Gender");
                report += "\nPatient Condition: " + obj.getString("Medical Condition");
                report += "\nPatient Category: " + cat;

                if (cat.equalsIgnoreCase("INPATIENT")){
                    report += "\nWard Number: " + obj.optString("Ward Number", "N/A");
                    report += "\nBed Number: " + obj.optString("Bed Number", "N/A");
                }
            }
            return report;
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }
    }
    
    public String NewInpatient(String patientID, String firstName, 
        String lastName, int age, String gender, String condition, 
        Category category, String wardNumber, String bedNumber) {
    
        try {
            Path path = Path.of("Patients.json");

            String content = Files.readString(path);
            JSONArray patients = new JSONArray(content);

            JSONObject patient = new JSONObject();

            patient.put("Patient ID", patientID);
            patient.put("First Name", firstName);
            patient.put("Last Name", lastName);
            patient.put("Age", age);
            patient.put("Gender", gender);
            patient.put("Medical Condition", condition);
            patient.put("Category", category);
            patient.put("Ward Number", wardNumber);
            patient.put("Bed Number", bedNumber);

            patients.put(patient);

            Files.writeString(path, patients.toString(4));

            return "Inpatient successfully captured";

        } catch (IOException e) {
            return "Error: Could not write to Patients.json";
        }
    }
}
