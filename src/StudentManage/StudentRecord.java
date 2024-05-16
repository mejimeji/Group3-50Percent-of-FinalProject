package StudentManage;

//Christian Harvey G. Capili
//BSIT 2-1
// Draft Tables and Listing

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class StudentRecord implements ActionListener {
    
    private JPanel Header,Footer; //still working on this part
    private JFrame Frame = new JFrame ("STUDENT RECORD");
    private JTable Table;
    private DefaultTableModel Model;
    private JButton AddButton, DeleteButton;  
    
    public StudentRecord() {
        
        String[] StudentInfo = { "Student No.", "Last Name", "First Name", "Middle Name", "Age", "English", "Mathematics", "Science" };

        Model = new DefaultTableModel(StudentInfo, 0);        
        Table = new JTable(Model);        
                                                
        AddButton = new JButton("Add Student");
        AddButton.addActionListener(this);
        AddButton.setBackground(Color.LIGHT_GRAY);
        
        DeleteButton = new JButton("Delete Student");
        DeleteButton.addActionListener(this);
        DeleteButton.setBackground(Color.LIGHT_GRAY);
        
        JScrollPane scrollPane = new JScrollPane(Table);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(AddButton);
        buttonPanel.add(DeleteButton);
          
        Frame.add(scrollPane, java.awt.BorderLayout.CENTER);
        Frame.add(buttonPanel, java.awt.BorderLayout.SOUTH);      
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        Frame.getContentPane().setBackground(new java.awt.Color(66,62,173));  
        Frame.setVisible(true);
        Frame.setBounds(0,100,600,570);                
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddButton) {

            Model.addRow(new Object[Model.getColumnCount()]);
        } else if (e.getSource() == DeleteButton) {

            int selectedRow = Table.getSelectedRow();
            if (selectedRow != -1) {
                Model.removeRow(selectedRow);
        } else {
                JOptionPane.showMessageDialog(Frame, "Select a row to delete!");
        }
        }
    }
}