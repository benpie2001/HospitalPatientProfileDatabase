import java.util.Objects;

public class Patient {
    /*Setting up all the private variables for patient*/
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNum;
    private String DOB;
    /*Enum type setup, can only be Private/Government */
    private enum insuranceType{Private, Government};
    private insuranceType iType;
    private Float copay;
    private enum patientType{Pediatric, Adult, Geriatric};
    private patientType pType;
    MedicalConditions med;

public class MedicalConditions{
    /*Setting up Medical Conditions private variables*/
    private String physician;
    private String physicianPhone;
    private enum allergies{Food, Medication, Seasonal, None, Other};
    private allergies allergy;
    private enum illnesses{Diabetes, CHD, Asthma, None, Other};
    private illnesses illness;

    /*Medical Conditions default constructor*/
    public MedicalConditions(String physicianName, String physicianContact, String allergen, String sickness){
        physician = physicianName;
        physicianPhone = physicianContact;
        /*How to change enum variables*/
        if (Objects.equals(allergen, "Food")){
            allergy =  MedicalConditions.allergies.Food;
        }
        else if (Objects.equals(allergen, "Medication")){
            allergy =  MedicalConditions.allergies.Medication;
        }
        else if (Objects.equals(allergen, "Seasonal")){
            allergy =  MedicalConditions.allergies.Seasonal;
        }
        else if (Objects.equals(allergen, "None")){
            allergy =  MedicalConditions.allergies.None;
        }
        else{
            allergy =  MedicalConditions.allergies.Other;
        }

        if (Objects.equals(sickness, "Diabetes")){
            illness =  MedicalConditions.illnesses.Diabetes;
        }
        else if (Objects.equals(sickness, "CHD")){
            illness =  MedicalConditions.illnesses.CHD;
        }
        else if (Objects.equals(sickness, "Asthma")){
            illness =  MedicalConditions.illnesses.Asthma;
        }
        else if (Objects.equals(sickness, "None")){
            illness =  MedicalConditions.illnesses.None;
        }
        else{
            illness =  MedicalConditions.illnesses.Other;
        }
    }
}
/*Patient default constructor*/
    public Patient(String lName, String fName, String Residence, String phone, String birthDate, String insurance, Float co_pay,
                   String typePatient, String physicianName, String physicianContact, String allergen, String sickness)
    {
        /*Storing medical conditions in patient*/
        med = new Patient.MedicalConditions(physicianName, physicianContact, allergen, sickness);
        lastName = lName;
        firstName = fName;
        address = Residence;
        phoneNum = phone;
        DOB = birthDate;
        if (Objects.equals(insurance, "Private")){
            iType = insuranceType.Private;
        }
        else{
            iType = insuranceType.Government;
        }
        copay = co_pay;
        if (Objects.equals(typePatient, "Pediatric")){
            pType = patientType.Pediatric;
        }
        else if (Objects.equals(typePatient, "Adult")){
            pType = patientType.Adult;
        }
        else{
            pType = patientType.Geriatric;
        }
    }

    /*All get methods*/
    public String getLastName(){return lastName;}
    public String getFirstName(){return firstName;}
    public String getAddress(){return address;}
    public String getPhoneNum(){return phoneNum;}
    public String getDOB(){return DOB;}
    public String getInsuranceType(){return iType.toString();}
    public Float getCopay(){return copay;}
    public String getPatientType(){return pType.toString();}
    public String getPhysician(){return med.physician;}
    public String getPhysicianPhone(){return med.physicianPhone;}
    public String getAllergies(){return med.allergy.toString();}
    public String getIllnesses(){return med.illness.toString();}

    /*All update methods*/
    void updateLastName(String lName){lastName = lName;}
    void updateFirstName(String fName){firstName = fName;}
    void updateAddress(String residence){address = residence;}
    void updatePhoneNum(String phone){phoneNum = phone;}
    void updateDOB(String birthDate){DOB = birthDate;}
    /*How to update enum*/
    void updateInsuranceType(String insurance){
        if (Objects.equals(insurance, "Private")){
            iType = insuranceType.Private;
        }
        else{
            iType = insuranceType.Government;
        }
    }
    void updateCopay(Float co_pay){copay = co_pay;}
    void updatePatientType(String typePatient){
        if (Objects.equals(typePatient, "Pediatric")){
            pType = patientType.Pediatric;
        }
        else if (Objects.equals(typePatient, "Adult")){
            pType = patientType.Adult;
        }
        else{
            pType = patientType.Geriatric;
        }
    }
    void updatePhysician(String physicianName){med.physician = physicianName;}
    void updatePhysicianPhone(String pPhone){med.physicianPhone = pPhone;}
    void updateAllergies(String allergen){
        if (Objects.equals(allergen, "Food")){
            med.allergy =  MedicalConditions.allergies.Food;
        }
        else if (Objects.equals(allergen, "Medication")){
            med.allergy =  MedicalConditions.allergies.Medication;
        }
        else if (Objects.equals(allergen, "Seasonal")){
            med.allergy =  MedicalConditions.allergies.Seasonal;
        }
        else if (Objects.equals(allergen, "None")){
            med.allergy =  MedicalConditions.allergies.None;
        }
        else{
            med.allergy =  MedicalConditions.allergies.Other;
        }
    }
    void updateIllnesses(String sickness){
        if (Objects.equals(sickness, "Diabetes")){
            med.illness =  MedicalConditions.illnesses.Diabetes;
        }
        else if (Objects.equals(sickness, "CHD")){
            med.illness =  MedicalConditions.illnesses.CHD;
        }
        else if (Objects.equals(sickness, "Asthma")){
            med.illness =  MedicalConditions.illnesses.Asthma;
        }
        else if (Objects.equals(sickness, "None")){
            med.illness =  MedicalConditions.illnesses.None;
        }
        else{
            med.illness =  MedicalConditions.illnesses.Other;
        }
    }

    /*Write output in HTMl form so that it can be outputted properly in the GUI*/
    public String writeOutput(){
        return "Patient last name: " + lastName + "<br>" + "Patient first name: " + firstName + "<br>" + "Patient address: "
                + address + "<br>" + "Patient phone number: " + phoneNum + "<br>" + "Patient date of birth: " + DOB
                + "<br>" + "Patient insurance type: " + iType + "<br>" + "Patient copay: " + copay + "<br>" + "Patient type: "
                + pType + "<br>" + "Patient physician: " + med.physician + "<br>" + "Patient physician's phone: " + med.physicianPhone
                + "<br>" + "Patient allergies: " + med.allergy + "<br>" + "Patient illness: " + med.illness;
    }
}
