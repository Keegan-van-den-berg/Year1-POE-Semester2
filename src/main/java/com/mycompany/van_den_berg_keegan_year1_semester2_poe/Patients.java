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
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
public class Patients {
    
    public String NewPatient(String PatientID, String FirstName, 
    String LastName, int Age, String Gender, String Condition, String Category){
        try{
            Path path = Path.of("Patients.json");
            
            String content = Files.readString(path);
            JSONArray patients = new JSONArray(content);
            
            JSONObject patient = new JSONObject();
            
            patient.put("Patient ID", PatientID);
            patient.put("First Name", FirstName);
            patient.put("Last Name", LastName);
            patient.put("Age", Age);
            patient.put("Gender", Gender);
            patient.put("Medical Condition", Condition);
            patient.put("Category", Category);
            
            patients.put(patient);
            Files.writeString(path, patients.toString(4));
        }catch (IOException e){
            e.printStackTrace();
        } 
        return("Patient Successfully captured");
    }
    
    public boolean ValidatePatientID(String PatientID){
        boolean valid = false;
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(PatientID)){
                    return false;
                }
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return true;
    }
    
    public String PatientSearch(String patientID){
        boolean found = false;
        String report = "";
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(patientID)){
                    found = true;
                    String fileFirstName = obj.getString("First Name");
                    String fileLastName = obj.getString("Last Name");
                    int fileAge = obj.getInt("Age");
                    String fileGender = obj.getString("Gender");
                    String fileCondition = obj.getString("Medical Condition");
                    String fileCategory = obj.getString("Category");
                    
                    report = "Patient ID: " + filePatientID +
                            "\nPatient Name: " + fileFirstName + " " + fileLastName +
                            "\nPatient Age: " + fileAge +
                            "\nPatient Gender: " + fileGender +
                            "\nPatient Medical Condition: " + fileCondition +
                            "\nPatient Category: " + fileCategory;
                    
                    return(report);
                } else {
                    
                    found = false;
                }
            }
            return "Error: Patient ID not found";
            
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }  
    }
    
    public String UpdateDetails(String PatientID, String Key, String Value){
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(PatientID)){
                    obj.put(Key, Value);
                    Files.writeString(path, patients.toString(4));
                    
                    return("Details successfully updated");
                }
            }
            
            return("Error: Patient ID could not be found");
            
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }
        
        
    }
    
    public String DeletePatient(String patientID){
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(patientID)){
                    patients.remove(i);
                    Files.writeString(path, patients.toString(4));
                    return("Patient successfully deleted");
                }
            }
            
            return("Error: Patient ID could not be found");
            
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }
    }
    
    public String DisplayAllPatients(){
        String report = "";
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                report += "Patient ID: " + obj.getString("Patient ID");
                report += "\nPatient Name: " + obj.getString("First Name") + " " + obj.getString("Last Name");
                report += "\nPatient Age: " + obj.getInt("Age");
                report += "\nPatient Gender: " + obj.getString("Gender");
                report += "\nPatient Condition: " + obj.getString("Medical Condition");
                report += "\nPatient Category: " + obj.getString("Category");
                report += "\n\n";
            }
            
            return report;
            
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }
        
    }
            
}


