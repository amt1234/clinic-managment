/*Clinic management*/
package com.bridgeit.programs;

import com.bridgeit.utility.Utility;
import controller.AddImpl;

public class CliniqueMain {

	public static void main(String[] args) throws Exception {
		AddImpl addImpl = new AddImpl();
		int ch = 0;
		do {
			System.out.println("----------------Cliniqe Management------------- ");
			System.out.println("    1. Add new Doctor");
			System.out.println("    2. Add new Patient");
			System.out.println("    3. Search Doctor");
			System.out.println("    4. Search Patient");
			System.out.println("    5.Take an Appointment");
			System.out.println("    6.Display report");
			System.out.println("    7.Exit");

			int choice = Utility.inputInteger();
			switch (choice) {
			case 1:
				addImpl.addDoctor();
				break;
			case 2:
				addImpl.addPatients();
				break;
			case 3:
				addImpl.serchDoctor();
				break;
			case 4:
				addImpl.searchPatient();
				break;
			case 5:
				addImpl.takeAppointment();
				break;
			case 6:
				addImpl.displayReport();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid choice ");
				break;
			}
		} while (ch != 8);

	}

}
