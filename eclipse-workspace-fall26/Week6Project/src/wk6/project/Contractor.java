package wk6.project;

public class Contractor extends Person implements Payable
{
	private final double contractAmount;
	public Contractor(String name, double contractAmount)
	{
		super(name);
		this.contractAmount = contractAmount;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return contractAmount;
	}
	
	@Override
	public void introduce()
	{
		super.introduce();
		System.out.println("I work as an independent contractor.");
	}
}
