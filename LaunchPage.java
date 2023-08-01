import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener {
    /*setting up private variables*/
    private JTextField textField;
    private JLabel label, welcome;
    private JFrame frame;
    private JPanel panel;

    public LaunchPage(){
        /*setting up frame*/
        frame = new JFrame();

        /*setting up labels*/
        welcome = new JLabel("Welcome to the Patient Profile Interface");
        label = new JLabel("Please enter the file you would like to open.");


        /*setting up button to submit input file*/
        JButton button = new JButton("Submit");
        button.addActionListener(this);

        /*setting up text field for input file*/
        textField = new JTextField(16);

        /*setting up panel and adding labels, textfield and button*/
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(welcome);
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        /*add panel to frame*/
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Patient Profile Interface");
        frame.pack();
        frame.setVisible(true);

    }

    /*Check to see when submit button is hit and then open the PPInterface with the input file*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Submit")){
            String inputFile = textField.getText();
            label.setText("Opening file: " + inputFile);
            PatientProfileInterface patientProfile = new PatientProfileInterface(inputFile);
            textField.setText(" ");
            frame.dispose();
        }
    }
}