package lib_man_sys;

public class Librarian extends LibraryStaff implements Reportable, Reservable
{
	// per req. fields from doc
	private final int dailyIssueLimit;
	private int booksProcessed;
	
	public Librarian(int personId, String name, String phoneNumber, String staffId, String department, double salary, int dailyIssueLimit, int booksProcessed)
	{
		super(personId, name, phoneNumber, staffId, department, salary);
		
		this.dailyIssueLimit = dailyIssueLimit;
		this.booksProcessed = booksProcessed;
		}
	
	public double calculateLateFee(int daysOverdue)
	{
		if(daysOverdue < 0)
			return 0;
			return daysOverdue * 1.0;
	}
	public double calculateLateFee(int daysOverdue, double dailyRate)
	{
		if(daysOverdue < 0 || dailyRate < 0) // "||" = OR
			return 0;
			return daysOverdue * dailyRate;
	}
	
	@Override
	public double calculateMonthlyCompensation()
	{
		return monthlySalary + (booksProcessed * 2);
	}
	
	@Override
	public void generateReport()
	{
		System.out.println("Library report generated.");
	}

	@Override
	public String getRoleDescription()
	{
		return "Librarian";
	}
	
	@Override
	public void ReserveBook(String bookId) {
		// TODO Auto-generated method stub
		System.out.println("Book " + bookId + " reserved successfully.");
	}
}