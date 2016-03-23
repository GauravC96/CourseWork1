
package CourseWork;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GUI {

    static JFrame frame = new JFrame("CCE1010 Week 21");
    JTextField jtfName = new JTextField(20);
    JTextField jtfsurName = new JTextField(20);
    JTextField jtfID = new JTextField("M00123456");
    JTextField jtfLabTest = new JTextField("0");
    JTextField jtfQuizes = new JTextField("0");
    JTextField jtfindividual = new JTextField("0");
    static JTextArea jta = new JTextArea("My details: ");
    
    static String str;

    public GUI() {
        populateFrame();
    }

    public void populateFrame() {
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JLabel jlbName = new JLabel("First Name:");
        JLabel jlbsurName = new JLabel("Surname:");
        JLabel jlbID = new JLabel("ID:");
        JLabel jlbLabTest = new JLabel("Lab tests:");
        JLabel jlbQuizes = new JLabel("Quizes");
        JLabel jlbindividual = new JLabel("Individual");

        
        topPanel.setLayout(new GridLayout(0, 2)); // rows , coloums
        topPanel.add(jlbName);
        topPanel.add(jtfName);
        topPanel.add(jlbsurName);
        topPanel.add(jtfsurName);
        topPanel.add(jlbID);
        topPanel.add(jtfID);
        topPanel.add(jlbLabTest);
        topPanel.add(jtfLabTest);
        topPanel.add(jlbQuizes);
        topPanel.add(jtfQuizes);
        topPanel.add(jlbindividual);
        topPanel.add(jtfindividual);
  
        

        ButtonGroup jrbG = new ButtonGroup();
        JScrollPane scrollPane = new JScrollPane(jta);
        JButton Read = new JButton("Read");
        JButton exit = new JButton("Exit");
        JButton Submit = new JButton("Submit");

        
        
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(jta);
        bottomPanel.add(Submit);
        bottomPanel.add(exit);
        bottomPanel.add(Read);
        Read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        });
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void display() {
        String name = jtfName.getText();
        String surname = jtfsurName.getText();
        String id = jtfID.getText();
        String Quizes = jtfQuizes.getText();
        int LabTest = Integer.parseInt(jtfLabTest.getText());
        int individual = Integer.parseInt(jtfindividual.getText());

        
        
        
        str = name + " " + surname + " " + id + " " + LabTest + " " + Quizes + " " + individual;
        jta.append(str);
        
    }
    public void writeToFile() {
        String name = jtfName.getText();
        String surname = jtfsurName.getText();
        String id = jtfID.getText();
        String LabTest = jtfLabTest.getText();
        String Quizes = jtfQuizes.getText();
        String individual = jtfindividual.getText();
        
        
        str = name + " " + surname + " " + id + " " + " " + LabTest + " " + Quizes + " " + individual + " ";
        System.out.println(str);
        WriteTextFile f = new WriteTextFile();
        try {
            f.writeTF(str);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public class Calc {   
            
         
     
         
         
     }
    
    public static void main(String[] args) {

        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        new GUI();
    }
}
