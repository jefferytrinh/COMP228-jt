package lib_man_sys;

public class Librarian extends LibraryStaff implements Reportable, Reservable
{
	// per req. fields from doc
	private final int dailyIssueLimit;
	private int booksProcessed;
	
	public Librarian(int personId, String name, String phoneNumber, String staffId, String department, double salary, int dailyIssueLimit, int booksProcessed) // when adding Librarian will correspond
	{
		super(personId, name, phoneNumber, staffId, department, salary);
		
		this.dailyIssueLimit = dailyIssueLimit;
		this.booksProcessed = booksProcessed;
		}
	
	public double calculateLateFee(int daysOverdue)
	{
		if(daysOverdue < 0)
			return 0;
			return daysOverdue * 1.0; // so daysOverdue is used and doesnt error
	}
	public double calculateLateFee(int daysOverdue, double dailyRate) // if someone used example "librarian.calculateLateFee(5, 2.50);", would have daysOverdue = 5 and dailyRate = 2.50
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