import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class PatientDatabase {
    /*Setting up the patient array and input/output file*/
    static Patient[] patientCollection = new Patient[100];
    static String outputFile = null;

    public PatientDatabase(String patientFile) {
        /*saving output file*/
        outputFile = patientFile;

        /*Setting up inputStream to read from input file*/
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(patientFile));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + patientFile);
            System.exit(0);
        }

        /*Index for input file and array index for patient database*/
        int index = 0;
        int arrayIndex = 0;
        /*Reading all the lines from the input files*/
        while (inputStream.hasNextLine()) {
            if (index % 12 == 0) {
                /*Need the % 12 to find next start of patient*/
                String lastName = inputStream.nextLine();
                String firstName = inputStream.nextLine();
                String address = inputStream.nextLine();
                String phoneNum = inputStream.nextLine();
                String DOB = inputStream.nextLine();
                String insuranceType = inputStream.nextLine();
                String copayString = inputStream.nextLine();
                Float copay = Float.parseFloat(copayString);
                String patientType = inputStream.nextLine();
                String physician = inputStream.nextLine();
                String physicianPhone = inputStream.nextLine();
                String allergies = inputStream.nextLine();
                String illnesses = inputStream.nextLine();
                patientCollection[arrayIndex] = new Patient(lastName, firstName, address, phoneNum, DOB, insuranceType, copay,
                        patientType, physician, physicianPhone, allergies, illnesses);
                arrayIndex = arrayIndex + 1;
                index = index + 1;
            }
            index = index + 1;
        }
        /*Close input stream*/
        inputStream.close();
    }

    /*Making new patient*/
    public static void newPatient(String lName, String fName, String Residence, String phone, String birthDate, String insurance,
                                  Float co_pay, String typePatient, String physicianName, String physicianContact, String allergen,
                                  String sickness) {
        int index = 0;
        /*Finding next open slot in array*/
        while (patientCollection[index] != null) {
            index = index + 1;
        }
        patientCollection[index] = new Patient(lName, fName, Residence, phone, birthDate, insurance, co_pay,
                typePatient, physicianName, physicianContact, allergen, sickness);
    }

    /*Update method to change patient variables*/
    public static String update(String lName, String dateofbirth, String category, String newData) {
        int index = 0;
        while (patientCollection[index] != null){
            if((Objects.equals(patientCollection[index].getLastName(), lName)) && (Objects.equals(patientCollection[index].getDOB(), dateofbirth))) {
                Patient currentPatient = patientCollection[index];
                /*Checking to see if last name and DOB matches*/
                /*Checking if category matches and then what to update*/
                if (Objects.equals(category, "First Name")){
                    currentPatient.updateFirstName(newData);
                }
                else if (Objects.equals(category, "Last Name")){
                    currentPatient.updateLastName(newData);
                }
                else if (Objects.equals(category, "Address")){
                    currentPatient.updateAddress(newData);
                }
                else if (Objects.equals(category, "Phone Number")){
                    currentPatient.updatePhoneNum(newData);
                }
                else if (Objects.equals(category, "Insurance Type")){
                    currentPatient.updateInsuranceType(newData);
                }
                else if (Objects.equals(category, "Copay")){
                    currentPatient.updateCopay(Float.parseFloat(newData));
                }
                else if (Objects.equals(category, "Patient Type")){
                    currentPatient.updatePatientType(newData);
                }
                else if (Objects.equals(category, "Physician")){
                    currentPatient.updatePhysician(newData);
                }
                else if (Objects.equals(category, "Physician Phone Number")){
                    currentPatient.updatePhysicianPhone(newData);
                }
                else if (Objects.equals(category, "Allergy")){
                    currentPatient.updateAllergies(newData);
                }
                else if (Objects.equals(category, "Illness")){
                    currentPatient.updateIllnesses(newData);
                }
                return "Patient updated";
            }
            else{
                index = index + 1;
            }
        }
        /*Reach end of array and could not find patient*/
        return "Could not find patient";
    }

    /*Method of delete patient*/
    public static String deletePatient(String lastName, String DOB) {
        int arrayIndex = 0;
        while (patientCollection[arrayIndex] != null) {
            if (Objects.equals(patientCollection[arrayIndex].getLastName(), lastName) &&
                    Objects.equals(patientCollection[arrayIndex].getDOB(), DOB)) {
                /*If last name and DOB matches, move all patients after current patient to the
                array spot before, effectively deleting the patient while leaving no gaps in the array*/
                while (patientCollection[arrayIndex] != null) {
                    patientCollection[arrayIndex] = patientCollection[arrayIndex + 1];
                    arrayIndex = arrayIndex + 1;
                }
                return "Patient deleted";
            } else {
                arrayIndex = arrayIndex + 1;
            }
        }
        return "Patient not found";
    }

/*Method for displaying a patient*/
    public static String displayPatient(String lastName, String DOB) {
        int index = 0;
        while (patientCollection[index] != null) {
            if (Objects.equals(patientCollection[index].getLastName(), lastName)) {
                if (Objects.equals(patientCollection[index].getDOB(), DOB)) {
                    /*If last name and DOB matches then write output*/
                    return patientCollection[index].writeOutput();
                } else {
                    index = index + 1;
                }
            } else {
                index = index + 1;
            }
        }
        return "Could not find patient";
    }
/*List of summary methods, if the patient physician, insurance type, patient type, etc...
* matches then add to summary the patient last name, first name, and phone number*/
    public static String physicianSummary(String physician) {
        int index = 0;
        String summary = "<html>";
        /*add html so that it writes correctly in the GUI*/
        System.out.println("Patients with physician " + physician + ":");
        while (index < 100) {
            if (patientCollection[index] == null) {
                break;
            }
            if (Objects.equals(patientCollection[index].getPhysician(), physician)) {
                summary = summary + patientCollection[index].getLastName() + ", " + patientCollection[index].getFirstName()
                        + ": " + patientCollection[index].getPhoneNum() + "<br>";
            }
            index = index + 1;
        }
        summary = summary + "</html>";
        return summary;
    }

    public static String patientTypeSummary(String patientType) {
        int index = 0;
        String summary = "<html>";
        System.out.println("Patients who are type " + patientType + ":");
        while (index < 100) {
            if (patientCollection[index] == null) {
                break;
            }
            if (Objects.equals(patientCollection[index].getPatientType(), patientType)) {
                summary = summary + patientCollection[index].getLastName() + ", " + patientCollection[index].getFirstName()
                        + ": " + patientCollection[index].getPhoneNum() + "<br>";
            }
            index = index + 1;
        }
        summary = summary + "</html>";
        return summary;
    }

    public static String insuranceTypeSummary(String insuranceType) {
        int index = 0;
        String summary = "<html>";
        System.out.println("Patients with insurance type, " + insuranceType + ":");
        while (index < 100) {
            if (patientCollection[index] == null) {
                break;
            }
            if (Objects.equals(patientCollection[index].getInsuranceType(), insuranceType)) {
                summary = summary + patientCollection[index].getLastName() + ", " + patientCollection[index].getFirstName()
                        + ": " + patientCollection[index].getPhoneNum() + "<br>";
            }
            index = index + 1;
        }
        summary = summary + "</html>";
        return summary;
    }

    public static String allergySummary(String allergy) {
        int index = 0;
        String summary = "<html>";
        System.out.println("Patients with allergy, " + allergy + ":");
        while (index < 100) {
            if (patientCollection[index] == null) {
                break;
            }
            if (Objects.equals(patientCollection[index].getAllergies(), allergy)) {
                summary = summary + patientCollection[index].getLastName() + ", " + patientCollection[index].getFirstName()
                        + ": " + patientCollection[index].getPhoneNum() + "<br>";
            }
            index = index + 1;
        }
        summary = summary + "</html>";
        return summary;
    }

    public static String illnessSummary(String illness) {
        int index = 0;
        String summary = "<html>";
        System.out.println("Patients with illness, " + illness + ":");
        while (index < 100) {
            if (patientCollection[index] == null) {
                break;
            }
            if (Objects.equals(patientCollection[index].getIllnesses(), illness)) {
                summary = summary + patientCollection[index].getLastName() + ", " + patientCollection[index].getFirstName()
                        + ": " + patientCollection[index].getPhoneNum() + "<br>";
            }
            index = index + 1;
        }
        summary = summary + "</html>";
        return summary;
    }

    /*Save file method to write to output file*/
    public static void saveFile() {
        /*setting up output stream*/
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + outputFile);
            System.exit(0);
        }
        int index = 0;
        /*Write to output file*/
        while (patientCollection[index] != null) {
            Patient curPatient = patientCollection[index];
            outputStream.println(curPatient.getLastName());
            outputStream.println(curPatient.getFirstName());
            outputStream.println(curPatient.getAddress());
            outputStream.println(curPatient.getPhoneNum());
            outputStream.println(curPatient.getDOB());
            outputStream.println(curPatient.getInsuranceType());
            outputStream.println(curPatient.getCopay());
            outputStream.println(curPatient.getPatientType());
            outputStream.println(curPatient.getPhysician());
            outputStream.println(curPatient.getPhysicianPhone());
            outputStream.println(curPatient.getAllergies());
            outputStream.println(curPatient.getIllnesses());
            index = index + 1;
        }
        outputStream.close();

    }
}
