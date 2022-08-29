package com.investmentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;

@Service
public class InvestmentServiceImpl implements IInvestmentService{
	
	private IInvestmentRepository investmentRepository;
	
	@Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}

	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.save(investment);
		
	}

	@Override
	public void updateInvestment(Investment investment) {
		investmentRepository.save(investment);
	}

	@Override
	public void deleteInvestment(int planId) {
		investmentRepository.deleteById(planId);
		
	}

	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		List<Investment> investments =  investmentRepository.findByRiskAndTerm(risk, term);
		if(investments.isEmpty())
			throw new PlanNotFoundException("Plan with this term not found");
		return investments;
	}

	@Override
	public List<Investment> getByType(String type) {
		List<Investment> investments =  investmentRepository.findByType(type);
		if(investments.isEmpty())
			throw new PlanNotFoundException("Plan with this type not found");
		return investments;
	}

	@Override
	public List<Investment> getByPurpose(String purpose) {
		List<Investment> investments =  investmentRepository.findByPurpose(purpose);
		if(investments.isEmpty())
			throw new PlanNotFoundException("Plan with this purpose not found");
		return investments;
	}

	@Override
	public List<Investment> getAll() {
		return investmentRepository.findAll();
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getById(int planId) throws PlanNotFoundException {
//		Optional<Investment> investOpt = investmentRepository.findById(planId);
//		if(investOpt.isEmpty())
//			throw new PlanNotFoundException("");
//		return investOpt.get();
		
//		return investmentRepository.findById(planId).orElseThrow(()->{
//			throw new PlanNotFoundException("Invalid Id");
//			
//		});
		
		return investmentRepository
				.findById(planId)
				.orElseThrow(()->new PlanNotFoundException("Invalid Id"));
	}

	@Override
	@Transactional
	public void updateInvestment(int planId, double amount) {	
      	investmentRepository.updateInvestment(planId, amount);
	}

	
}
