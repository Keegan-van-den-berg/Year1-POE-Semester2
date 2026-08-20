/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Heave
 */
public class BedTests {
    
    @Test
    public void testShowOpenBeds(){
        Beds beds = new Beds();
        String expected = "B01\tB02\tB03\tB04\tB05\t\n"
                    + "B06\tB07\tB08\tB09\tB10\t\n"
                    + "B11\tB12\tB13\tB14\tB15\t\n"
                    + "B16\tB17\tB18\tB19\tB20\t\n";
        String result = beds.ShowOpenBeds();
        assertEquals(expected, result);
    }
    
    @Test
    public void testShowTakenBeds(){
        Beds beds = new Beds();
        String expected = "---\t---\t---\t---\t---\t\n"
                    + "---\t---\t---\t---\t---\t\n"
                    + "---\t---\t---\t---\t---\t\n"
                    + "---\t---\t---\t---\t---\t\n";
        String result = beds.ShowTakenBeds();
        assertEquals(expected, result);
    }
    
    @Test
    public void testShowAllBeds(){
        Beds beds = new Beds();
        String expected = "B01\tB02\tB03\tB04\tB05\t\n"
                    + "B06\tB07\tB08\tB09\tB10\t\n"
                    + "B11\tB12\tB13\tB14\tB15\t\n"
                    + "B16\tB17\tB18\tB19\tB20\t\n";
        String result = beds.ShowAllBeds();
        assertEquals(expected, result);
    }
    
    @Test
    public void testCheckBedTrue(){
        Beds beds = new Beds();
        assertTrue(beds.CheckBed("B01"));
    }
    
    @Test
    public void testCheckBedFalse(){
        Beds beds = new Beds();
        beds.AssignBed("B02", "PT01");
        assertFalse(beds.CheckBed("B02"));
    }
    
    @Test
    public void testAssignBedTrue(){
        Beds beds = new Beds();
        assertTrue(beds.AssignBed("B01", "PT01"));
    }
    
    @Test
    public void testAssignBedFalse(){
        Beds beds = new Beds();
        beds.AssignBed("B01", "PT02");
        assertFalse(beds.AssignBed("B01", "PT01"));
    }
    
    @Test
    public void testReleaseBedValid(){
        Beds beds = new Beds();
        beds.AssignBed("B01", "PT01");
        String result = beds.ReleaseBed("PT01");
        assertEquals("Bed has been released", result);
    }
    
    @Test
    public void testReleaseBedInvalid(){
        Beds beds = new Beds();
        String result = beds.ReleaseBed("PT01");
        assertEquals("Error! Patient not found", result);
    }
    
    @Test
    public void testCheckForOpenBeds(){
        Beds beds = new Beds();
        int result = beds.CheckForOpenBeds();
        assertEquals(20, result);
    }
    
}
