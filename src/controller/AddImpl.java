package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import com.bridgeit.utility.Utility;
import com.bridgeit.programs.Appointment;
import com.bridgeit.programs.Doctor;
import com.bridgeit.programs.Patient;

public class AddImpl implements Add {

	Utility utility = new Utility();

	private static ObjectMapper objectMapper = new ObjectMapper();
	private List<Patient> patientlist = new ArrayList<>();
	private List<Doctor> doctorlist = new ArrayList<>();
	private List<Appointment> appointmentlist = new ArrayList<>();
	static int count = 0;
	static String jsonArray;
	File file;

	/*
	 * @see controller.Add#addDoctor() add doctors
	 */
	@Override
	public void addDoctor() throws Exception {
		Doctor doctor = new Doctor();
		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		System.out.println("Enter Doctor name :");
		doctor.setDoctorname(Utility.inputString());
		System.out.println("Enter Doctor id");
		doctor.setDoctor_id(Utility.inputInteger());
		System.out.println("Enter Doctor Specialization");
		doctor.setSpecialization(Utility.inputString());
		System.out.println("Enter Doctor Availiability");
		doctor.setAvailability(Utility.inputString());
		doctorlist.add(doctor);

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

	/*
	 * @see controller.Add#addPatients() add patients
	 */
	@Override
	public void addPatients() {
		Patient patient = new Patient();
		file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);

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

	/*
	 * @see controller.Add#serchDoctor() searching doctor switch case
	 */
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

	/*
	 * @see controller.Add#searchPatient() searching patient switch case
	 */
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

	/**
	 * search by doctor name
	 */
	private void searchDbyName() {
		System.out.println("enter name to search doctor");
		String name = Utility.inputString();

		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);

		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(name)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}

	}

	/**
	 * search by doctor id
	 */
	private void searchDbyId() {

		System.out.println("enter ID to search doctor");
		int id = Utility.inputInteger();
		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(id)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/**
	 * search by doctor specialization
	 */
	private void searchDbySpecialization() {

		System.out.println("enter specialization to search doctor");
		String specialization = Utility.inputString();
		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(specialization)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/**
	 * search by doctor availability
	 */
	private void searchDbyAvailability() {

		System.out.println("enter availability to search doctor");
		String availablity = Utility.inputString();
		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		for (Doctor temp : doctorlist) {
			if (temp.getDoctorname().equals(availablity)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/**
	 * search by patient name
	 */
	private void searchPbyName() {

		System.out.println("enter name to search patient");
		String name = Utility.inputString();
		file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);
		for (Patient temp : patientlist) {
			if (temp.getPatientname().equals(name)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/**
	 * search by patient id
	 */
	private void searchPbyId() {

		System.out.println("enter Id to search patient");
		int id = Utility.inputInteger();
		file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);
		for (Patient temp : patientlist) {
			if (temp.getPatient_id() == (id)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/**
	 * search by patient age
	 */
	private void searchPbyAge() {

		System.out.println("enter Age to search patient");
		int age = Utility.inputInteger();
		file = new File("Patient.json");
		patientlist = fileReader(file, Patient.class);
		for (Patient temp : patientlist) {
			if (temp.getAge() == (age)) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
			} else {
				System.out.println("Doctor not found..");
			}
		}
	}

	/*
	 * @see controller.Add#takeAppointment() take appointment
	 */
	@Override
	public void takeAppointment() {
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
		file = new File("Doctor.json");
		doctorlist = fileReader(file, Doctor.class);
		Iterator<Doctor> iterator = doctorlist.iterator();
		while (iterator.hasNext()) {
			Doctor temp = iterator.next();
			if ((temp.getDoctorname().equals(appointment.getDoctorname()))
					&& (temp.getDoctor_id() == (appointment.getDoctorid()))) {
				System.out.print("Doctor found.. ");
				System.out.println(temp);
				if (count == 0) {
					System.out.println("appointment fix");
					count++;
				} else if (count < 5) {
					System.out.println("appointment fix");
					count++;
				} else {
					System.out.println("Doctor is not available you try for next day..");
				}
			}
		}

		appointmentlist.add(appointment);

		try {

			String json = objectMapper.writeValueAsString(appointmentlist);
			System.out.println(json);

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Appointment.json"));
			bufferedWriter.write(json);
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param file
	 * @param clazz
	 * @return file read
	 */
	public <T> List<T> fileReader(File file, Class<T> clazz) {
		List<T> list = null;
		BufferedReader bufferedReader;
		try {
			jsonArray = "";
			bufferedReader = new BufferedReader(new FileReader(file));
			while ((jsonArray = bufferedReader.readLine()) != null) {
				System.out.println(jsonArray);

				JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);

				list = objectMapper.readValue(jsonArray, javaType);

			}
			bufferedReader.close();

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
