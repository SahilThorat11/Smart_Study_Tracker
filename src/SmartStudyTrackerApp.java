import java.util.Scanner;

public class SmartStudyTrackerApp
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("------------ Welcome to Smart Study Tracker --------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("Choose mode:");
        System.out.println("1 : Console (CUI)");
        System.out.println("2 : Graphical (GUI)");

        int mode = sobj.nextInt();

        if(mode == 1)
        {
            // Run the old console version
            SmartStudyTrackerConsole consoleApp = new SmartStudyTrackerConsole();
            consoleApp.run();  // We'll create this wrapper for your console code
        }
        else if(mode == 2)
        {
            // Run GUI
            javax.swing.SwingUtilities.invokeLater(() -> {
                new SmartStudyTrackerGUI();
            });
        }
        else
        {
            System.out.println("Invalid choice! Exiting...");
        }

        sobj.close();
    }
}