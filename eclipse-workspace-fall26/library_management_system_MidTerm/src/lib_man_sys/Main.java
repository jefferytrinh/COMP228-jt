package lib_man_sys;

public class Main 
{
	public static void main(String[] args) // this thing i see all the time and can't remember exactly is for signifying as main
	{
		// creating members
		Member member1 = new Member(1, "Bob", "111-2222", "M001", 20);
		Member member2 = new Member(1, "John", "222-3333", "M002", 25);
		
		// running reg. methods (?)
		member1.registerMember();
		member2.registerMember("Premium"); // will list as premium
		
		Librarian librarian = new Librarian(3, "Jane,", "333-4444", "L001", "Circulation", 4000, 20, 100);
		
		SeniorLibrarian senior = new SeniorLibrarian(4, "Emm", "444-5555", "SL001", "Archives", 5000, 25, 120, "Research", 1000);
		
		 LibraryAssistant assistant = new LibraryAssistant(5,"Mike", "555-6666", "A001", "Support", 3000, "Evening", 300);
		 
		 // pol 
		 LibraryStaff[] staff =
			 {
			     librarian, senior, assistant
			 };
		 for(LibraryStaff s : staff)
		 {
			 s.displayStaffDetails();
			 
			 System.out.println("Compensation: $" + s.calculateMonthlyCompensation());
		 }
		 
		 // count
		 System.out.println("Total people: " + Person.getPersonCount());
		 
		 System.out.println("Total Staff: " + LibraryStaff.getStaffCount());
			 
	}

}
