import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

//Cuevas, Patrick Joshua S.
//BSIT 2-1

public class StudentInfo extends JFrame {
    
    public static void main(String[] args) {
        String[] studentNames = {"Wonyoung", "Shadow", "Kendrick Lamar", "Drake", "Yuno Miles"};
        int[] ages = {19, 22, 21, 22, 19};
        String[] studentNumbers = {"TI-001", "TI-002", "TI-003", "TI-004", "TI-005"};
        new StudentInfo(studentNames, ages, studentNumbers);
    }
    
    private String[][][] studentGrades = {
        {{"Human Computer Interaction", "1.00"}, {"Object Oriented Programming", "1.25"}, {"Information Management", "1.00"}},
        {{"Human Computer Interaction", "1.25"}, {"Object Oriented Programming", "1.50"}, {"Information Management", "1.25"}},
        {{"Human Computer Interaction", "1.00"}, {"Object Oriented Programming", "1.00"}, {"Information Management", "1.00"}},
        {{"Human Computer Interaction", "1.50"}, {"Object Oriented Programming", "1.25"}, {"Information Management", "1.25"}},
        {{"Human Computer Interaction", "1.25"}, {"Object Oriented Programming", "1.25"}, {"Information Management", "1.50"}}
    };
    
    private String[][][] studentAttendance = {
        {{"2024-01-01", "Present"}, {"2024-01-02", "Absent"}, {"2024-01-03", "Present"}},
        {{"2024-01-01", "Absent"}, {"2024-01-02", "Present"}, {"2024-01-03", "Present"}},
        {{"2024-01-01", "Present"}, {"2024-01-02", "Present"}, {"2024-01-03", "Absent"}},
        {{"2024-01-01", "Present"}, {"2024-01-02", "Present"}, {"2024-01-03", "Present"}},
        {{"2024-01-01", "Absent"}, {"2024-01-02", "Absent"}, {"2024-01-03", "Present"}}
    };
    
    private boolean[] deletedStudents;
    public StudentInfo(String[] studentNames, int[] ages, String[] studentNumbers) {
        deletedStudents = new boolean[studentNames.length];
        setTitle("Student Information");
        DefaultTableModel studentinfo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };
        
        studentinfo.addColumn("Student Name");
        studentinfo.addColumn("Age");
        studentinfo.addColumn("Student Number");
        studentinfo.addColumn("View");
        studentinfo.addColumn("Delete");
        for (int i = 0; i < studentNames.length; i++) {
            if (!deletedStudents[i]) {
                studentinfo.addRow(new Object[]{studentNames[i], ages[i], studentNumbers[i], "View", "Delete"});
            }
        }
        
        JTable studenttable = new JTable(studentinfo);
        studenttable.setBackground(new Color(51, 190, 255));
        studenttable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        studenttable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField(), studentNames, studentNumbers, studentGrades, studentAttendance, ages, deletedStudents, studentinfo));
        studenttable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        studenttable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField(), studentNames, studentNumbers, studentGrades, studentAttendance, ages, deletedStudents, studentinfo));
        JScrollPane scrollPane = new JScrollPane(studenttable);
        getContentPane().add(scrollPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setBackground(new Color(255, 246, 51));
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    
    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private final JButton button;
        private String label;
        private String[] studentNames;
        private String[] studentNumbers;
        private String[][][] studentGrades;
        private String[][][] studentAttendance;
        private int[] ages;
        private boolean[] deletedStudents;
        private DefaultTableModel studentinfo;

        public ButtonEditor(JTextField textField, String[] studentNames, String[] studentNumbers, String[][][] studentGrades, String[][][] studentAttendance, int[] ages, boolean[] deletedStudents, DefaultTableModel studentinfo) {
            this.studentNames = studentNames;
            this.studentNumbers = studentNumbers;
            this.studentGrades = studentGrades;
            this.studentAttendance = studentAttendance;
            this.ages = ages;
            this.deletedStudents = deletedStudents;
            this.studentinfo = studentinfo;
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(new Color(51, 190, 255));
            button.addActionListener(e -> {
                JTable table = (JTable) ((JButton) e.getSource()).getParent();
                int row = table.getEditingRow();
                if (row >= 0) {
                    int studentinfoRow = table.convertRowIndexToModel(row);
                    if (label.equals("Delete")) {
                        deletedStudents[studentinfoRow] = true;
                        refreshTable();
                    } 
                    else if (label.equals("View")) {
                        String studentName = studentNames[studentinfoRow];
                        String studentNumber = studentNumbers[studentinfoRow];
                        new GradeAndAttendance(studentName, studentNumber, studentGrades[studentinfoRow], studentAttendance[studentinfoRow]);
                    }
                }
                fireEditingStopped();
            });
        }
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return label;
        }

        private void refreshTable() {
            studentinfo.setRowCount(0);
            for (int i = 0; i < studentNames.length; i++) {
                if (!deletedStudents[i]) {
                    studentinfo.addRow(new Object[]{studentNames[i], ages[i], studentNumbers[i], "View", "Delete"});
                }
            }
        }
    }
}
