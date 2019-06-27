package com.bank.loan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.loan.Exception.ApplicatIonException;
import com.bank.loan.Repository.LoanRepository;
import com.bank.loan.entity.LoanDetails;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	LoanRepository loanRepository;

	@Override
	public LoanDetails createLoan(LoanDetails loanDetails) throws ApplicatIonException {

		if (loanDetails.getLoanAccNum() < 0 && loanDetails.getLoanStatus() == "Rejected") {
			throw new ApplicatIonException("you are not qualified Customer");
		} else {
			loanDetails = loanRepository.save(loanDetails);
		}
		return loanDetails;

	}

	@Override
	public LoanDetails fetchById(int id, String status) {
		System.out.println("loan service");
		LoanDetails loanDetails = loanRepository.findById(id);
		System.out.println("first  " + loanDetails);
		if (loanDetails.getLoanAmount() <= loanDetails.getSecurityValue()) {
			if (loanDetails.getCustomerDetails().getCustCreditScore() > 600) {
				if (loanDetails.getCustomerDetails().getCustAge() >= 24
						&& loanDetails.getCustomerDetails().getCustAge() <= 60) {
					/*
					 * if ((loanDetails.getCustomerDetails().getCustAge() > 24 &&
					 * loanDetails.getCustomerDetails().getCustAge() < 29) &&
					 * loanDetails.getCustomerDetails().getCustMStatus().equalsIgnoreCase(
					 * "unmarried")) { loanDetails.setLoanStatus(status);
					 * loanRepository.save(loanDetails); } else {
					 * loanDetails.setLoanStatus("rejected"); }
					 */
					loanDetails.setLoanStatus(status);
					 loanRepository.save(loanDetails);
				} else {
					loanDetails.setLoanStatus("rejected");
				}
			} else {
				loanDetails.setLoanStatus("rejected");
			}
		} else {
			loanDetails.setLoanStatus("rejected");
		}
		System.out.println("second  " + loanDetails);
		return loanDetails;

	}

	@Override
	public List<LoanDetails> findAll(String status) {
		return loanRepository.findByStatus(status);
	}

}