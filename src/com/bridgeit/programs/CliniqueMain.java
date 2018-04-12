package com.bridgeit.programs;

import com.bridgeit.utility.Utility;
import controller.Add;
import controller.AddImpl;

public class CliniqueMain {

	public static void main(String[] args) throws Exception {
		Add add = new AddImpl();
		add.readFileDoctor();
		add.readFilePatient();
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
				add.addDoctor();
				break;
			case 2:
				add.addPatients();
				break;
			case 3:
				add.serchDoctor();
				break;
			case 4:
				add.searchPatient();
				break;
			case 5:
				add.takeAppointment();
				break;
			case 6:
				System.out.println("display report");
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid choice ");
			}
		} while (ch != 8);

	}

}
