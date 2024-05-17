/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author DEAN MARC PECHAYCO
 */
public class AdminLog implements ActionListener{
     JFrame frame = new JFrame();
     JTextField AdUser;
     JPasswordField AdPass;
     JButton AdButton;
 
   public AdminLog(){
      frame.setTitle("Admin");
      frame.setSize(700,500);
      frame.setLayout(null);
      frame.getContentPane().setBackground(Color.cyan);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
      
      JLabel heading = new JLabel ("TECHNOVA INSTITUTE OF COMPUTER SCIENCE");
      JLabel subHeading = new JLabel ("Student Management System ");
      JLabel AdminID = new JLabel ("Admin ID : ");
      JLabel AdminPass = new JLabel ("Password: ");
      AdUser = new JTextField();
      AdPass = new JPasswordField();
      AdButton = new JButton("Log in");
      
      heading.setFont(new Font ("Copperplate Gothic Bold", Font.BOLD, 21));
      subHeading.setFont(new Font ("Copperplate Gothic Light", Font.BOLD, 19));
        
      
      heading.setBounds(60, 80, 700, 50);
      subHeading.setBounds(190, 110, 500, 50);
      AdminID.setBounds(160, 175, 80, 25);
      AdminPass.setBounds(160, 255, 240, 40);
      AdUser.setBounds(230, 170, 240, 40);
      AdPass.setBounds(230, 250, 240, 40);
      AdButton.setBounds(230, 315, 80, 25);
      
      frame.add(heading);
      frame.add(subHeading);
      frame.add(AdminID);
      frame.add(AdminPass);
      frame.add(AdUser);
      frame.add(AdPass);
      frame.add(AdButton);
      
      
     AdButton.addActionListener(this);
     
     frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String adminId = AdUser.getText();
        String adminpass = new String (AdPass.getPassword());
        if ("PUP-Admin".equals (adminId)&& "pupfaculty".equals(adminpass)){
            JOptionPane.showMessageDialog(null, "Log in successful!");
          // Jump to the next page
        }else {
            JOptionPane.showMessageDialog(null, "Wrong Admin ID or Password!");
        }
    }
    
}

