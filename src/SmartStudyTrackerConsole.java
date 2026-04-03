import java.util.Scanner;

public class SmartStudyTrackerConsole
{
    private SmartStudyTracker tracker; 

    public SmartStudyTrackerConsole()
    {
        tracker = new SmartStudyTracker();
    }

    public void run()
    {
        Scanner sobj = new Scanner(System.in);
        int iChoice = 0;

        do 
        {
            System.out.println("\nSelect an option:");
            System.out.println("1 : Insert new study log");
            System.out.println("2 : View all study logs");
            System.out.println("3 : Export study log to CSV");
            System.out.println("4 : Summary by date");
            System.out.println("5 : Summary by subject");
            System.out.println("6 : Exit");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1 :
                    tracker.InsertLog();
                    break;
                case 2 :
                    tracker.DisplayLog();
                    break;
                case 3 :
                    tracker.ExportCSV();
                    break;
                case 4 :
                    tracker.SummaryByDate();
                    break;
                case 5 :
                    tracker.SummaryBySubject();
                    break;
                case 6 :
                    System.out.println("Exiting console mode...");
                    break;
                default:
                    System.out.println("Please enter valid option");
            }

        } while(iChoice != 6);

        sobj.close();
    }
}