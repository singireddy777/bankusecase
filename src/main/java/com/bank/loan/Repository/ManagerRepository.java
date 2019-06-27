package com.bank.loan.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.loan.entity.ManagerDetails;
@Repository
public interface ManagerRepository extends JpaRepository<ManagerDetails, Integer>{

	
}
