package lib_man_sys;

public abstract class Person
{
	// doc shows below is req. in fields of 1. Person
	final int personId;
	String name;
	String phoneNumber;
	static int personCount = 0; // to fill
	
	public Person(int personId, String name, String phoneNumber) // for this thing to initialize these probably
	{
		this.personId = personId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		personCount++; // adds to personCount
	}
	
	public static int getPersonCount() // method
	{
		return personCount;
	}
	
	public void displayBasicDetails() // week6 example has void in this scenario so probably should be that
	{
		System.out.println("ID: " + personId);
		System.out.println("Name: " + name);
		System.out.println("Phone: " + phoneNumber);
	}
	
	public abstract String getRoleDescription(); // says to add this in doc
	
	@Override
	public String toString()
	{
		return personId + " - " + name;
	}
	
}