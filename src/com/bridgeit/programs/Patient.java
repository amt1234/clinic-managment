package com.bridgeit.programs;

public class Patient {
	private String patientname;
	private int patientId;
	private int mobileNumber;
	private int age;

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patient_id) {
		this.patientId = patient_id;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [patientname=" + patientname + ", patient_id=" + patientId + ", mobileNumber=" + mobileNumber
				+ ", age=" + age + "]";
	}

}