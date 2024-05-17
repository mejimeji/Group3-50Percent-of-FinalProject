package StudentManage;

//Christian Harvey G. Capili
//BSIT 2-1

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class StudentInterface implements ActionListener {
    
    private JFrame frame = new JFrame("STUDENT MANAGEMENT SYSTEM");
    private JLabel LabelUsername, LabelPassword, LabelLoginResults, LabelLogo;
    private JTextField TextFieldUsername = new JTextField();
    private JPasswordField PasswordFieldPassword = new JPasswordField();
    private JButton ButtonLogin, ButtonReset;
    private JTextArea TextAreaLoginResults = new JTextArea();
    private ImageIcon Logo;
    
    StudentInterface(){
    
    frame.setSize(600, 570);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new java.awt.Color(179, 179, 255));
    
    Logo = new ImageIcon("C:\\Users\\Harvey\\OneDrive\\Documents\\NetBeansProjects\\StudentManagementSystem\\src\\StudentManagementLogo\\STUDENTMANAGEMENTLOGO (1).png");
    LabelLogo = new JLabel(Logo);
    LabelLogo.setBounds(45,20,497,320);
    
    LabelUsername = new JLabel("ADMIN USER:");
    LabelUsername.setBounds(160, 360, 180, 30);
    LabelUsername.setFont(new Font("Arial", Font.BOLD, 15));
    
    
    LabelPassword = new JLabel("PASSWORD:");
    LabelPassword.setBounds(160, 400, 180, 30);
    LabelPassword.setFont(new Font("Arial", Font.BOLD, 15));
    
    
    TextFieldUsername.setBounds(290, 360, 150,30);
    TextFieldUsername.setFont(new Font("Arial", Font.PLAIN, 15));
    
    
    PasswordFieldPassword.setBounds(290, 400, 150,30);
    PasswordFieldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
    
    
    ButtonLogin = new JButton("Login");
    ButtonLogin.setBounds(200, 450, 100, 30);
    ButtonLogin.setFont(new Font("Arial", Font.PLAIN, 15));
    ButtonLogin.addActionListener(this);
   
    
    ButtonReset = new JButton("Clear");
    ButtonReset.setBounds(310, 450, 100, 30);
    ButtonReset.setFont(new Font("Arial", Font.PLAIN, 15));
    ButtonReset.addActionListener(this);
    
    
    LabelLoginResults = new JLabel("");
    LabelLoginResults.setBounds(20, 200, 480, 30);
    LabelLoginResults.setFont(new Font("Arial", Font.PLAIN, 15));
        
    
    
    frame.add(LabelUsername);
    frame.add(LabelPassword);
    frame.add(TextFieldUsername);
    frame.add(PasswordFieldPassword);
    frame.add(ButtonLogin);
    frame.add(ButtonReset);
    frame.add(LabelLoginResults);
    frame.add(TextAreaLoginResults);   
    frame.setVisible(true);
    frame.setResizable(false);    
    frame.add(LabelLogo);
    
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ButtonLogin){
           frame.dispose();
           StudentRecord record = new StudentRecord();
                                         
        }
        
        else if(e.getSource() == ButtonLogin){
           TextFieldUsername.setText("");
           PasswordFieldPassword.setText("");
           LabelLoginResults.setText("");
           TextAreaLoginResults.setText("");         
        }
        
    }
    
}