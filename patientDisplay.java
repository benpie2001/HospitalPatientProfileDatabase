import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientDisplay extends JFrame implements ActionListener {
    /*setting up private variables*/
    private JLabel displayData;
    private JFrame displayFrame;
    private JPanel displayPanel;

    public patientDisplay(String patientData){
        /*setting up the frame*/
        displayFrame = new JFrame();

        /*setting up the labels to display the patient data*/
        displayData = new JLabel(patientData);

        /*add button to close the window*/
        JButton exit = new JButton("Close page");
        exit.addActionListener(this);

        /*setting up panel and adding buttons and labels*/
        displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayPanel.setLayout(new GridLayout(0, 1));
        displayPanel.add(displayData);
        displayPanel.add(exit);

        /*adding panel to frame*/
        displayFrame.add(displayPanel, BorderLayout.CENTER);
        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayFrame.setTitle("Patient Profile Interface");
        displayFrame.pack();
        displayFrame.setVisible(true);

    }

    @Override
    /*checking to see if the close page button is hit*/
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Close page")){
            displayFrame.dispose();
        }
    }
}
