package system;

public class Doctor extends Person {
	protected String specialization;
	protected double consultationFee;

	public Doctor(int personId, String name, int age,
			String specialization, double consultationFee) {

		super(personId, name, age);

		this.specialization = specialization;
		this.consultationFee = consultationFee;
	}

	public void diagnosePatient() {
		System.out.println(name + " is diagnosing a patient.");
	}

	@Override
	public void performDuties() {
		System.out.println(name + " is treating patients.");
	}

	@Override
	public String toString() {
		return super.toString() + ", Specialization: " + specialization + ", Fee: $" + consultationFee;
	}
}