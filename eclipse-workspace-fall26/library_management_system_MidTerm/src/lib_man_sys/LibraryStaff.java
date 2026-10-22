package lib_man_sys;

public abstract class LibraryStaff extends Person
{
	// per req. fields from doc
	final String staffId;
	String department;
	double monthlySalary;

	static int staffCount = 0; // to fill

	public LibraryStaff(int personId, String name, String phoneNumber, String staffId, String department, double monthlySalary) // when adding LibraryStaff will correspond
	{
		super(personId, name, phoneNumber);

		this.staffId = staffId;
		this.department = department;
		this.monthlySalary = monthlySalary;

		staffCount++; // adds to staffCount
	}

	public abstract double calculateMonthlyCompensation(); // declares per doc req.

	public void displayStaffDetails()
	{
		displayBasicDetails(); // displays basic details, this from Person

		System.out.println("Staff ID: " + staffId);
		System.out.println("Department: " + department);
	}

	public static int getStaffCount()
	{
		return staffCount;
	}
}