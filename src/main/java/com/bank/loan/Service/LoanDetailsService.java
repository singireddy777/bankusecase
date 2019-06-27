package com.bank.loan.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.loan.entity.LoanDetails;
@Service
public interface LoanDetailsService {
	public LoanDetails createLoan(LoanDetails loanDetails);

	public LoanDetails fetchById(int id, String status);

	public List<LoanDetails> findAll(String status);
}
