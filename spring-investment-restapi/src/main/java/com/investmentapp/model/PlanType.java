package com.investmentapp.model;

public enum PlanType {
    
	mutual("Mutual Fund"),
	ppf("Public Provident Fund"),
	ulip("Unit Limited Investment Plan"),
	senior("Senior Pension Scheme"),
	fd("Fixed Deposit");
	
	public String type;
	
	private PlanType(String planType) {
		this.type = planType;
	}

	
	
}
