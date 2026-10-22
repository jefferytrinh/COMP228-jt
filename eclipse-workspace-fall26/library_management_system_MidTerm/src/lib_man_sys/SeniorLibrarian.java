package lib_man_sys;

public class SeniorLibrarian extends Librarian
{
	// per req. fields from doc
    private final String specialization;
    private double seniorityAllowance;

    public SeniorLibrarian(int personId, String name, String phoneNumber, String staffId, String department, double salary, int dailyIssueLimit, int booksProcessed, String specialization, double allowance)
    {
        super(personId, name, phoneNumber, staffId, department, salary, dailyIssueLimit, booksProcessed);

        this.specialization = specialization;
        this.seniorityAllowance = allowance;
    }

    @Override
    public double calculateMonthlyCompensation()
    {
        return super.calculateMonthlyCompensation() + seniorityAllowance;
    }

    @Override
    public void displayStaffDetails()
    {
        super.displayStaffDetails();

        System.out.println("Specialization: " + specialization);
    }
}