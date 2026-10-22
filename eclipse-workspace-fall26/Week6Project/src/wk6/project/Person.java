package wk6.project;

public class Person 
{
	private final String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void introduce()
	{
		System.out.printf("Hello, my name is " + name + ".");
	}
}
