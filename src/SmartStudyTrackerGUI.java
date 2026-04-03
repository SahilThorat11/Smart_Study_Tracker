import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class SmartStudyTrackerGUI 
{
    private SmartStudyTracker tracker;
    private JFrame frame;
    private JTextField subjectField, durationField, descField;
    private DefaultTableModel tableModel;

    public SmartStudyTrackerGUI() 
    {
        tracker = new SmartStudyTracker();

        frame = new JFrame("Smart Study Tracker");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel (Input)
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        inputPanel.add(subjectField);

        inputPanel.add(new JLabel("Duration (hours):"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Description:"));
        descField = new JTextField();
        inputPanel.add(descField);

        JButton addBtn = new JButton("Add Log");
        inputPanel.add(addBtn);

        JButton exportBtn = new JButton("Export CSV");
        inputPanel.add(exportBtn);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table (Center)
        String[] columns = {"Date", "Subject", "Duration", "Description"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Panel (Actions)
        JPanel bottomPanel = new JPanel();

        JButton viewBtn = new JButton("View Logs");
        JButton summaryDateBtn = new JButton("Summary by Date");
        JButton summarySubjectBtn = new JButton("Summary by Subject");

        bottomPanel.add(viewBtn);
        bottomPanel.add(summaryDateBtn);
        bottomPanel.add(summarySubjectBtn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // ================= EVENTS =================

        // Add Log Button
        addBtn.addActionListener(e -> {
            try 
            {
                String subject = subjectField.getText();
                double duration = Double.parseDouble(durationField.getText());
                String desc = descField.getText();

                StudyLog log = new StudyLog(LocalDate.now(), subject, duration, desc);
                tracker.addLogFromGUI(log);  // NEW METHOD

                JOptionPane.showMessageDialog(frame, "Log added!");

                subjectField.setText("");
                durationField.setText("");
                descField.setText("");
            } 
            catch(Exception ex) 
            {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        // View Logs
        viewBtn.addActionListener(e -> {
            tableModel.setRowCount(0);

            for (StudyLog s : tracker.getAllLogs())  // NEW METHOD
            {
                tableModel.addRow(new Object[]{
                    s.getDate(),
                    s.getSubject(),
                    s.getDuration(),
                    s.getDescription()
                });
            }
        });

        // Export CSV
        exportBtn.addActionListener(e -> {
            tracker.ExportCSV();
            JOptionPane.showMessageDialog(frame, "Exported successfully!");
        });

        // Summary by Date
        summaryDateBtn.addActionListener(e -> {
            String result = tracker.getSummaryByDate();  // NEW METHOD
            JOptionPane.showMessageDialog(frame, result);
        });

        // Summary by Subject
        summarySubjectBtn.addActionListener(e -> {
            String result = tracker.getSummaryBySubject();  // NEW METHOD
            JOptionPane.showMessageDialog(frame, result);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new SmartStudyTrackerGUI();
    }
}