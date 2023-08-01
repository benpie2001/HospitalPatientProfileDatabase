import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class newPatient extends JFrame implements ActionListener {
    /*setting up private variables*/
    private JLabel title, lastNameLabel, firstNameLabel, addressLabel, phoneNumLabel, DOBLabel, insuranceTypeLabel, copayLabel,
            patientTypeLabel, physicianLabel, physicianPhoneLabel, allergyLabel, illnessLabel, patientSuccess;
    private JTextField lastName, firstName, address, phoneNum, DOB, copay, physician, physicianPhone;
    private JFrame newPatientFrame;
    private JPanel newPatientPanel;
    private JComboBox insuranceType, patientType, allergy, illness;
    private String patientFile;

    public newPatient(String inputFile){
        /*setting up frame*/
        newPatientFrame = new JFrame();

        /*saving input file*/
        patientFile = inputFile;

        /*setting up combo box options*/
        String insuranceTypes[] = {"Private", "Government"};
        String patientTypes[] = {"Pediatric", "Adult", "Geriatric"};
        String allergies[] = {"Food", "Medication", "Seasonal", "None", "Other"};
        String illnesses[] = {"Diabetes", "CHD", "Asthma", "None", "Other"};

        /*setting up labels*/
        title = new JLabel("Enter new patient data");
        lastNameLabel = new JLabel("Enter patient last name:");
        firstNameLabel = new JLabel("Enter patient first name:");
        addressLabel = new JLabel("Enter patient address:");
        phoneNumLabel = new JLabel("Enter patient phone number:");
        DOBLabel = new JLabel("Enter patient date of birth:");
        insuranceTypeLabel = new JLabel("Enter patient insurance type:");
        copayLabel = new JLabel("Enter patient copay:");
        patientTypeLabel = new JLabel("Enter patient type:");
        physicianLabel = new JLabel("Enter patient physician:");
        physicianPhoneLabel = new JLabel("Enter patient physician's phone:");
        allergyLabel = new JLabel("Enter patient allergy:");
        illnessLabel = new JLabel("Enter patient illness:");
        patientSuccess = new JLabel("");

        /*setting up textfields*/
        lastName = new JTextField();
        firstName = new JTextField();
        address = new JTextField();
        phoneNum = new JTextField();
        DOB = new JTextField();
        copay = new JTextField();
        physician = new JTextField();
        physicianPhone = new JTextField();

        /*setting up drop down menus*/
        insuranceType = new JComboBox(insuranceTypes);
        patientType = new JComboBox(patientTypes);
        allergy = new JComboBox(allergies);
        illness = new JComboBox(illnesses);

        /*setting up buttons*/
        JButton submit = new JButton("Submit Patient Details");
        submit.addActionListener(this);
        JButton exit = new JButton("Go back");
        exit.addActionListener(this);

        /*setting up panel and adding buttons, labels, textfields, and drop down menus*/
        newPatientPanel = new JPanel();
        newPatientPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        newPatientPanel.setLayout(new GridLayout(0, 1));
        newPatientPanel.add(lastNameLabel);
        newPatientPanel.add(lastName);
        newPatientPanel.add(firstNameLabel);
        newPatientPanel.add(firstName);
        newPatientPanel.add(addressLabel);
        newPatientPanel.add(address);
        newPatientPanel.add(phoneNumLabel);
        newPatientPanel.add(phoneNum);
        newPatientPanel.add(DOBLabel);
        newPatientPanel.add(DOB);
        newPatientPanel.add(insuranceTypeLabel);
        newPatientPanel.add(insuranceType);
        newPatientPanel.add(copayLabel);
        newPatientPanel.add(copay);
        newPatientPanel.add(patientTypeLabel);
        newPatientPanel.add(patientType);
        newPatientPanel.add(physicianLabel);
        newPatientPanel.add(physician);
        newPatientPanel.add(physicianPhoneLabel);
        newPatientPanel.add(physicianPhone);
        newPatientPanel.add(allergyLabel);
        newPatientPanel.add(allergy);
        newPatientPanel.add(illnessLabel);
        newPatientPanel.add(illness);
        newPatientPanel.add(submit);
        newPatientPanel.add(patientSuccess);
        newPatientPanel.add(exit);

        /*add panel to frame*/
        newPatientFrame.add(newPatientPanel, BorderLayout.CENTER);
        newPatientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPatientFrame.setTitle("Patient Profile Interface");
        newPatientFrame.pack();
        newPatientFrame.setVisible(true);

    }
    /*check to make sure copay is an int*/
    public boolean isNotInteger( String input ) {
        try {
            Integer.parseInt( input );
            return false;
        }
        catch( Exception e ) {
            return true;
        }
    }

    /*check to see if submit button is hit and then creating new patient*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Submit Patient Details")){
            /*Make sure textfields are not blank*/
            if((lastName.getText().isEmpty()) || (firstName.getText().isEmpty()) || (address.getText().isEmpty()) ||
                    (phoneNum.getText().isEmpty()) || (DOB.getText().isEmpty()) || (copay.getText().isEmpty()) ||
                    (physician.getText().isEmpty()) || (physicianPhone.getText().isEmpty())){
                patientSuccess.setText("Don't leave fields blank.");
            }
            /*make sure copay is an int*/
            else if(isNotInteger(copay.getText())){
                patientSuccess.setText("Copay needs to be a number");
            }
            else{
                PatientDatabase.newPatient(lastName.getText(), firstName.getText(), address.getText(), phoneNum.getText(),
                        DOB.getText(), insuranceType.getSelectedItem().toString(), Float.valueOf(copay.getText()),
                        patientType.getSelectedItem().toString(), physician.getText(),
                        physicianPhone.getText(), allergy.getSelectedItem().toString(), illness.getSelectedItem().toString());
                patientSuccess.setText("Patient added to database.");
            }
        }
        /*Reopen PPI with the input file and close window*/
        if(s.equals("Go back")){
            PatientProfileInterface patientProfile = new PatientProfileInterface(patientFile);
            newPatientFrame.dispose();
        }
    }
}
