package com.bank.loan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Loan_Details")
public class LoanDetails {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private int id;
	private long loanAccNum;
	private String securityAddr;
	private double securityValue;
	private String loanStatus;
	private double loanAmount;
	
	@ManyToOne
	CustomerDetails customerDetails;
	
	@OneToOne
	ManagerDetails managerDetails;
	public LoanDetails(int id, long loanAccNum, String securityAddr, double securityValue, String loanStatus,
			double loanAmount) {
		super();
		this.id = id;
		this.loanAccNum = loanAccNum;
		this.securityAddr = securityAddr;
		this.securityValue = securityValue;
		this.loanStatus = loanStatus;
		this.loanAmount = loanAmount;
		
	}

	public double getSecurityValue() {
		return securityValue;
	}

	public void setSecurityValue(double securityValue) {
		this.securityValue = securityValue;
	}

	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getLoanAccNum() {
		return loanAccNum;
	}

	public void setLoanAccNum(long loanAccNum) {
		this.loanAccNum = loanAccNum;
	}

	public String getSecurityAddr() {
		return securityAddr;
	}

	public void setSecurityAddr(String securityAddr) {
		this.securityAddr = securityAddr;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	
	  public CustomerDetails getCustomerDetails() { 
		  
		  return customerDetails; }
	  
	  public void setCustomerDetails(CustomerDetails customerDetails) {
	  this.customerDetails = customerDetails; }
	 

	public ManagerDetails getManagerDetails() {
		return managerDetails;
	}

	public void setManagerDetails(ManagerDetails managerDetails) {
		this.managerDetails = managerDetails;
	}

	@Override
	public String toString() {
		return "LoanDetails [id=" + id + ", loanAccNum=" + loanAccNum + ", securityAddr=" + securityAddr
				+ ", loanStatus=" + loanStatus + ", loanAmount=" + loanAmount + ", managerDetails=" + managerDetails
				+ "]";
	}
	
	
}
