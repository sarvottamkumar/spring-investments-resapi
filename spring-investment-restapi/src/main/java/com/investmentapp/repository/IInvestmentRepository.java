package com.investmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;

@Repository
public interface IInvestmentRepository extends JpaRepository<Investment, Integer>{

	List<Investment> findByRiskAndTerm(String risk, int term );
	List<Investment> findByType(String type);
	List<Investment> findByPurpose(String type);
	
	@Modifying
	@Query(value =  "update investment set amount=?2 where plan_id=?1",nativeQuery=true)
	void updateInvestment(int planId,double amount);
	
}
