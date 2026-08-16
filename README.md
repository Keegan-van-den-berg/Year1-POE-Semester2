# \# Medicare Patient Manager

# 

# A Java-based console application for managing patient records. The application allows users to register, search, update, delete, and display patient information stored in a JSON file.

# 

# \## Features

# 

# The Medicare Patient Manager provides the following functionality:

# 

# \* \*\*Register a new patient\*\*

# \* \*\*Search for a patient\*\*

# \* \*\*Update patient details\*\*

# \* \*\*Delete a patient\*\*

# \* \*\*Display all registered patients\*\*

# \* \*\*Validate Patient IDs to prevent duplicates\*\*

# \* \*\*Validate patient input before saving records\*\*

# \* \*\*Store patient records in a JSON file\*\*

# 

# The main menu provides five options for interacting with the patient management system.

# 

# \## Technologies Used

# 

# \* \*\*Java\*\*

# \* \*\*JSON\*\*

# \* \*\*org.json\*\*

# \* \*\*Java NIO Files API\*\*

# \* \*\*Apache NetBeans / Maven\*\*

# 

# The application uses `JSONArray` and `JSONObject` to read and modify patient records stored in `Patients.json`.

# 

# \## Project Structure

# 

# ```text

# Van\_Den\_Berg\_Keegan\_Year1\_Semester2\_POE/

# │

# ├── src/

# │   └── main/

# │       └── java/

# │           └── com/

# │               └── mycompany/

# │                   └── van\_den\_berg\_keegan\_year1\_semester2\_poe/

# │                       ├── Van\_Den\_Berg\_Keegan\_Year1\_Semester2\_POE.java

# │                       └── Patients.java

# │

# ├── Patients.json

# ├── pom.xml

# └── README.md

# ```

# 

# \## Patient Information

# 

# Each patient record contains the following information:

# 

# | Field             | Description                       |

# | ----------------- | --------------------------------- |

# | Patient ID        | Unique identifier for the patient |

# | First Name        | Patient's first name              |

# | Last Name         | Patient's surname                 |

# | Age               | Patient's age                     |

# | Gender            | Patient's gender                  |

# | Medical Condition | Patient's medical condition       |

# | Category          | Patient category                  |

# 

# The JSON file stores each patient as a JSON object inside a JSON array.

# 

# \## Input Validation

# 

# The application performs several validation checks when registering patients.

# 

# \### Patient ID

# 

# Patient IDs must:

# 

# \* Not be empty

# \* Not already exist in the JSON file

# 

# The `ValidatePatientID()` method searches the existing records and prevents duplicate Patient IDs.

# 

# \### Name

# 

# First and last names cannot be left empty.

# 

# \### Age

# 

# The patient's age must be greater than `0` and no greater than `110`.

# 

# \### Gender

# 

# The application currently accepts:

# 

# ```text

# M

# F

# ```

# 

# Any other value is rejected.

# 

# \### Category

# 

# The patient category must be one of:

# 

# ```text

# Inpatient

# Outpatient

# Emergency

# ```

# 

# \## Main Functions

# 

# \### Register New Patient

# 

# The `NewPatient()` method creates a new `JSONObject`, adds the patient's information, adds the object to the existing `JSONArray`, and saves the updated array back to `Patients.json`.

# 

# \### Search For A Patient

# 

# The `PatientSearch()` method searches the JSON array using a Patient ID. If a matching patient is found, their information is displayed.

# 

# Example output:

# 

# ```text

# Patient ID: PT1

# Patient Name: John Van den berg

# Patient Age: 18

# Patient Gender: M

# Patient Medical Condition: Hemriods

# Patient Category: Inpatient

# ```

# 

# The search functionality is implemented by iterating through the JSON array and comparing each patient's Patient ID.

# 

# \### Update Patient Details

# 

# The `UpdateDetails()` method accepts:

# 

# \* Patient ID

# \* JSON key

# \* New value

# 

# It locates the patient and updates the specified JSON value before saving the modified array back to the file.

# 

# \### Delete Patient

# 

# The `DeletePatient()` method searches for a patient using their Patient ID, removes the corresponding object from the JSON array, and writes the updated array back to the file.

# 

# \### Display All Patients

# 

# The `DisplayAllPatients()` method loops through every patient in the JSON array and creates a report containing their information.

# 

# \## How To Run

# 

# 1\. Clone or download the project.

# 2\. Open the project in an IDE such as NetBeans.

# 3\. Ensure the `Patients.json` file is located in the correct working directory.

# 4\. Ensure the required `org.json` dependency is available.

# 5\. Build the Maven project.

# 6\. Run:

# 

# ```text

# Van\_Den\_Berg\_Keegan\_Year1\_Semester2\_POE.java

# ```

# 

# 7\. Select an option from the main menu.

# 

# \## Main Menu

# 

# When the application starts, the following options are available:

# 

# ```text

# =========================================

# ========MEDICARE PATIENT MANAGER=========

# =========================================

# 

# Would you like to:

# \[1] Register New Patient

# \[2] Search For A Patient

# \[3] Update An Existing Patients Details

# \[4] Delete A Patient

# \[5] Display All Registered Patients

# ```

# 

# The menu is implemented using a Java `switch` statement.

# 

# \## Data Storage

# 

# Patient information is stored locally in `Patients.json`.

# 

# Example:

# 

# ```json

# \[

# &#x20;   {

# &#x20;       "Patient ID": "PT1",

# &#x20;       "Category": "Inpatient",

# &#x20;       "First Name": "John",

# &#x20;       "Gender": "M",

# &#x20;       "Last Name": "Van den berg",

# &#x20;       "Medical Condition": "Hemriods",

# &#x20;       "Age": 18

# &#x20;   }

# ]

# ```

# 

# The application reads the JSON file using Java's `Files.readString()` method and writes changes using `Files.writeString()`.

# 

# \## Error Handling

# 

# The application handles `IOException` errors when reading or writing the JSON file.

# 

# Examples of error messages include:

# 

# ```text

# Error: Could not read Patients.json

# Error: Patient ID could not be found

# Error: Patient ID already exists

# Error: Field cannot be empty

# ```

# 

# \## Author

# 

# \*\*Keegan Van den Berg\*\*

# 

# Bachelor of Computer and Information Sciences in Application Development

# 

# \## Project

# 

# \*\*Year 1 Semester 2 POE\*\*

# 

# This project demonstrates the use of Java programming, object-oriented programming concepts, JSON data storage, file handling, input validation, and menu-driven console applications.



