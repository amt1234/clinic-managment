package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import com.bridgeit.utility.Utility;
import com.bridgeit.programs.Appointment;
import com.bridgeit.programs.Doctor;
import com.bridgeit.programs.Patient;

public class AddImpl  {

	private ObjectMapper objectMapper = new ObjectMapper();

	private List<Patient> patientlist = new ArrayList<>();
	private List<Doctor> doctorlist = new ArrayList<>();
	private List<Appointment> appointmentlist = new ArrayList<>();

	/*
	 * add doctors
	 */
	public void addDoctor() throws Exception {

		File file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);

		Doctor doctor = new Doctor();

		System.out.println("Enter Doctor name :");
		doctor.setDoctorname(Utility.inputString());

		System.out.println("Enter Doctor id");
		doctor.setDoctorId(Utility.inputInteger());

		System.out.println("Enter Doctor Specialization");
		doctor.setSpecialization(Utility.inputString());

		System.out.println("Enter Doctor Availiability");
		doctor.setAvailability(Utility.inputString());

		doctorlist.add(doctor);

		System.out.println(doctorlist);
		try {
			objectMapper.writeValue(file, doctorlist);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * add patients
	 */
	public void addPatients() {
		File file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);

		Patient patient = new Patient();

		System.out.println("Enter Petient name :");
		patient.setPatientname(Utility.inputString());

		System.out.println("Enter Petient ID :");
		patient.setPatientId(Utility.inputInteger());

		System.out.println("Enter Patient Mobile Number :");
		patient.setMobileNumber(Utility.inputInteger());

		System.out.println("Enter Patient Age :");
		patient.setAge(Utility.inputInteger());

		patientlist.add(patient);

		System.out.println(patientlist);
		try {
			objectMapper.writeValue(file, patientlist);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * searching doctor switch case
	 */
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

	/*
	 * searching patient switch case
	 */
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

	/**
	 * search by doctor name
	 */
	private void searchDbyName() {
		System.out.println("enter name to search doctor");
		String name = Utility.inputString();

		boolean found = false;

		File file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		System.out.println(doctorlist);

		for (Doctor doctor : doctorlist) {
			if (doctor.getDoctorname().equals(name)) {
				System.out.print("Doctor found.. ");
				System.out.println(doctor);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("doctor not found");
		}

	}

	/**
	 * search by doctor id
	 */
	private void searchDbyId() {
		System.out.println("enter ID to search doctor");
		int id = Utility.inputInteger();

		boolean found = false;

		File file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		System.out.println(doctorlist);

		for (Doctor doctor : doctorlist) {
			if (doctor.getDoctorId() == (id)) {
				System.out.print("Doctor found.. ");
				System.out.println(doctor);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("doctor not found");
		}
	}

	/**
	 * search by doctor specialization
	 */
	private void searchDbySpecialization() {
		System.out.println("enter specialization to search doctor");
		String specializations = Utility.inputString();

		boolean found = false;

		File file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		System.out.println(doctorlist);

		for (Doctor temp : doctorlist) {
			if (temp.getSpecialization().equals(specializations)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("doctor not found");
		}
	}

	/**
	 * search by doctor availability
	 */
	private void searchDbyAvailability() {

		System.out.println("enter availability to search doctor");
		String availablity = Utility.inputString();

		File file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);

		boolean found = false;
		for (Doctor temp : doctorlist) {
			if (temp.getAvailability().equals(availablity)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("doctor not found");
		}
	}

	/**
	 * search by patient name
	 */
	private void searchPbyName() {

		System.out.println("enter name to search patient");
		String name = Utility.inputString();

		File file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);

		boolean found = false;
		for (Patient temp : patientlist) {
			if (temp.getPatientname().equals(name)) {
				System.out.print("Patient found.. ");
				System.out.println(temp);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Patient not found");
		}
	}

	/**
	 * search by patient id
	 */
	private void searchPbyId() {

		System.out.println("enter Id to search patient");
		int id = Utility.inputInteger();

		File file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);

		boolean found = false;
		for (Patient temp : patientlist) {
			if (temp.getPatientId() == (id)) {
				System.out.print("Patient found.. ");
				System.out.println(temp);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Patient not found");
		}
	}

	/**
	 * search by patient age
	 */
	private void searchPbyAge() {
		System.out.println("enter Age to search patient");
		int age = Utility.inputInteger();

		File file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);

		boolean found = false;
		for (Patient temp : patientlist) {
			if (temp.getAge() == (age)) {
				System.out.print("Patient found.. ");
				System.out.println(temp);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Patient not found");
		}
	}

	/*
	 * take appointment
	 */
	public void takeAppointment() throws JsonGenerationException, JsonMappingException, IOException {
		Appointment appointment = new Appointment();

		System.out.println("Enter name of Patient for appointment");
		appointment.setPatientname(Utility.inputString());

		System.out.println("Enter patient id");
		appointment.setPatientid(Utility.inputInteger());

		System.out.println("Enter name of Doctor for appointment");
		appointment.setDoctorname(Utility.inputString());

		System.out.println("Enter id of Doctor for appointment");
		appointment.setDoctorid(Utility.inputInteger());

		System.out.println("Enter date for appointment");
		appointment.setDate(Utility.inputString());

		File doctorFile = new File("Doctor.json");
		doctorlist = fileReader(doctorFile, Doctor.class);

		File appointmentFile = new File("Appointment.json");
		appointmentlist = fileReader(appointmentFile, Appointment.class);

		Iterator<Doctor> iterator = doctorlist.iterator();
		while (iterator.hasNext()) {
			Doctor doctor = iterator.next();

			if ((doctor.getDoctorname().equals(appointment.getDoctorname()))
					&& (doctor.getDoctorId() == (appointment.getDoctorid()))) {
				System.out.print("Doctor found.. ");
				System.out.println(doctor);

				if (doctor.getNopatient() <= 5) {
					System.out.println("Appointment fix..");
					doctor.setNopatient(doctor.getNopatient() + 1);
					System.out.println("hello");
					objectMapper.writeValue(doctorFile, doctorlist);
					appointmentlist.add(appointment);
					break;
				} else {
					System.out.println("Doctor is not available you try for next day..");
					System.out.println("Doctor " + doctor.getDoctorname() + " is a popular in the Clinique . ");
					doctor.setNopatient(0);
					objectMapper.writeValue(doctorFile, doctorlist);
				}
			}
		}

		try {
			objectMapper.writeValue(appointmentFile, appointmentlist);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void displayReport()
	{
		File file = new File("Appointment.json");
		appointmentlist = fileReader(file, Appointment.class);
		System.out.println(appointmentlist);
	}

	/**
	 * @param file
	 * @param clazz
	 * @return file read
	 */
	public <T> List<T> fileReader(File file, Class<T> clazz) {
		List<T> list = null;
		try {
			JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
			list = objectMapper.readValue(file, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}
