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
    
    private JPanel header,footer;
    private JFrame frame = new JFrame ("STUDENT RECORD");
    private JTable table;
    private DefaultTableModel model;
    private JButton addButton, deleteButton;  
    
    public StudentRecord() {
        
        String[] StudentInfo = { "Student No.", "Last Name", "First Name", "Middle Name", "Age", "English", "Mathematics", "Science" };

        model = new DefaultTableModel(StudentInfo, 0);        
        table = new JTable(model);        
                                                
        addButton = new JButton("Add Student");
        addButton.addActionListener(this);
        addButton.setBackground(Color.LIGHT_GRAY);
        
        deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.LIGHT_GRAY);
        
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
          
        frame.add(scrollPane, java.awt.BorderLayout.CENTER);
        frame.add(buttonPanel, java.awt.BorderLayout.SOUTH);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        frame.getContentPane().setBackground(new java.awt.Color(66,62,173));  
        frame.setVisible(true);
        frame.setBounds(0,100,600,570);
               
 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {

            model.addRow(new Object[model.getColumnCount()]);
        } else if (e.getSource() == deleteButton) {

            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
        } else {
                JOptionPane.showMessageDialog(frame, "Select a row to delete!");
            }
        }
    }
}