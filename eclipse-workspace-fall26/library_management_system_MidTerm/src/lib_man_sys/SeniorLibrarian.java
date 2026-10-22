package lib_man_sys;

public class SeniorLibrarian extends Librarian
{
	// per req. fields from doc
	private final String specialization;
	private double seniorityAllowance;

	public SeniorLibrarian(int personId, String name, String phoneNumber, String staffId, String department, double salary, int dailyIssueLimit, int booksProcessed, String specialization, double allowance) // when adding SeniorLibrarian will correspond
	{
		super(personId, name, phoneNumber, staffId, department, salary, dailyIssueLimit, booksProcessed); // super = imm. parent class (SeniorLibrarian)

		this.specialization = specialization;
		this.seniorityAllowance = allowance;
	}

	@Override
	public double calculateMonthlyCompensation() // overridingthe one on LibraryStaff (which kind of does nothign)
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