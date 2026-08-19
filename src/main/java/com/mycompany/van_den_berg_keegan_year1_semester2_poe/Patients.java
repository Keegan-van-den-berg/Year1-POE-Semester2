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
    
    public enum Category{
        INPATIENT,
        OUTPATIENT,
        EMERGENCY
    }
    
    protected String patientID;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String gender;
    protected String condition;
    protected Category category;
    
    public Patients(){
        
    }
    public Patients(String patientID, String firstName, 
            String lastName, int age, String gender, String condition, Category category){
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.condition = condition;
        this.category = category;
    }
    
    
    public String NewPatient(String patientID, String firstName, 
    String lastName, int age, String gender, String condition, Category category){
        try{
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
            
            
            
            patients.put(patient);
            Files.writeString(path, patients.toString(4));
        }catch (IOException e){
            e.printStackTrace();
        } 
        return("Patient Successfully captured");
    }
    
    public boolean ValidatePatientID(String validatePatientID){
        boolean valid = false;
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(validatePatientID)){
                    return false;
                }
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return true;
    }
    
    public String PatientSearch(String SearchPatientID){
        boolean found = false;
        String report = "";
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(SearchPatientID)){
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
    
    public String UpdateDetails(String UpdatePatientID, String Key, String Value){
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(UpdatePatientID)){
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
    
    public String DeletePatient(String DeletePatientID){
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);
            
            JSONArray patients = new JSONArray(content);
            
            for (int i = 0; i < patients.length(); i++){
                JSONObject obj = patients.getJSONObject(i);
                
                String filePatientID = obj.getString("Patient ID");
                
                if(filePatientID.equals(DeletePatientID)){
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
                
                report += "\n\n";
                report += "Patient ID: " + obj.getString("Patient ID");
                report += "\nPatient Name: " + obj.getString("First Name") + " " + obj.getString("Last Name");
                report += "\nPatient Age: " + obj.getInt("Age");
                report += "\nPatient Gender: " + obj.getString("Gender");
                report += "\nPatient Condition: " + obj.getString("Medical Condition");
                report += "\nPatient Category: " + obj.getString("Category");
            }
            
            return report;
            
        } catch (IOException e){
            return "Error: Could not read Patients.json";
        }
        
    }
    
    public int GetPatientCount(){
        try{
            Path path = Path.of("Patients.json");
            String content = Files.readString(path);

            JSONArray patients = new JSONArray(content);

            return patients.length();

        } catch (IOException e){
            return 0;
        }
    }
            
}


