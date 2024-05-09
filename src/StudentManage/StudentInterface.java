package StudentManage;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Edmundo Dela Cruz
 */
public class StudentInterface implements ActionListener {
    
    private JFrame f = new JFrame("Student Login");
    private JLabel lblUsername, lblPassword, lblLoginResults;
    private JTextField txtfldUsername = new JTextField();
    private JPasswordField psswrdfldPassword = new JPasswordField();
    private JButton btnLogIn, btnReset;
    private JTextArea txtareaLoginResults = new JTextArea();

    
    StudentInterface(){
    
    f.setSize(350, 400);
    f.setLayout(null);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    
    
    lblUsername = new JLabel("STUDENT NO.:");
    lblUsername.setBounds(20, 50, 180, 30);
    lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
    
    
    lblPassword = new JLabel("PASSWORD:");
    lblPassword.setBounds(20, 100, 180, 30);
    lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
    
    
    txtfldUsername.setBounds(160, 50, 150,30);
    txtfldUsername.setFont(new Font("Arial", Font.PLAIN, 15));
    
    
    psswrdfldPassword.setBounds(160, 100, 150,30);
    psswrdfldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    
    
    btnLogIn = new JButton("Login");
    btnLogIn.setBounds(50, 150, 100, 30);
    btnLogIn.setFont(new Font("Arial", Font.PLAIN, 15));
    btnLogIn.addActionListener(this);
   
    
    btnReset = new JButton("Clear");
    btnReset.setBounds(180, 150, 100, 30);
    btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
    btnReset.addActionListener(this);
    
    
    lblLoginResults = new JLabel("");
    lblLoginResults.setBounds(20, 200, 480, 30);
    lblLoginResults.setFont(new Font("Arial", Font.PLAIN, 15));
    
  
    
    f.add(lblUsername);
    f.add(lblPassword);
    f.add(txtfldUsername);
    f.add(psswrdfldPassword);
    f.add(btnLogIn);
    f.add(btnReset);
    f.add(lblLoginResults);
    f.add(txtareaLoginResults);
   
    f.setVisible(true);
    f.setResizable(false);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnLogIn){
           String username = txtfldUsername.getText();
           String password = psswrdfldPassword.getText();
           lblLoginResults.setText("Meron ka bang lemon, gusto ko ng tequila!!");
           txtareaLoginResults.setText("Your username is: "+username+"\nPassword is: "+password);
        }else if(e.getSource() == btnReset){
           txtfldUsername.setText("");
           psswrdfldPassword.setText("");
           lblLoginResults.setText("");
           txtareaLoginResults.setText("");         
        }
        
    }
    
}