package com.bridgeit.programs;

public class Appointment {

	private String date;
	private String patientname;
	private int patientid;
	private String doctorname;
	private int doctorid;

	
	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [date=" + date + ", patientname=" + patientname + ", patientid=" + patientid
				+ ", doctorname=" + doctorname + ", doctorid=" + doctorid + "]";
	}

}
