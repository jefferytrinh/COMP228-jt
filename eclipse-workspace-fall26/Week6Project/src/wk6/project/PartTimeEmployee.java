package wk6.project;

public class PartTimeEmployee extends Employee
{
	private final double bonusRate = 0.05;
	public PartTimeEmployee(String name, int employeeId, double baseSalary)
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
		System.out.println(getName() + " works scheduled part-time shifts.");
	}
}
