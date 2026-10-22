package lib_man_sys;

public class Member extends Person
{
	// per req. of doc fields of 2. Member
	private final String memberNumber; // private means only this class can access?
	int age;
	private String membershipType;
	private double outstandingFees;

	public Member(int personId, String name, String phoneNumber, String memberNumber, int age) // when adding Member will correspond
	{
		super(personId, name, phoneNumber); // ref to im. parent class obj

		if(age < 0)
			throw new IllegalArgumentException("Invalid age");

		this.memberNumber = memberNumber;
		this.age = age;
	}

	public void registerMember() // per req.
	{
		membershipType = "Regular";
		System.out.println(name + " registered.");
	}

	public void registerMember(String membershipType) // for have membership type
	{
		this.membershipType = membershipType;
		System.out.println(name + " registered as " + membershipType);
	}

	@Override
	public String getRoleDescription()
	{
		return "Library Member";
	}
}