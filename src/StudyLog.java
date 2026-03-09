import java.time.LocalDate;

public class StudyLog 
{
    // Variables to store study details
    private LocalDate Date;
    private String Subject;  
    private double Duration;
    private String Description;

    // Parameterized constructor to initialize study log
    public StudyLog(LocalDate a, String b, double c, String d) 
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    // Getter method for Date
    public LocalDate getDate() 
    { 
        return this.Date; 
    }

    // Getter method for Subject
    public String getSubject() 
    { 
        return this.Subject;
    }

    // Getter method for Duration
    public double getDuration() 
    { 
        return this.Duration; 
    }

    // Getter method for Description
    public String getDescription() 
    { 
        return this.Description; 
    }

    // Override toString() method to print study log details
    @Override
    public String toString() 
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }

}   // End of StudyLog