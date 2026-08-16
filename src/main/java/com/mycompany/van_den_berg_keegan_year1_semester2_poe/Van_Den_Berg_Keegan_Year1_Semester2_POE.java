/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.van_den_berg_keegan_year1_semester2_poe;

/**
 *
 * @author Heave
 */
import java.util.Scanner;

public class Van_Den_Berg_Keegan_Year1_Semester2_POE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========================================");
        System.out.println("========MEDICARE PATIENT MANAGER=========");
        System.out.println("=========================================");
        
        System.out.println("\nWould you like to:"
                + "\n[1] Register New Patient"
                + "\n[2] Search For A Patient"
                + "\n[3] Update An Existing Patients Details"
                + "\n[4] Delete A Patient"
                + "\n[5] Display All Registered Patients");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        Patients patients = new Patients();
        switch(choice){
            case 1:
                System.out.println("=========================================");
                System.out.println("========NEW PATIENT REGISTRATION=========");
                System.out.println("=========================================");
                
                //Patient ID
                boolean patientIDValid = false;
                String patientID = "";
                while (patientIDValid == false){
                    System.out.println("\nPatient ID: ");
                    patientID = scanner.nextLine();
                    if (patients.ValidatePatientID(patientID) == false){
                        System.out.println("Error: Patient ID already exists");
                    } else if (patientID.isEmpty() == true){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        patientIDValid = true;
                    }
                }
                
                
                //First Name
                boolean firstNameValid = false;
                String firstName = "";
                while (firstNameValid == false){
                    System.out.println("First name: ");
                    firstName = scanner.nextLine();
                    if (firstName.isEmpty() == true){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        firstNameValid = true;
                    }
                }
                
                
                //Last Name
                boolean lastNameValid = false;
                String lastName = "";
                while (lastNameValid == false){
                    System.out.println("Last name: ");
                    lastName = scanner.nextLine();
                    if (lastName.isEmpty() == true){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        lastNameValid = true;
                    }
                }
                
                //Age
                boolean ageValid = false;
                int age = 0;
                while (ageValid == false){
                    System.out.println("Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    if (age == 0 || age > 110){
                        System.out.println("Error: Age is not valid");
                    } else {
                        ageValid = true;
                    }
                }
                
                
                //Gender
                boolean genderValid = false;
                String gender = "";
                while (genderValid == false){
                    System.out.println("Gender (M/F): ");
                    gender = scanner.nextLine();
                    if (!gender.equals("M") && !gender.equals("F")){
                        System.out.println("Error: Please enter either M or F");
                    } else if (gender.isEmpty()){
                        System.out.println("Error: Field cannot be empty");    
                    } else {
                        genderValid = true;
                    }
                }
                
                
                //Condition
                boolean conditionValid = false;
                String condition = "";
                while (conditionValid == false){
                    System.out.println("Medical condition: ");
                    condition = scanner.nextLine();
                    if (condition.isEmpty()){
                        System.out.println("Error: Field cannot be empty");    
                    } else {
                        conditionValid = true;
                    }
                }
                
                
                //Category
                boolean categoryValid = false;
                String category = "";
                while (categoryValid == false){
                    System.out.println("Category: ");
                    category = scanner.nextLine();
                    if (!category.equals("Inpatient") && !category.equals("Outpatient") && !category.equals("Emergency")){
                        System.out.println("Error: Category is not valid");
                    } else if (category.isEmpty()){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        categoryValid = true;
                    }
                }
                
                if (patientIDValid && firstNameValid && lastNameValid && ageValid && genderValid && conditionValid && categoryValid){
                    System.out.println(patients.NewPatient(patientID, firstName, lastName, age, gender, condition, category));
                }
                break;
            case 2:
                System.out.println("=========================================");
                System.out.println("===========SEARCH FOR PATIENT============");
                System.out.println("=========================================");
                
                boolean searchPatientIDValid = false;
                String searchPatientID = "";
                while (searchPatientIDValid == false){
                    System.out.println("\nPlease enter the Patient ID you want to lookup: ");
                    searchPatientID = scanner.nextLine();
                    if (searchPatientID.isEmpty()){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        System.out.println(patients.PatientSearch(searchPatientID));
                        searchPatientIDValid = true;
                    }
                }
                break;
            case 3:
                System.out.println("=========================================");
                System.out.println("=========UPDATE PATIENT DETAILS==========");
                System.out.println("=========================================");
                
                boolean updatePatientIDValid = false;
                String updatePatientID = "";
                while (updatePatientIDValid == false){
                    System.out.println("\nWhat is the Patient ID of the patient you would like to update: ");
                    updatePatientID = scanner.nextLine();
                    if (updatePatientID.isEmpty()){
                        System.out.println("Error: Field cannot be empty");
                    } else {
                        updatePatientIDValid = true;
                    }
                }
                
                System.out.println("What is the Value you would like to update: ");
                String key = scanner.nextLine();
                
                System.out.println("What is the value you would like to change it to: ");
                String value = scanner.nextLine();
                
                System.out.println(patients.UpdateDetails(updatePatientID, key, value));
                
                
                break;
            case 4:
                System.out.println("=========================================");
                System.out.println("============DELETE A PATIENT=============");
                System.out.println("=========================================");
                
                System.out.println("What is the patient ID of the patient you want to delete:");
                String deletePatientID = scanner.nextLine();
                
                System.out.println(patients.DeletePatient(deletePatientID));
                break;
            case 5:
                System.out.println("=========================================");
                System.out.println("==========DISPLAY ALL PATIENTS===========");
                System.out.println("=========================================");
                System.out.println(patients.DisplayAllPatients());
                break;
            default:
                System.out.println("Error! Please pick from one of the options provided");
        }
    }
}
