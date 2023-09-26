package com.boot.vamsi.repository;


import org.springframework.stereotype.Repository;

import com.boot.vamsi.DAO.InsuranceDAO;
import com.boot.vamsi.model.InsurancePolicy;
import com.boot.vamsi.model.InsurancePolicySchedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;




@Repository
public class InsuranceRepository {
	@Autowired
    private InsuranceDAO insuranceDAO;

    public List<InsurancePolicy> ListAllPolicy() {
		List<InsurancePolicy> pack = insuranceDAO.getAllPolicies();
		return pack;
	}
    
    public List<InsurancePolicySchedule> ListAllPolicySchedules() {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllSchedule();
		return s;
	}

	public int createNewPolicy(InsurancePolicy u) {
		return  insuranceDAO.addPolicy(u);
	}
	
	public int updateNewPolicy(InsurancePolicy u) {
        return insuranceDAO.updateStatus(u);
    }

	
	public InsurancePolicy getPolicyeById(int id) {
		return insuranceDAO.getPolicyById(id);
	}

	
	 public int ListNonStatusPayments(int id) {
	 return insuranceDAO.getNonPaymentStatus(id);
	 }

	public List<Integer> findDistinctIds() {
		return insuranceDAO.findDistinctIplcIds();
	}

	
}

