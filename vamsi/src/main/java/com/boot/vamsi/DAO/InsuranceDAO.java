package com.boot.vamsi.DAO;


import java.util.List;

import com.boot.vamsi.model.InsurancePolicy;
import com.boot.vamsi.model.InsurancePolicySchedule;




public interface InsuranceDAO {
	List<InsurancePolicySchedule> getAllSchedule();
	
	int getNonPaymentStatus(int id);
	
	List<Integer> findDistinctIplcIds();
	
	List<InsurancePolicy> getAllPolicies();


	int addPolicy(InsurancePolicy e);
	
	int updateStatus(InsurancePolicy e);
	
	InsurancePolicy getPolicyById(int id);

	
}

