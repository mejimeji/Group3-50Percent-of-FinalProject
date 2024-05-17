/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class WelcomePage implements ActionListener {
    
   JFrame frame = new JFrame();
   JLabel welcomeLabel = new JLabel("WELCOME TO");
   JLabel welcomesLabel = new JLabel("TECHNOVA INSTITUTE OF COMPUTER STUDIES");
   JLabel selectLabel = new JLabel ("Select an option:");
   JButton studentButton = new JButton("STUDENT RECORD");
   JButton gradeButton = new JButton("GRADE");
   JButton attendanceButton = new JButton("ATTENDANCE");
   
    WelcomePage(){
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.blue);
              
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(frame.getWidth()/2,0, frame.getWidth()/2,frame.getHeight());
        panel.setVisible(true);
        panel.setBackground(Color.yellow);
        frame.getContentPane().add(panel);
        
        welcomeLabel.setBounds(60,25,panel.getWidth()-20,35);
        welcomeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomeLabel);
        
        welcomesLabel.setBounds(15,50, panel.getWidth()-20,35);
        welcomesLabel.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        welcomesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(welcomesLabel);
        
        selectLabel.setBounds(15,100, panel.getWidth()-20,35);
        selectLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selectLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(selectLabel);
        
        studentButton.setBounds(50, 150,panel.getWidth()-100, 25);
        studentButton.setFocusable(false);
        studentButton.addActionListener(this);
        panel.add(studentButton);
        
        gradeButton.setBounds(50, 190, panel.getWidth()-100 , 25);
        gradeButton.setFocusable(false);
        gradeButton.addActionListener(this);
        panel.add(gradeButton);
        
        attendanceButton.setBounds(50, 230,panel.getWidth()-100 , 25);
        attendanceButton.setFocusable(false);
        attendanceButton.addActionListener(this);
        panel.add(attendanceButton);
     
             
        ImageIcon image = new ImageIcon ("C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\Project\\src\\main\\java\\Images\\Logo.png");
        
        Image images = image.getImage();
        Image pic =images.getScaledInstance(frame.getWidth()/2, frame.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(pic);
        
        JLabel imageLabel = new JLabel (image);
        imageLabel.setIcon(image);
        imageLabel.setBounds(0, 0, frame.getWidth()/2, frame.getHeight());
        frame.getContentPane().add(imageLabel);

        
                  
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == studentButton){
            frame.dispose();
            StudentRecord record = new StudentRecord();
                }
        
        else if(e.getSource() == gradeButton){
            frame.dispose();
            StudentGrade grade = new StudentGrade();
                }
        
        else if(e.getSource() == attendanceButton){
            frame.dispose();
            StudentAttendance attendance = new StudentAttendance();
                }
        else {
        System.out.println("Unexpected button clicked!");
    }
    }
}

