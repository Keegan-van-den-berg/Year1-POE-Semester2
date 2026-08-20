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
public class InpatientTests {
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
    public void testNewInpatient(){
        Inpatients inpatients = new Inpatients();
        String result = inpatients.NewInpatient("PT03", "John", "Dayley", 60, "Male", "Cancer", 
                Patients.Category.INPATIENT, "W01", "B01");
        
        assertEquals("Inpatient successfully captured", result);
    }
    
}
