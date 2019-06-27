package com.bank.loan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.loan.Exception.ApplicatIonException;
import com.bank.loan.Service.LoanDetailsService;
import com.bank.loan.entity.LoanDetails;

import net.bytebuddy.asm.Advice.AllArguments;

@RestController
public class LoanController {

	@Autowired
	LoanDetailsService loanService;

	@PostMapping("/createLoan")
	public Object createLoan(@RequestBody LoanDetails loanDetails) {
		if (loanService.createLoan(loanDetails) != null) {

			return "Loan Details Created Successfully. ";
		} else

		 throw new ApplicatIonException("Something went wrong.please try again....");
	}

	@GetMapping("/approveLoan/{id}/{status}")
	public String approveLoan(@PathVariable("status") String status, @PathVariable("id") Integer id) {
		System.out.println("loan controller");
		LoanDetails loanDetails = loanService.fetchById(id, status);
		System.out.println("fm controller "+loanDetails);
		if (loanDetails.getLoanStatus().equalsIgnoreCase("approved")) {
			return "loan approved";
		} else {
			return "loan rejected";
		}
	}
	
	
	  @GetMapping("/getApproved/{status}") 
	  public List<LoanDetails> getList(@PathVariable String status ){
		  return loanService.findAll(status);
	  }
	 
	
}
