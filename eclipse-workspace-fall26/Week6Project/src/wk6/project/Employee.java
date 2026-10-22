package wk6.project;

public abstract class Employee extends Person
{
	public Employee(String name, int employeeId, double baseSalary)
	{
		super(name);
		this.employeeId = employeeId;
		this.baseSalary = baseSalary;
	}

	private final int employeeId;
	protected double baseSalary;

		public abstract double calculateBonus();
		
		public void displayDetails()
		{
			System.out.println("Employee ID: " + employeeId);
			System.out.println("Name:" + getName());
			System.out.printf("Base salary: $%2f%n", baseSalary);
		}
			// overloading
			public double calculatePay()
			{
				return baseSalary;
			}
			
			public double calculatePay(double overtimePay)
			{
				return baseSalary + overtimePay;
			}
			public void work()
			{
				System.out.println(getName() + " is working.");
			}
	
}
