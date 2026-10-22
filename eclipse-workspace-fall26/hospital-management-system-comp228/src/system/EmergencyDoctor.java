package system;

public class EmergencyDoctor extends Doctor
implements MedicalProfessional, Billable 
{

	public EmergencyDoctor(int personId, String name, int age, String specialization, double consultationFee) 
	{

		super(personId, name, age, specialization, consultationFee);
	}

	public void handleEmergency() 
	{
		System.out.println(name + " is handling an emergency.");
	}

	@Override
	public void prescribeMedication() 
	{
		System.out.println(name + " prescribed medication.");
	}

	@Override
	public void generateBill()
	{
		System.out.println("Bill generated for patient.");
	}

	@Override
	public void performDuties() 
	{
		System.out.println(name + " is managing emergency cases.");
	}
}