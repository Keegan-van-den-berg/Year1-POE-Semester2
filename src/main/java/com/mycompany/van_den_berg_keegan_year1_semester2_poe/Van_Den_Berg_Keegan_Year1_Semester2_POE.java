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
        Patients patients = new Patients();
        Beds beds = new Beds();
       
        
        boolean running = true;
        while (running){
            System.out.println("=========================================");
            System.out.println("========MEDICARE PATIENT MANAGER=========");
            System.out.println("=========================================");
        
            System.out.println("\nWould you like to:"
                    + "\n[1] Register New Patient"
                    + "\n[2] Search For A Patient"
                    + "\n[3] Update An Existing Patients Details"
                    + "\n[4] Delete A Patient"
                    + "\n[5] Display All Registered Patients"
                    + "\n[6] Bed Management"
                    + "\n[7] View Reports"
                    + "\n[8] Exit");
        
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            
        
            switch(choice){
                case 1:
                    String newPatientID = "";
                    String newFirstName = "";
                    String newLastName = "";
                    int newAge = 0;
                    String newGender = "";
                    String newCondition = "";
                    Patients.Category newCategory = null;
                    
                    System.out.println("=========================================");
                    System.out.println("========NEW PATIENT REGISTRATION=========");
                    System.out.println("=========================================");
                
                    //Patient ID
                    boolean patientIDValid = false;
                    while (patientIDValid == false){
                        System.out.println("\nPatient ID: ");
                        newPatientID = scanner.nextLine();
                        if (newPatientID.matches("PT\\d{2}") == false){
                            System.out.println("Error: Patient ID already exists");
                        } else if (newPatientID.isEmpty() == true){
                            System.out.println("Error: Field cannot be empty");
                        } else {
                            patientIDValid = true;
                        }
                    }
                
                
                    //First Name
                    boolean firstNameValid = false;
                    while (firstNameValid == false){
                        System.out.println("First name: ");
                        newFirstName = scanner.nextLine();
                        if (newFirstName.isEmpty() == true){
                            System.out.println("Error: Field cannot be empty");
                        } else {
                            firstNameValid = true;
                        }
                    }
                
                
                    //Last Name
                    boolean lastNameValid = false;
                    while (lastNameValid == false){
                        System.out.println("Last name: ");
                        newLastName = scanner.nextLine();
                        if (newLastName.isEmpty() == true){
                            System.out.println("Error: Field cannot be empty");
                        } else {
                            lastNameValid = true;
                        }
                    }
                
                    //Age
                    boolean ageValid = false;
                    while (ageValid == false){
                        System.out.println("Age: ");
                        newAge = scanner.nextInt();
                        scanner.nextLine();
                        if (newAge <= 0 || newAge > 110){
                            System.out.println("Error: Age is not valid");
                        } else {
                            ageValid = true;
                        }
                    }
                
                
                    //Gender
                    boolean genderValid = false;
                    while (genderValid == false){
                        System.out.println("Gender (M/F): ");
                        newGender = scanner.nextLine();
                        if (!newGender.equals("M") && !newGender.equals("F")){
                            System.out.println("Error: Please enter either M or F");
                        } else if (newGender.isEmpty()){
                            System.out.println("Error: Field cannot be empty");    
                        } else {
                            genderValid = true;
                        }
                    }
                
                
                    //Condition
                    boolean conditionValid = false;
                    while (conditionValid == false){
                        System.out.println("Medical condition: ");
                        newCondition = scanner.nextLine();
                        if (newCondition.isEmpty()){
                            System.out.println("Error: Field cannot be empty");    
                        } else {
                            conditionValid = true;
                        }
                    }
                
                
                    //Category
                    boolean categoryValid = false;
                    newCategory = null;
                    while (newCategory == null){
                        System.out.println("Category: ");
                        String categoryInput = scanner.nextLine();
                        try {
                            newCategory = Patients.Category.valueOf(categoryInput.toUpperCase()); 
                            categoryValid = true;
                           
                           
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: Category is not valid");
                        }
                    }
                    
                    // if all the user inputs are valid, the patient will be registered
                    if (patientIDValid && firstNameValid && lastNameValid && ageValid && genderValid && conditionValid && categoryValid){
                        Patients newPatient = new Patients(newPatientID, newFirstName, newLastName,
                                            newAge, newGender, newCondition, newCategory);
                        System.out.println(newPatient.NewPatient(newPatientID, newFirstName, 
                                newLastName, newAge, newGender, newCondition, newCategory));
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
                case 6:
                    System.out.println("=========================================");
                    System.out.println("=============BED MANAGEMENT==============");
                    System.out.println("=========================================");
                
                    System.out.println("\nWould you like to:"
                            + "\n[1] Allocate a bed"
                            + "\n[2] Release a bed"
                            + "\n[3] View complete ward layout"
                            + "\n[4] Display available beds"
                            + "\n[5] Display occupied beds");
                
                    int bedChoice = scanner.nextInt();
                    scanner.nextLine();
                
                    switch (bedChoice){
                        /**
                         * ALLOCATE BED
                         */
                        case 1:
                            //Prevents user from assigning a bed when there are no beds available
                            boolean noSpace = false;
                            if (beds.CheckForOpenBeds() == 20){
                                noSpace = true;
                            } else {
                                noSpace = false;
                            }
                            if (noSpace == false){
                                System.out.println(beds.ShowOpenBeds());
                                System.out.println("Please enter the bed number you would like to allocate a "
                                    + "patient to: ");
                                String bedNumber = scanner.nextLine();
                                if (beds.CheckBed(bedNumber) == false){
                                    System.out.println("Error! Bed already taken");
                                } else {
                                    System.out.println("What is the patient number: ");
                                    String PatientNo = scanner.nextLine();
                                    beds.AssignBed(bedNumber, PatientNo);
                                    System.out.println(beds.ShowAllBeds());
                                }
                            } else {
                                System.out.println("Error! There is no open beds");
                            }
                            
                            break;
                            
                        /**
                         * RELEASE BEDS
                         */
                        case 2:
                            System.out.println(beds.ShowAllBeds());
                            System.out.println("Please enter the patient number of the bed you "
                                    + "would like to release: ");
                            String releasePatientNo = scanner.nextLine();
                            if (releasePatientNo.matches("PT\\d{2}")){
                                System.out.println(beds.ReleaseBed(releasePatientNo));
                            } else {
                                System.out.println("Error! Patient number is incorrectly formatted");
                            }
                            break;
                            
                        /**
                         * VIEW WARD LAYOUT
                         */
                        case 3:
                            System.out.println(beds.ShowAllBeds());
                            break;
                            
                        /**
                         * SHOW AVAILABLE BEDS
                         */
                        case 4:
                            System.out.println(beds.ShowOpenBeds());
                            break;
                            
                        /**
                         * SHOW TAKEN BEDS
                         */
                        case 5:
                            System.out.println(beds.ShowTakenBeds());
                            break;
                        default:
                            System.out.println("Error! Please pick from one of the provided options");
                            break;
                    }
                        
                    break;
                case 7:
                    System.out.println("=========================================");
                    System.out.println("=================REPORTS=================");
                    System.out.println("=========================================");
                    System.out.println("Which report would you like: "
                            + "\n[1] All Reqistered Patients"
                            + "\n[2] All Available Beds"
                            + "\n[3] All Occupied Beds"
                            + "\n[4] The Total Number of Registered Patients"
                            + "\n[5] The Total Number of Occupied Beds"
                            + "\n[6] The Ward Occupancy Percentage");
                    
                    int reportChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch(reportChoice){
                        /**
                         * ALL REGISTERED PATIENTS
                         */
                        case 1:
                            System.out.println(patients.DisplayAllPatients());
                            break;
                            
                        /**
                         * ALL AVAILABLE BEDS
                         */
                        case 2:
                            System.out.println(beds.ShowOpenBeds());
                            break;
                            
                        /**
                         * ALL OCCUPIED BEDS
                         */
                        case 3:
                            System.out.println(beds.ShowTakenBeds());
                            break;
                            
                        /**
                         * TOTAL PATIENTS
                         */
                        case 4:
                            System.out.println("There is a total of " + patients.GetPatientCount() + ""
                                    + " patients.");
                            break;
                            
                        /**
                         * TOTAL OCCUPIED BEDS
                         */
                        case 5:
                            System.out.println("There is a total of " + beds.CheckForOpenBeds() + ""
                                    + " taken beds");
                            break;
                            
                        /**
                         * WARD OCCUPANCY PERCENTAGE
                         */
                        case 6:
                            int occupied = beds.CheckForOpenBeds();
                            double wardPercentage = ((double) occupied / 20) * 100;
                            System.out.println("The ward is " + wardPercentage + "%"
                                    + " full");
                            break;
                        default:
                            System.out.println("Error! Please pick from one of the provided options");
                            break;
                    }
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Error! Please pick from one of the options provided");
            }
            }
        
        }
    }
