import java.util.*;

class SmartStudyTrackerApp
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        // Object of SmartStudyTracker class
        SmartStudyTracker saobj = new SmartStudyTracker();

        // Welcome message
        System.out.println("----------------------------------------------------------");
        System.out.println("------------ Welcome to Smart Study Tracker --------------");
        System.out.println("----------------------------------------------------------");

        int iChoice = 0;

        // Menu driven loop
        do 
        {
            // Display menu options
            System.out.println("\nSelect an option:");
            System.out.println("1 : Insert new study log");
            System.out.println("2 : View all study logs");
            System.out.println("3 : Export study log to CSV");
            System.out.println("4 : Summary by date");
            System.out.println("5 : Summary by subject");
            System.out.println("6 : Exit");

            // Take user choice
            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                // Insert new study log
                case 1 :
                    saobj.InsertLog();
                    break;
                
                // Display all study logs
                case 2 :
                    saobj.DisplayLog();
                    break;

                // Export study logs to CSV file
                case 3 :
                    saobj.ExportCSV();
                    break;
                
                // Display summary by date
                case 4 :
                    saobj.SummaryByDate();
                    break;
                
                // Display summary by subject
                case 5 :
                    saobj.SummaryBySubject();
                    break;

                // Exit application
                case 6 :             
                    System.out.println("----------------------------------------------------------");
                    System.out.println("------ Thank you for using Smart Study Tracker -----------");
                    System.out.println("----------------------------------------------------------");
                    break;

                // Handle invalid option
                default:
                    System.out.println("Please enter valid option");
                    break;
            }

        } while(iChoice != 6);   // Loop runs until user selects Exit
    
    } // End of main

} // End of class