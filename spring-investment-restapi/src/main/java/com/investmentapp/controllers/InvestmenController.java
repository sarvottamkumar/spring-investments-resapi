package com.investmentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;

@RestController
public class InvestmenController {
	
	
IInvestmentService investmentService;
	
	@Autowired
	public void setInvestmentService(IInvestmentService investmentService) {
		this.investmentService = investmentService;
	}

	@PostMapping("/investments")
	public ResponseEntity<Void> addInvestment(@RequestBody Investment investment) {
		investmentService.addInvestment(investment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "add one investment");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}
	
	@PutMapping("/investments")
	public ResponseEntity<String> updateInvestment(@RequestBody Investment investment) {
		investmentService.updateInvestment(investment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "update one investment");
		return ResponseEntity.accepted().headers(headers).body("Updated");
	}
	
	@DeleteMapping("/investments/{planId}")
	public ResponseEntity<Void> deleteInvestment(@PathVariable("planId")  int planId) {
		investmentService.deleteInvestment(planId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "delete one investment");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		
	}
	@GetMapping("/investments/risk/{risk}/term/{term}")
	public ResponseEntity<List<Investment>> getByRiskAndTerm
			(@PathVariable("risk") String risk, @PathVariable("term") int mterm ) {
		
		List<Investment> investments = investmentService.getByRiskAndTerm(risk, mterm);
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("desc", "All investment");
		headers.add("info", "investments Rest api by risk and term");
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
	}
	
	@GetMapping("/investments/type/{type}")
	public ResponseEntity<List<Investment>> getByType(@PathVariable("type") String type){
		
		List<Investment> investments = investmentService.getByType(type);
		return ResponseEntity.ok().body(investments);
	}
	
	@GetMapping("/investments/purpose/{purpose}")
	public ResponseEntity<List<Investment>> getByPurpose(@PathVariable("purpose")String purpose){
		
		List<Investment> investments = investmentService.getByPurpose(purpose);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All investments purpose");
		headers.add("info", "investments Rest api by purpose");
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
	}
//	http://localhost:8080/investments
	@GetMapping("/investments")
	public ResponseEntity<List<Investment>> getAll(){
		List<Investment> investments = investmentService.getAll();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("desc", "All investment");
		headers.add("info", "Getting investments from db");
		
		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<>(investments,headers,HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/investments/planId/{id}")
	public ResponseEntity<Investment> getById(@PathVariable("id") int planId) {
		Investment investment = investmentService.getById(planId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one investment by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investment);
	}
	
	@GetMapping("/investments/planId/{id}/amount/{amount}")
	public ResponseEntity<Investment> updateInvestment(@PathVariable("id") int planId,@PathVariable("amount") double amount) {
	
		investmentService.updateInvestment(planId, amount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	

}
