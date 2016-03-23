/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Test4_1 {

    static JFrame frame = new JFrame("CCE1010 Week 21");
    JTextField jtfName = new JTextField(20);
    JTextField jtfsurName = new JTextField(20);
    JTextField jtfID = new JTextField("M00123456");
    static JTextArea jta = new JTextArea("My details: ");
    String sex;
    static String str;

    public Test4_1() {
        populateFrame();
    }

    public void populateFrame() {
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JLabel jlbName = new JLabel("Name:");
        JLabel jlbsurName = new JLabel("Surname:");
        JLabel jlbID = new JLabel("ID:");
        topPanel.setLayout(new GridLayout(3, 2));
        topPanel.add(jlbName);
        topPanel.add(jtfName);
        topPanel.add(jlbsurName);
        topPanel.add(jtfsurName);
        topPanel.add(jlbID);
        topPanel.add(jtfID);
        JRadioButton jrbM = new JRadioButton("Male");
        jrbM.setActionCommand("Male");
        JRadioButton jrbF = new JRadioButton("Female");
        jrbF.setActionCommand("Female");
        ButtonGroup jrbG = new ButtonGroup();
        JScrollPane scrollPane = new JScrollPane(jta);
        JButton go = new JButton("GO");
        JButton toFile = new JButton("File I/O");
        jrbG.add(jrbM);
        jrbG.add(jrbF);
        midPanel.add(jrbF);
        midPanel.add(jrbM);
        midPanel.add(toFile);
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(jta);
        bottomPanel.add(go);
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        });
        toFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });
        jrbM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "Male";
            }
        });
        jrbF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "Female";
            }
        });
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        sex = e.getActionCommand();
        System.out.println(sex);
    }

    public void display() {
        String name = jtfName.getText();
        String surname = jtfsurName.getText();
        String id = jtfID.getText();
        str = name + " " + surname + " " + id + " " + sex;
        jta.append(str);
    }
    public void writeToFile() {
        String name = jtfName.getText();
        String surname = jtfsurName.getText();
        String id = jtfID.getText();
        str = name + " " + surname + " " + id + " " + sex;
        System.out.println(str);
        WriteTextFile f = new WriteTextFile();
        try {
            f.writeTF(str);
        } catch (IOException ex) {
            Logger.getLogger(Test4_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        new Test4_1();
    }
}
