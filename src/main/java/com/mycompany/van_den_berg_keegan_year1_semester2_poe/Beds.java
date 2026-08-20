/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

/**
 *
 * @author Heave
 */
public class Beds {
    String allBeds[][] = 
    {
        {"B01", "B02", "B03", "B04", "B05"},
        {"B06", "B07", "B08", "B09", "B10"},
        {"B11", "B12", "B13", "B14", "B15"},
        {"B16", "B17", "B18", "B19", "B20"}
    };
    String takenBeds[][] = 
    {
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"},
        {"O", "O", "O", "O", "O"}
    };
    
    public String ShowOpenBeds(){
        String message = "";
        for (int i = 0; i < takenBeds.length; i++) {
            for (int j = 0; j < takenBeds[i].length; j++) {
                if (takenBeds[i][j].equals("O")) {
                    message += allBeds[i][j] + "\t";
                }else {
                    message += "---\t";
                }
            }
            message += "\n";
        }
        return message;
    }
    
    public String ShowTakenBeds(){
        String message = "";
        for (int i = 0; i < takenBeds.length; i++) {
            for (int j = 0; j < takenBeds[i].length; j++) {
                if (takenBeds[i][j].equals("T")) {
                    message += allBeds[i][j] + "\t";
                }else {
                    message += "---\t";
                }
            }
            message += "\n";
        }
        return message;
    }
    
    public String ShowAllBeds(){
        String message = "";
        for (int i = 0; i < allBeds.length; i++) {
            for (int j = 0; j < allBeds[i].length; j++) {
                message += allBeds[i][j] + "\t";
            }
            message += "\n";
        }
        return message;
    }
    
    public boolean CheckBed(String bedNumber){
        boolean bedValid = false;
        if (bedNumber.isEmpty()){
            bedValid = false;
        } else {
            for (int i = 0; i < allBeds.length; i++){
                for (int j = 0; j < allBeds[i].length; j++){
                    if (allBeds[i][j].equals(bedNumber)){
                        if (takenBeds[i][j].equals("O")){
                            bedValid = true;
                            break;
                        }
                    }
                }
                if (bedValid){
                    break;
                }
            }
        }
        return bedValid;
    }
    
    public boolean AssignBed(String bedNumber, String patientNumber){
        for (int i = 0; i < allBeds.length; i++){
            for (int j = 0; j < allBeds[i].length; j++){
                if (allBeds[i][j].equals(bedNumber)){
                    takenBeds[i][j] = "T";
                    allBeds[i][j] = patientNumber;
                    return true;
                }
            }
        }
        return false;
    }
    
    public String ReleaseBed(String patientNumber){
        for (int i = 0; i < allBeds.length; i++){
            for (int j = 0; j < allBeds[i].length; j++){
                if (allBeds[i][j].equals(patientNumber)){
                    takenBeds[i][j] = "O";
                    int bedNumber = (i * 5) + j + 1;
                    allBeds[i][j] = String.format("B%02d", bedNumber);
                    return "Bed has been released";
                }
            }
        }
    
        return "Error! Patient not found";
    }
    
    public int CheckForOpenBeds(){
        int openBedCount = 0;
        boolean noSpace = false;
        for (int i = 0; i < takenBeds.length; i++){
            for (int j = 0; j < takenBeds[i].length; j++){
                if (takenBeds[i][j].equals("O")){
                    openBedCount++;
                }
            }
        }
        
        return openBedCount;
    }
}
