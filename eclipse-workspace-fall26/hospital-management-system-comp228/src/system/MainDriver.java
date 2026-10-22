package system;

public class MainDriver 
{

    public static void main(String[] args) 
    {

        Doctor doctor =
                new Doctor(101, "John", 45, "Cardiology", 150);

        Nurse nurse =
                new Nurse(102, "Mary", 30, "Emergency", "Night");

        Surgeon surgeon =
                new Surgeon(103, "David", 50, "Orthopedic", 250, "Knee Replacement", "OR-1");

        EmergencyDoctor emergencyDoctor =
                new EmergencyDoctor(104, "Sarah", 40, "Emergency Medicine", 200);

        System.out.println("=== DETAILS ==="); // object details

        System.out.println(doctor);
        System.out.println(nurse);
        System.out.println(surgeon);
        System.out.println(emergencyDoctor);

        System.out.println("\n=== TASKS ==="); // specialized methods

        doctor.diagnosePatient();
        nurse.assistPatient();
        surgeon.performSurgery();
        emergencyDoctor.handleEmergency();

        System.out.println("\n=== DUTIES ==="); // method overriding

        doctor.performDuties();
        nurse.performDuties();
        surgeon.performDuties();
        emergencyDoctor.performDuties();

        System.out.println("\n=== DUTIES ==="); // polymorphism

        Person person;

        person = doctor;
        person.performDuties();

        person = nurse;
        person.performDuties();

        person = surgeon;
        person.performDuties();

        person = emergencyDoctor;
        person.performDuties();

        System.out.println("\n=== INTERFACE ==="); // interface methods

        emergencyDoctor.prescribeMedication();
        emergencyDoctor.generateBill();
    }
}