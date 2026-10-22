package wk6.project;

public class Manager extends FullTimeEmployee
{
	private final String department;
	
	public Manager(String name, int employeeId, double baseSalary, String department)
	{
		super(name, employeeId, baseSalary);
		this.department = department;
	}
	
	@Override
	public void work()
	{
		super.work();
		System.out.println(getName() + " manages the " + department + " department.");
	}
	
	public void conductMeeting()
	{
		System.out.println(getName() + " is conducting a department meeting.");
	}
}
