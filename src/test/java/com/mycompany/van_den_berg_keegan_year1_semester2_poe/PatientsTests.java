/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
/**
 *
 * @author Heave
 */
public class PatientsTests {
    private String originalJson;
    private Path path = Path.of("Patients.json");
    
    @BeforeEach
    public void backupJson() throws IOException {
        originalJson = Files.readString(path);
    }
    
    @AfterEach
    public void restoreJson() throws IOException {
        Files.writeString(path, originalJson);
    }
    
    @Test
    public void testRegisterNewPatientValid(){
        Patients patients = new Patients();
        String result = patients.NewPatient("PT12", "Jane", "Doe", 43, "F", "Flu", Patients.Category.OUTPATIENT);
        assertEquals("Patient Successfully captured", result);
    }
    
    
    @Test
    public void testValidatePatientIDTrue(){
        Patients patients = new Patients();
        assertTrue(patients.ValidatePatientID("PT99"));
    }
    
    @Test
    public void testValidatePatientIDFalse(){
        Patients patients = new Patients();
        assertFalse(patients.ValidatePatientID("PT01"));
    }
    
    @Test
    public void testPatientSearchValid(){
        Patients patients = new Patients();
        String expected = "Patient ID: PT01" +
                            "\nPatient Name: John Doe" +
                            "\nPatient Age: 34" +
                            "\nPatient Gender: M" +
                            "\nPatient Medical Condition: Covid-19" +
                            "\nPatient Category: INPATIENT";
        String result = patients.PatientSearch("PT01");
        assertEquals(expected, result);
    }
    
    @Test
    public void testPatientSearchInvalid(){
        Patients patients = new Patients();
        String expected = "Error: Patient ID not found";
        String result = patients.PatientSearch("PT99");
        assertEquals(expected, result);
    }
    
    @Test
    public void testUpdateDetailsValid(){
        Patients patients = new Patients();
        String result = patients.UpdateDetails("PT01", "First Name", "Bob");
        assertEquals("Details successfully updated", result);
    }
    
    @Test
    public void testUpdateDetailsInvalid(){
        Patients patients = new Patients();
        String result = patients.UpdateDetails("PT99", "First Name", "Bob");
        assertEquals("Error: Patient ID could not be found", result);
    }
    
    @Test
    public void testDeletePatientValid(){
        Patients patients = new Patients();
        String result = patients.DeletePatient("PT01");
        assertEquals("Patient successfully deleted", result);
    }
    
    @Test
    public void testDeletePatientInvalid(){
        Patients patients = new Patients();
        String result = patients.DeletePatient("PT99");
        assertEquals("Error: Patient ID could not be found", result);
    }
    
    @Test
    public void testDisplayAllPatients(){
        Inpatients patients = new Inpatients();
        String expected = "\n\nPatient ID: PT01\n" +
                        "Patient Name: John Doe\n" +
                        "Patient Age: 34\n" +
                        "Patient Gender: M\n" +
                        "Patient Condition: Covid-19\n" +
                        "Patient Category: INPATIENT\n" +
                        "Ward Number: W01\n" +
                        "Bed Number: B01\n" +
                        "\n" +
                        "Patient ID: PT12\n" +
                        "Patient Name: Jane Doe\n" +
                        "Patient Age: 43\n" +
                        "Patient Gender: F\n" +
                        "Patient Condition: Flu\n" +
                        "Patient Category: OUTPATIENT";
        String result = patients.DisplayAllPatients();
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetPatientCount(){
        Patients patients = new Patients();
        int result = patients.GetPatientCount();
        assertEquals(2, result);
    }
}
