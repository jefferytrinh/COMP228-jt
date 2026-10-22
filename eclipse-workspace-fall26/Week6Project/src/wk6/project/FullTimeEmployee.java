package wk6.project;

public class FullTimeEmployee extends Employee
{
	private final double bonusRate = 0.10;
	public FullTimeEmployee(String name, int employeeId, double baseSalary)
	{
		super(name, employeeId, baseSalary);
	}
	@Override
	public double calculateBonus()
	{
		return baseSalary * bonusRate;
	}
	@Override
	public void work()
	{
		super.work();
		System.out.println(getName() + " also attends full-time team meetings.");
	}
	public void approveLeave()
	{
		System.out.println(getName() + " can approve leave requests.");
	}
}
