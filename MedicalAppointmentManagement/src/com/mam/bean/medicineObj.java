package com.mam.bean;

public class medicineObj {

	private String medicineID = "null";
	private String medicineName = "null";
	private String medicineDesc = "null";
	private String patientID = "null";
	private String appointmentID = "null";
	private String remark = "null";
	private int quantity = 0;

	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineDesc() {
		return medicineDesc;
	}

	public void setMedicineDesc(String medicineDesc) {
		this.medicineDesc = medicineDesc;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
