/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;



/**
 *
 * @author Aldrin Kyle
 */

   import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GA extends JFrame {
    public GA(String studentName, String studentNumber, String[][] grades, String[][] attendance) {
        setTitle(studentName + " - Grades and Attendance");

        DefaultTableModel gradesModel = new DefaultTableModel();
        gradesModel.addColumn("Subject");
        gradesModel.addColumn("Grade");
        for (String[] grade : grades) {
            gradesModel.addRow(grade);
        }
        JTable gradesTable = new JTable(gradesModel);
        JScrollPane gradesScrollPane = new JScrollPane(gradesTable);
        DefaultTableModel attendanceModel = new DefaultTableModel();
        attendanceModel.addColumn("Date");
        attendanceModel.addColumn("Status");
        for (String[] record : attendance) {
            attendanceModel.addRow(record);
        }
        JTable attendanceTable = new JTable(attendanceModel);
        JScrollPane attendanceScrollPane = new JScrollPane(attendanceTable);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Grades"));
        panel.add(gradesScrollPane);
        panel.add(new JLabel("Attendance"));
        panel.add(attendanceScrollPane);
        getContentPane().add(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
} 

