package system;

public class Person {
	protected int personId;
	protected String name;
	protected int age;

	public Person(int personId, String name, int age) 
	{
		this.personId = personId;
		this.name = name;
		this.age = age;
	}

	public void performDuties() 
	{
		System.out.println(name + " is performing hospital duties.");
	}

	@Override
	public String toString() 
	{
		return "ID: " + personId + ", Name: " + name + ", Age: " + age;
	}
}