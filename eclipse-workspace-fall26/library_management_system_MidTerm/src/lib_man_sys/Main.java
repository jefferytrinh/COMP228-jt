package lib_man_sys;

public class Main 
{
	public static void main(String[] args) // this thing i see all the time and can't remember exactly is for signifying as main
	{
		// creating members
		Member member1 = new Member(1, "Bob", "9416) 111-2222", "M001", 20);
		Member member2 = new Member(2, "John", "(647) 222-3333", "M002", 25);

		// running reg. methods (?)
		member1.registerMember();
		member2.registerMember("Premium"); // will list as premium
		
		System.out.println("\n"); // spacign

		Librarian librarian = new Librarian(3, "Jane,", "(416) 333-4444", "L001", "Circulation", 4000, 20, 100);

		SeniorLibrarian senior = new SeniorLibrarian(4, "Emm", "(647) 444-5555", "SL001", "Archives", 5000, 25, 120, "Research", 1000);

		LibraryAssistant assistant = new LibraryAssistant(5,"Mike", "(416) 555-6666", "A001", "Support", 3000, "Evening", 300);
		
		// pol 
		LibraryStaff[] staff = {librarian, senior, assistant}; // create array

		for(LibraryStaff s : staff) // ":" = for each | saw this in wk6 example
		{
			s.displayStaffDetails();

			System.out.println("Compensation: $" + s.calculateMonthlyCompensation());
			
			System.out.println("\n"); // to make look nicer, space in between
		}
		
		// just test the same idea as LibraryStaff array for Member, simlar logic
		Member[] mem = {member1, member2};

		for(Member m : mem)
		{
			m.displayBasicDetails();
			
			System.out.println("\n");
		}

		// count
		System.out.println("Total people: " + Person.getPersonCount()); // display total people

		System.out.println("Total Staff: " + LibraryStaff.getStaffCount()); // display staff

		// unrelated test calculate late fee
		System.out.println(librarian.calculateLateFee(5, 2.50));
	}

}
