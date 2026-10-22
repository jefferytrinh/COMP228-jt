package wk6.project;

public class Main
{
    public static void main(String[] args)
    {
        UtilityDemo.printHeading("Employee Management Demo");

        FullTimeEmployee emp1 =
                new FullTimeEmployee("John", 101, 60000);

        PartTimeEmployee emp2 =
                new PartTimeEmployee("Sarah", 102, 25000);

        Manager mgr =
                new Manager("David", 103, 85000, "IT");

        Contractor contractor =
                new Contractor("Mike", 5000);

        Employee[] employees = {emp1, emp2, mgr};

        for(Employee e : employees) // ":" means "for each". essentially "for each Employee e in the employees array"
        {
            e.displayDetails();

            System.out.printf(
                    "Bonus: $%.2f%n",
                    e.calculateBonus());

            System.out.printf(
                    "Regular Pay: $%.2f%n",
                    e.calculatePay());

            System.out.printf(
                    "Pay with Overtime: $%.2f%n",
                    e.calculatePay(1000));

            e.work();

            System.out.println();
        }

        System.out.println("Contractor Payment: $" +
                contractor.getPaymentAmount());

        contractor.introduce();

        System.out.println();

        mgr.approveLeave();
        mgr.conductMeeting();

        System.out.println();

        NewHireOrientation orientation =
                new NewHireOrientation();

        orientation.startOrientation();
        orientation.showCompanyPolicy();
    }
}