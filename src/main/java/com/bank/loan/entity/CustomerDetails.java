package com.bank.loan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int custID;
	private String custName;
	private long custMobile;
	private int custAge;
	private String custGender;
	private String custMStatus;
	private int custCreditScore;
	
	
	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CustomerDetails( String custName, long custMobile, int custAge, String custGender,
			String custMStatus, int custCreditScore) {
		
		this.custName = custName;
		this.custMobile = custMobile;
		this.custAge = custAge;
		this.custGender = custGender;
		this.custMStatus = custMStatus;
		this.custCreditScore = custCreditScore;
	}


	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public String getCustGender() {
		return custGender;
	}
	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}
	public String getCustMStatus() {
		return custMStatus;
	}
	public void setCustMStatus(String custMStatus) {
		this.custMStatus = custMStatus;
	}
	public int getCustCreditScore() {
		return custCreditScore;
	}
	public void setCustCreditScore(int custCreditScore) {
		this.custCreditScore = custCreditScore;
	}

	@Override
	public String toString() {
		return "CustomerDetails [custID=" + custID + ", custName=" + custName + ", custMobile=" + custMobile
				+ ", custAge=" + custAge + ", custGender=" + custGender + ", custMStatus=" + custMStatus
				+ ", custCreditScore=" + custCreditScore + "]";
	}
	
	
	
}
