package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgeit.utility.Utility;
import com.bridgeit.programs.Doctor;
import com.bridgeit.programs.Patient;

public class AddImpl implements Add {

	Utility utility = new Utility();

	private static ObjectMapper objectMapper = new ObjectMapper();
	private List<Patient> patientlist = new ArrayList<>();
	private List<Doctor> doctorlist = new ArrayList<>();

	File file;
	// List<String> lines = Files.readAllLines(Paths.get(file));
	static String jsonArray;

	@Override
	public void addDoctor() throws Exception {
		Doctor doctor = new Doctor();
		file = new File("Doctor.json");
		
		System.out.println("Enter Doctor name :");
		doctor.setDoctorname(Utility.inputString());
		System.out.println("Enter Doctor id");
		doctor.setDoctor_id(Utility.inputInteger());
		System.out.println("Enter Doctor Specialization");
		doctor.setSpecialization(Utility.inputString());
		System.out.println("Enter Doctor Availiability");
		doctor.setAvailability(Utility.inputString());
		doctorlist.add(doctor);
		// writeFile(file, Doctor[].class);

		try {

			String json = objectMapper.writeValueAsString(doctorlist);
			System.out.println(json);

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Doctor.json"));
			bufferedWriter.write(json);
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addPatients() {
		Patient patient = new Patient();
		file = new File("Patient.json");
		// patientlist = fileReader(file, Patient.class);

		System.out.println("Enter Petient name :");
		patient.setPatientname(Utility.inputString());
		System.out.println("Enter Petient ID :");
		patient.setPatient_id(Utility.inputInteger());
		System.out.println("Enter Patient Mobile Number :");
		patient.setMobileNumber(Utility.inputInteger());
		System.out.println("Enter Patient Age :");
		patient.setAge(Utility.inputInteger());
		patientlist.add(patient);

		try {

			String json = objectMapper.writeValueAsString(patientlist);
			System.out.println(json);

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Patient.json"));
			bufferedWriter.write(json);
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void serchDoctor() {
		System.out.println("Enter choice to search doctor: ");
		System.out.println("1. search by name");
		System.out.println("2. search by id");
		System.out.println("3. search by specialization");
		System.out.println("4. search by availability(am or pm)");
		int choice = Utility.inputInteger();
		switch (choice) {
		case 1:
			searchDbyName();
			break;
		case 2:
			searchDbyId();
			break;
		case 3:
			searchDbySpecialization();
			break;
		case 4:
			searchDbyAvailability();
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	@Override
	public void searchPatient() {
		System.out.println("Enter choice to search Patient: ");
		System.out.println("1. search by name");
		System.out.println("2. search by id");
		System.out.println("3. search by age");
		int choice = Utility.inputInteger();
		switch (choice) {
		case 1:
			searchPbyName();
			break;
		case 2:
			searchPbyId();
			break;
		case 3:
			searchPbyAge();
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}

	private void searchDbyName() {
		System.out.println("enter name to search doctor");
		String name = Utility.inputString();

		file = new File("Doctor.json");
		// doctorlist = fileReader(file, Doctor.class);

		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(name)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}

		/*
		 * Iterator<Doctor> iterator = doctorlist.iterator(); while
		 * (iterator.hasNext()) {
		 * 
		 * Doctor temp = iterator.next(); //
		 * System.out.println(temp.toString()); if
		 * (temp.getDoctorname().equals(name)) {
		 * System.out.print("Doctor found.. "); System.out.println(temp); } else
		 * { System.out.println("Doctor not found.."); } }
		 */
	}

	private void searchDbyId() {

		System.out.println("enter ID to search doctor");
		int id = Utility.inputInteger();
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(id)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	private void searchDbySpecialization() {

		System.out.println("enter specialization to search doctor");
		String specialization = Utility.inputString();
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(specialization)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	private void searchDbyAvailability() {

		System.out.println("enter availability to search doctor");
		String availablity = Utility.inputString();
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(availablity)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	private void searchPbyName() {

		System.out.println("enter name to search patient");
		String name = Utility.inputString();
		for (Patient temp : patientlist) {
			if (temp.getPatientname().equals(name)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	private void searchPbyId() {

		System.out.println("enter Id to search patient");
		int id = Utility.inputInteger();
		for (Patient temp : patientlist) {
			if (temp.getPatient_id() == (id)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	private void searchPbyAge() {

		System.out.println("enter Age to search patient");
		int age = Utility.inputInteger();
		for (Patient temp : patientlist) {
			if (temp.getAge() == (age)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	@Override
	public void takeAppointment() {
		System.out.println("Enter name of Patient for appointment");
		String pname = Utility.inputString();
		System.out.println("Enter name of Doctor for appointment");
		String dname = Utility.inputString();
		Iterator<Doctor> iterator = doctorlist.iterator();
		while (iterator.hasNext()) {
			Doctor temp = iterator.next();
			if (temp.getDoctorname().equals(dname)) {
				System.out.print("Patient found.. ");
				System.out.println(temp);
			}
		}
		System.out.println("Enter date for appointment");

	}

	public void readFileDoctor() {
		BufferedReader bufferedReader;
		try {
			jsonArray = "";
			bufferedReader = new BufferedReader(new FileReader("Doctor.json"));
			while ((jsonArray = bufferedReader.readLine()) != null) {
				TypeReference<List<Doctor>> type = new TypeReference<List<Doctor>>() {
				};
				doctorlist = objectMapper.readValue(jsonArray, type);
			}
			bufferedReader.close();

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFilePatient() {
		BufferedReader bufferedReader;
		try {
			jsonArray = "";
			bufferedReader = new BufferedReader(new FileReader("Patient.json"));
			while ((jsonArray = bufferedReader.readLine()) != null) {
				TypeReference<List<Patient>> type = new TypeReference<List<Patient>>() {
				};
				patientlist = objectMapper.readValue(jsonArray, type);
			}
			bufferedReader.close();

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// public <T> List<T> fileReader(File file, Class<T> clazz) {
// List<T> list = null;
// BufferedReader bufferedReader;
// try {
// jsonArray = "";
// String line="";
// bufferedReader = new BufferedReader(new FileReader(file));
// while ((line = bufferedReader.readLine()) != null) {
// jsonArray = jsonArray+line;
// System.out.println(jsonArray);
//
// TypeReference<List<T>> type = new TypeReference<List<T>>() {
// };
// list = objectMapper.readValue(jsonArray, type);
//
// }
// //list = (List<T>) objectMapper.readValue(jsonArray, clazz);
// bufferedReader.close();
//
// } catch (JsonParseException e) {
// e.printStackTrace();
// } catch (JsonMappingException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
// return list;
// }

// public <T> List<T> writeFile(File file,Class<T> class1) {
// try {
//
// String json = objectMapper.writeValueAsString(list);
// System.out.println(json);
//
// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
// bufferedWriter.write(json);
// bufferedWriter.flush();
// bufferedWriter.close();
//
// } catch (IOException e) {
// e.printStackTrace();
// }
// return list;
// }
