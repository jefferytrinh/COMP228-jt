package lib_man_sys;

public class LibraryAssistant extends LibraryStaff
{
    private String shiftType;
    private double shiftAllowance;

    public LibraryAssistant(int personId, String name, String phoneNumber, String staffId, String department, double salary, String shiftType, double shiftAllowance)
    {
        super(personId, name, phoneNumber, staffId, department, salary);

        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
    }

    // override methods (?) for following
    @Override
    public double calculateMonthlyCompensation()
    {
        return monthlySalary + shiftAllowance;
    }

    @Override
    public String getRoleDescription()
    {
        return "Library Assistant";
    }

    @Override
    public void displayStaffDetails()
    {
        super.displayStaffDetails();

        System.out.println(
                "Shift: " + shiftType);
    }
}