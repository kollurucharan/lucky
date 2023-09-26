package com.boot.vamsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.vamsi.model.InsurancePolicy;
import com.boot.vamsi.repository.InsuranceRepository;



@Controller
public class InsuranceController {
	@Autowired
	private InsuranceRepository insu;

	// to view pages
	@GetMapping("/link")
	public String getAllLinks() {
		return "Links";
	}

	// to view policy
	@GetMapping("/getpolicy")
	public String getAllPolicy(Model m) {
		List<InsurancePolicy> p = insu.ListAllPolicy();
		m.addAttribute("policies", p);
		return "ViewPolicy";
	}

	// to go to create form
	@GetMapping("/insertPolicyForm")
	public String showInsertPolicyForm(Model model) {
		model.addAttribute("policy", new InsurancePolicy());
		return "CreatePolicy";
	}

	// to create a policy at insurance side
	@PostMapping("/insertPolicy")
	public String insertPolicy(@ModelAttribute("policy") InsurancePolicy policy) {

		insu.createNewPolicy(policy);
		return "redirect:/getpolicy"; // Redirect to a list of policies or another appropriate page
	}

	// to view schedule at insurance side
	@GetMapping("/getpolicySchedule")
	public String getAllPolicySchedule(Model m) {
		m.addAttribute("schedules", insu.ListAllPolicySchedules());
		return "ViewSchedule";
	}

	// to view policy
	@GetMapping("/updatepolicy")
	public String UpdateFormPolicy(Model m) {
		List<InsurancePolicy> p = insu.ListAllPolicy();
		m.addAttribute("policies", p);
		return "StatusApproval";
	}

	@GetMapping("/UpdatestatusPolicy")
	public String updatedversionPolicy(@ModelAttribute("policy") InsurancePolicy policy) {
		insu.updateNewPolicy(policy);

		return "redirect:/getpolicy";
	}


 
	 @GetMapping("/nonPaymentStatus")
	    public String getNonPaymentStatus(@RequestParam("iplcId") int id,Model m) {
		 int p = insu.ListNonStatusPayments(id);
		 m.addAttribute("policies", p);
		 return "ViewNonPaymentStatus";
	        
	    }
	 
	 @GetMapping("/StatusPaymentById")
	    public String getDistinctIplcIds(Model model) {
	        List<Integer> distinctIplcIds = insu.findDistinctIds();
	        model.addAttribute("distinctIplcIds", distinctIplcIds);
	        return "StatusById"; 
	    }

}
