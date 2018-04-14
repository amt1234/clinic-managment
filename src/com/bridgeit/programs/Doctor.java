package com.bridgeit.programs;

public class Doctor {
	private int doctorId;
	private String doctorname;
	private String specialization;
	private String availability;
	private int nopatient;

	public int getNopatient() {
		return nopatient;
	}

	public void setNopatient(int nopatient) {
		this.nopatient = nopatient;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorname=" + doctorname + ", specialization=" + specialization
				+ ", availability=" + availability + ", nopatient=" + nopatient + "]";
	}
}
