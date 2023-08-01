import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Objects;

public class PatientProfileInterface extends JFrame implements ActionListener{
    /*Setting up all the private variables for the PPInterface*/
    private JTextField displayPatientName, displayPatientDob, deletePatientName, deletePatientDOB, updatePatientName,
            updatePatientDOB, patientSummaryField, patientUpdateTextField;
    private JLabel welcome, label, delete, deleteConfirm, newPatient, updatePatient, patientSummaryTitle,
            patientSummaryDescription, patientSummary, patientUpdate, lineBreak1, lineBreak2, lineBreak3, lineBreak4;
    private JFrame frame;
    private JPanel panel;
    private JComboBox summaryType, updateField;
    private static PatientDatabase patientCollection;
    private static String patientFile;

    public PatientProfileInterface(String inputFile) {
        /*Making patient database array in PPInterface from inputFile*/
        patientCollection = new PatientDatabase(inputFile);

        /*Saving inputFile*/
        patientFile = inputFile;

        String[] summaryTypes = {"Physician", "Insurance Type", "Patient Type", "Allergy", "Illness"};
        String[] updateFields = {"First Name", "Last Name", "Address", "Phone Number", "Insurance Type", "Copay",
                                 "Patient Type", "Physician", "Physician Phone Number", "Allergy", "Illness"};
/*Creating frame*/
        frame = new JFrame();

        /*Creating all the labels for panel*/
        welcome = new JLabel("Welcome to the Patient Profile Interface");
        newPatient = new JLabel("Enter new Patient:");
        label = new JLabel("Display patient:");
        delete = new JLabel("Delete patient:");
        deleteConfirm = new JLabel("");
        updatePatient = new JLabel("Update patient details:");
        patientSummaryTitle = new JLabel("Search for patients who share data,");
        patientSummaryDescription = new JLabel("Select data point you want to compile:");
        patientSummary = new JLabel("Enter physician's full name");
        patientUpdate = new JLabel("Enter first name");
        lineBreak1 = new JLabel("---------------------------------------------------------------");
        lineBreak2 = new JLabel("---------------------------------------------------------------");
        lineBreak3 = new JLabel("---------------------------------------------------------------");
        lineBreak4 = new JLabel("---------------------------------------------------------------");

/*Creating all the textfields for inputs*/
        displayPatientName = new JTextField("Enter last name", 16);
        displayPatientDob = new JTextField("Enter date of birth", 16);
        deletePatientName = new JTextField("Enter last name", 16);
        deletePatientDOB = new JTextField("Enter date of birth", 16);
        updatePatientName = new JTextField("Enter last name", 16);
        updatePatientDOB = new JTextField("Enter date of birth", 16);
        patientSummaryField = new JTextField("",16);
        patientUpdateTextField = new JTextField("", 16);

        /*Creating buttons in order to run functions*/
        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(this);
        /*ActionListener used to trigger functions*/
        JButton deleteButton = new JButton("Delete Patient");
        deleteButton.addActionListener(this);
        JButton newPatientButton = new JButton("Enter new Patient Here");
        newPatientButton.addActionListener(this);
        JButton updatePatientButton = new JButton("Update Patient");
        updatePatientButton.addActionListener(this);
        JButton summaryButton = new JButton("View Summary");
        summaryButton.addActionListener(this);
        JButton saveButton = new JButton("Save and Exit");
        saveButton.addActionListener(this);

        /*Combo boxes used for drop downs*/
        summaryType = new JComboBox(summaryTypes);
        updateField = new JComboBox(updateFields);

        /*Actions listener used to see what the summary type is to tell
        * users what to input into text field*/
        summaryType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(summaryType.getSelectedItem() == "Physician"){
                    patientSummary.setText("Enter physician's full name");
                }
                else if(summaryType.getSelectedItem() == "Insurance Type"){
                    patientSummary.setText("Enter 'Government' or 'Private'");
                }
                else if(summaryType.getSelectedItem() == "Patient Type"){
                    patientSummary.setText("Enter 'Pediatric', 'Adult' or 'Geriatric'");
                }
                else if(summaryType.getSelectedItem() == "Allergy"){
                    patientSummary.setText("Enter 'Food', 'Medication', 'Seasonal', 'None', or 'Other'");
                }
                else if(summaryType.getSelectedItem() == "Illness"){
                    patientSummary.setText("Enter 'Diabetes', 'CHD', 'Asthma', 'None' or 'Other'");
                }
            }
        });

        /*Action listener used to see what the update dropdown is to change what the
        * patient to input into the textfield*/
        updateField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateField.getSelectedItem() == "First Name"){
                    patientUpdate.setText("Enter new first name");
                }
                else if(updateField.getSelectedItem() == "Last Name"){
                    patientUpdate.setText("Enter new last name");
                }
                else if(updateField.getSelectedItem() == "Address"){
                    patientUpdate.setText("Enter new address");
                }
                else if(updateField.getSelectedItem() == "Phone Number"){
                    patientUpdate.setText("Enter new phone number");
                }
                else if(updateField.getSelectedItem() == "Insurance Type"){
                    patientUpdate.setText("Enter 'Private' or 'Government'");
                }
                else if(updateField.getSelectedItem() == "Copay"){
                    patientUpdate.setText("Enter new copay");
                }
                else if(updateField.getSelectedItem() == "Patient Type"){
                    patientUpdate.setText("Enter 'Pediatric', 'Adult' or 'Geriatric'");
                }
                else if(updateField.getSelectedItem() == "Physician"){
                    patientUpdate.setText("Enter new physician");
                }
                else if(updateField.getSelectedItem() == "Physician Phone Number"){
                    patientUpdate.setText("Enter new physician phone number");
                }
                else if(updateField.getSelectedItem() == "Allergy"){
                    patientUpdate.setText("Enter 'Food', 'Medication', 'Seasonal', 'None', or 'Other'");
                }
                else if(updateField.getSelectedItem() == "Illness"){
                    patientUpdate.setText("Enter 'Diabetes', 'CHD', 'Asthma', 'None' or 'Other'");
                }
            }
        });
/*setting up panel add adding all textfields, buttons, and comboboxes*/
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(welcome);
        panel.add(newPatient);
        panel.add(newPatientButton);
        panel.add(lineBreak1);
        panel.add(label);
        panel.add(displayPatientName);
        panel.add(displayPatientDob);
        panel.add(displayButton);
        panel.add(lineBreak2);
        panel.add(updatePatient);
        panel.add(updatePatientName);
        panel.add(updatePatientDOB);
        panel.add(updateField);
        panel.add(patientUpdate);
        panel.add(patientUpdateTextField);
        panel.add(updatePatientButton);
        panel.add(lineBreak3);
        panel.add(patientSummaryTitle);
        panel.add(patientSummaryDescription);
        panel.add(summaryType);
        panel.add(patientSummaryField);
        panel.add(patientSummary);
        panel.add(summaryButton);
        panel.add(lineBreak4);
        panel.add(delete);
        panel.add(deletePatientName);
        panel.add(deletePatientDOB);
        panel.add(deleteButton);
        panel.add(deleteConfirm);
        panel.add(saveButton);

        /*adding panel to frame*/
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Patient Profile Interface");
        frame.pack();
        frame.setVisible(true);
    }

    /*Method used to check if the copay input is an int*/
    public boolean isNotInteger( String input ) {
        try {
            Integer.parseInt( input );
            return false;
        }
        catch( Exception e ) {
            return true;
        }
    }

    /*Launch page opens first in order to get input file*/
    public static void main(String[] args){
        new LaunchPage();
    }

    /*action performed to read button outputs*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        /*If display button is hit then run display class and open new window*/
            if (s.equals("Display")) {
                String lastName = displayPatientName.getText();
                String DOB = displayPatientDob.getText();
                String patient = PatientDatabase.displayPatient(lastName, DOB);
                String patientData = "<html>" + patient + "</html>";
                new patientDisplay(patientData);
            }
            /*If delete patient button is hit then delete patient*/
            if (s.equals("Delete Patient")) {
                String lastName = deletePatientName.getText();
                String DOB = deletePatientDOB.getText();
                deleteConfirm.setText(PatientDatabase.deletePatient(lastName, DOB));
            }
            /*If new patient button hit then run new patient class in new window*/
            if (s.equals("Enter new Patient Here")) {
                new newPatient(patientFile);
                /*close window*/
                frame.dispose();
            }
            /*If save and exit button hit then save the file and close the window*/
            if(s.equals("Save and Exit")){
                PatientDatabase.saveFile();
                frame.dispose();
            }
            /*If view summary button hit then check to see what the drop down selection is and
            * then run patient display on the summary given*/
            if(s.equals("View Summary")){
                if(summaryType.getSelectedItem() == "Physician"){
                    String summary = PatientDatabase.physicianSummary(patientSummaryField.getText());
                    new patientDisplay(summary);
                }
                else if(summaryType.getSelectedItem() == "Insurance Type"){
                    String summary = PatientDatabase.insuranceTypeSummary(patientSummaryField.getText());
                    new patientDisplay(summary);
                }
                else if(summaryType.getSelectedItem() == "Patient Type"){
                    String summary = PatientDatabase.patientTypeSummary(patientSummaryField.getText());
                    new patientDisplay(summary);
                }
                else if(summaryType.getSelectedItem() == "Allergy"){
                    String summary = PatientDatabase.allergySummary(patientSummaryField.getText());
                    new patientDisplay(summary);
                }
                else if(summaryType.getSelectedItem() == "Illness"){
                    String summary = PatientDatabase.illnessSummary(patientSummaryField.getText());
                    new patientDisplay(summary);
                }
            }
            /*If update patient button is hit then get the drop down menu option and change
            * the patient data and display it*/
            if (s.equals("Update Patient")) {
                String lastName = updatePatientName.getText();
                String DOB = updatePatientDOB.getText();
                String category = updateField.getSelectedItem().toString();
                String change = patientUpdateTextField.getText();

                /*Make sure copay is a number or it crashes*/
                if(Objects.equals(category, "Copay")){
                    if(isNotInteger(patientUpdateTextField.getText())){
                        patientUpdate.setText("Copay needs to be a number");
                    }
                    else{
                        String success = PatientDatabase.update(lastName, DOB, category, change);
                        patientUpdate.setText(success);
                        String patient = PatientDatabase.displayPatient(lastName, DOB);
                        String patientData = "<html>" + patient + "</html>";
                        new patientDisplay(patientData);
                    }
                }
                else{
                    String success = PatientDatabase.update(lastName, DOB, category, change);
                    patientUpdate.setText(success);
                    if(Objects.equals(category, "Last Name")){
                        lastName = change;
                    }
                    String patient = PatientDatabase.displayPatient(lastName, DOB);
                    String patientData = "<html>" + patient + "</html>";
                    new patientDisplay(patientData);
                }
            }
        }
    }

