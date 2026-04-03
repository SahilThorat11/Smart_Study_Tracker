import java.util.*;
import java.time.LocalDate;
import java.io.*;
 
public class SmartStudyTracker
{
    // ArrayList used as in-memory database
    private ArrayList<StudyLog> Database = new ArrayList<>();

    // Method to insert new study log
    public void InsertLog() 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("___________ Enter valid details of your study ____________");
        System.out.println("----------------------------------------------------------");

        // Get current date
        LocalDate Dateobj = LocalDate.now();

        // Take subject input
        System.out.print("Enter subject (e.g., Java, Python): ");
        String sub = sobj.nextLine();

        // Take duration input
        System.out.print("Enter duration in hours: ");
        double dur = sobj.nextDouble();

        sobj.nextLine();

        // Take description input
        System.out.print("Enter study description: ");
        String desc = sobj.nextLine();

        // Create StudyLog object
        StudyLog studyobj = new StudyLog(Dateobj, sub, dur, desc);

        // Store in database
        Database.add(studyobj);

        System.out.println("Study log stored successfully.");
        System.out.println("----------------------------------------------------------");

        sobj.close();
    }

    // Method to display all logs
    public void DisplayLog() 
    {
        System.out.println("----------------------------------------------------------");

        if(Database.isEmpty()) 
        {
            System.out.println("----------------- Nothing to display ! -------------------");
            System.out.println("----------------------------------------------------------");
            return;
        }

        System.out.println("-----------------Log report of SmartStudyTracker ---------");
        System.out.println("----------------------------------------------------------");

        // Display each study log
        for (StudyLog s : Database) 
        {
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------------");
    }

    // Method to export logs to CSV
    public void ExportCSV() 
    {
        if(Database.isEmpty()) 
        {
            System.out.println("----------------- Nothing to export! --------------------");
            return;
        }

        try 
        {
            // Create data folder if not exists
            File dir = new File("data");
            if (!dir.exists()) 
            {
                dir.mkdir();
            }

            String FileName = "../Data/SmartStudyTracker.csv";

            // FileWriter to write CSV
            FileWriter fwobj = new FileWriter(FileName);

            // CSV header
            fwobj.write("Date,Subject,Duration,Description\n");

            // Write each log entry
            for (StudyLog s : Database) 
            {
                fwobj.write(s.getDate() + "," + 
                            s.getSubject().replace(",", " ") + "," + 
                            s.getDuration() + "," + 
                            s.getDescription().replace(",", " ") + "\n");
            }

            fwobj.close();

            System.out.println("Data exported to CSV: " + FileName);

        } 
        catch(Exception eobj) 
        {
            System.out.println("Exception occurred in CSV handling: " + eobj.getMessage());
            eobj.printStackTrace();
        }
    }

    // Method to generate summary by date
    public void SummaryByDate() 
    {
        System.out.println("----------------------------------------------------------");

        if(Database.isEmpty()) 
        {
            System.out.println("----------------- Nothing To Display ! -------------------");
            System.out.println("----------------------------------------------------------");
            return;
        }

        System.out.println("----------- Summary by Date -----------");

        TreeMap<LocalDate, Double> summary = new TreeMap<>();

        LocalDate lobj = null;
        double d = 0.0, old = 0.0;

        // Calculate total duration per date
        for(StudyLog sobj : Database) 
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(summary.containsKey(lobj))
            {
                old = summary.get(lobj);
                summary.put(lobj, d + old);
            }
            else
            {
                summary.put(lobj, d);
            }
        }

        // Display summary
        for(LocalDate l : summary.keySet()) 
        {
            System.out.println("Date : " + l + " | Total Study duration : " + summary.get(l));
        }

        System.out.println("----------------------------------------------------------");
    }

    // Method to generate summary by subject
    public void SummaryBySubject() 
    {
        System.out.println("----------------------------------------------------------");

        if(Database.isEmpty()) 
        {
            System.out.println("----------------- Nothing To Display ! -------------------");
            System.out.println("----------------------------------------------------------");
            return;
        }

        System.out.println("--------- Summary by Subject ----------");

        TreeMap<String, Double> summary = new TreeMap<>();

        String s = null;
        double d = 0.0, old = 0.0;

        // Calculate total duration per subject
        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(summary.containsKey(s))
            {
                old = summary.get(s);
                summary.put(s, d + old);
            }
            else
            {
                summary.put(s, d);
            }
        }

        // Display subject summary
        for(String sub : summary.keySet()) 
        {
            System.out.println("Subject : " + sub + " | Total Study duration : " + summary.get(sub));
        }

        System.out.println("----------------------------------------------------------");  
    }

     // Add log from GUI
    public void addLogFromGUI(StudyLog log)
    {
        Database.add(log);
    }

    // Return all logs
    public ArrayList<StudyLog> getAllLogs()
    {
        return Database;
    }

    // Return summary by date (String format)
    public String getSummaryByDate()
    {
        TreeMap<LocalDate, Double> summary = new TreeMap<>();

        for(StudyLog s : Database)
        {
            summary.put(s.getDate(),
                summary.getOrDefault(s.getDate(), 0.0) + s.getDuration());
        }

        StringBuilder sb = new StringBuilder();

        for(LocalDate d : summary.keySet())
        {
            sb.append(d + " : " + summary.get(d) + " hrs\n");
        }

        return sb.toString();
    }

    // Return summary by subject (String format)
    public String getSummaryBySubject()
    {
        TreeMap<String, Double> summary = new TreeMap<>();

        for(StudyLog s : Database)
        {
            summary.put(s.getSubject(),
                summary.getOrDefault(s.getSubject(), 0.0) + s.getDuration());
        }

        StringBuilder sb = new StringBuilder();

        for(String sub : summary.keySet())
        {
            sb.append(sub + " : " + summary.get(sub) + " hrs\n");
        }

        return sb.toString();
    }
}