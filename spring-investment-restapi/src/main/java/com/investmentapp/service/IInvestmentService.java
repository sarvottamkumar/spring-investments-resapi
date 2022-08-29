package com.investmentapp.service;

import java.util.List;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;

public interface IInvestmentService {

	void addInvestment(Investment investment);
	void updateInvestment(Investment investment);
	void deleteInvestment(int planId);
	
	List<Investment> getByRiskAndTerm(String risk, int term ) throws PlanNotFoundException;
	List<Investment> getByType(String type)throws PlanNotFoundException;
	List<Investment> getByPurpose(String purpose)throws PlanNotFoundException;
	List<Investment> getAll();
	
	double calculateMaturity(Investment investment);
	Investment getById(int planId)throws PlanNotFoundException;
	
	void updateInvestment(int planId,double amount);
	
}
