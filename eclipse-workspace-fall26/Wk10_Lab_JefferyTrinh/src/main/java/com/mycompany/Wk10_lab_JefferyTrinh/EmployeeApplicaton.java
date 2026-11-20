package com.mycompany.Wk10_lab_JefferyTrinh;
import java.time.LocalDate;

public class EmployeeApplicaton {
    public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateAvailable() {
		return dateAvailable;
	}
	public void setDateAvailable(LocalDate dateAvailable) {
		this.dateAvailable = dateAvailable;
	}
	public String getDesiredPosition() {
		return desiredPosition;
	}
	public void setDesiredPosition(String desiredPosition) {
		this.desiredPosition = desiredPosition;
	}
	public String getDesiredSalary() {
		return desiredSalary;
	}
	public void setDesiredSalary(String desiredSalary) {
		this.desiredSalary = desiredSalary;
	}
	public String getAuthorizedToWork() {
		return authorizedToWork;
	}
	public void setAuthorizedToWork(String authorizedToWork) {
		this.authorizedToWork = authorizedToWork;
	}
	public String getRelativesWorking() {
		return relativesWorking;
	}
	public void setRelativesWorking(String relativesWorking) {
		this.relativesWorking = relativesWorking;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	private String fullName;
    private String currentAddress;
    private String contactNumber;
    private String emailAddress;
    private String education;
    private String gender;
    private LocalDate dateAvailable;
    private String desiredPosition;
    private String desiredSalary;
    private String authorizedToWork;
    private String relativesWorking;
    private String explanation;
    private String signature;
}
