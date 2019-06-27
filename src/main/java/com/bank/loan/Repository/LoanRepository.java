package com.bank.loan.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.loan.entity.LoanDetails;

@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Integer> {
	
 public LoanDetails findById(int id);
 
 @Query(value="select * from bankloan.loan_details where loan_status=?1", nativeQuery = true)
 public List<LoanDetails> findByStatus(String status);
}
