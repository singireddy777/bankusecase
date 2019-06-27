package com.bank.loan.controllerTest;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bank.loan.Controller.LoanController;
import com.bank.loan.Service.LoanDetailsService;
import com.bank.loan.entity.LoanDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private LoanDetailsService loanSerive;

	@MockBean
	private LoanController loanController;
	@Autowired 
	private WebApplicationContext context;
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	  @Test 
	  public void createLoanTest() throws Exception {
	  
	  //Officer officer = new Officer(10); 
		  //Customer customer = new Customer(10);
	  
	  //Positive case 
		  LoanDetails loan = new LoanDetails(1,222L,"house",610.69,"approved",300.00); 
		/*
		 * loan.setId(1); loan.setLoanAccNum(222); loan.setLoanAmount(250);
		 * loan.setLoanStatus("approved"); loan.setSecurityAddr("house");
		 * loan.setSecurityValue(610);
		 */
		  
		  ObjectMapper om = new ObjectMapper(); 
		  String expected = om.writeValueAsString(loan);
	  Mockito.when(loanSerive.createLoan(loan)).
	  thenReturn(loan);
	  
	  mvc.perform(MockMvcRequestBuilders.post("/createLoan")
	  .contentType(MediaType.APPLICATION_JSON) .content(expected))
	  .andExpect(status().isOk()) .andDo(print());
	  
	  //Negative case 
	  loan = null;
	  ObjectMapper omForNegative = new ObjectMapper();
	  String expectedForNegative = omForNegative.writeValueAsString(loan);
	  
	  Mockito.when(loanSerive.createLoan(loan)).
	  thenReturn(loan);
	  mvc.perform(MockMvcRequestBuilders.post("/createLoan")
	  .contentType(MediaType.APPLICATION_JSON) .content(expectedForNegative))
	  .andExpect(status().isBadRequest()) 
	  .andDo(print());
	  
	  }
	 


}
