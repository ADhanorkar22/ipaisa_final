package com.Ipaisa.Rupibiz.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ipaisa.Rupibiz.Service.DTHCustomerInfoService;
import com.Ipaisa.Rupibiz.Service.DTHOperatorCheckService;
import com.Ipaisa.Rupibiz.Service.DTHPlanService;
import com.Ipaisa.Rupibiz.Service.DTHRofferCheckService;
import com.Ipaisa.Rupibiz.Service.OperatorService;
import com.Ipaisa.Rupibiz.Service.RechargePlans;
import com.Ipaisa.Rupibiz.Service.SimpleplanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

	@Autowired
	 private RechargePlans rechargePlans;
	
	@Autowired
	private SimpleplanService simpleplanservice;
	
	@Autowired
	private DTHCustomerInfoService  dthcustomerinfoservice;
	
	@Autowired
	private DTHPlanService dthplanservice;
	
	@Autowired
	private DTHRofferCheckService dthrofferservice;
	
	
	@Autowired
	private OperatorService  getoperatorinfo;
	
	@Autowired
	
	private DTHOperatorCheckService dthoperatorcheckService;
	
	//=======================Recharge_Plan================
	//Same as Roffer----
	
	@GetMapping("/rechargepaln")
	public ResponseEntity<?> getPlans() throws IOException
	{
		return ResponseEntity.ok(rechargePlans.fetchPlanDetails());
	}
	
/////-------------------Simple-Plan--------------
	
	
	
	
	@GetMapping("/simpleplan")
    public ResponseEntity<?> getSimplePlan(
            @RequestParam String circle,
            @RequestParam String operator) {
        try {
            // Call the service method and get the response
            String response = simpleplanservice.fetchSimplePlanDetails( circle, operator);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return a proper error response
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }	
	
	
	
	
	//==============GetCustomerInfo=====================
	
	@GetMapping("/dthCustomerInfo")
    public ResponseEntity<?> getDthCustomerInfo(
            @RequestParam String offer,
            @RequestParam String tel,
            @RequestParam String operator) {
        try {
            // Call the service method and get the response
           // String response = dthcustomerinfoservice.getDthCustomerInfo( offer,tel, operator);
        	
        	 String response = dthcustomerinfoservice.getDthCustomerInfo( offer,tel, operator);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return a proper error response
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }	
	//=========================DTH_Plan==================
	
	@GetMapping("/dthPlans")
    public ResponseEntity<?> getDthPlans(
            @RequestParam String operator)
            {
        try {
            // Call the service method and get the response
            String response = dthplanservice.getDthPlan(operator);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return a proper error response
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }	
	//=======================DTH_Roffer_Check=======================
	 
	 
	@GetMapping("/dthRofferCheck")
    public ResponseEntity<?> getDthRoffer(
            @RequestParam String offer,
            @RequestParam String tel,
            @RequestParam String operator) {
        try {
            // Call the service method and get the response
            String response = dthrofferservice.getDthRofferCheck( offer,tel, operator);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return a proper error response
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }	
	//===============Operator_Plan====================
	@GetMapping("/OperatorCheck")
    public ResponseEntity<?> getOperator(
            @RequestParam String tel)
            {
        try {
            // Call the service method and get the response
            String response = getoperatorinfo.getOperator(tel);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return a proper error response
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }	

	 
	//==============================DTHOperator_Check====================
	
	    @GetMapping("/dthoperatorcheck")
	 public ResponseEntity<?> getDthOperatorcheck(
	            @RequestParam String tel)
	            {
	        try {
	            // Call the service method and get the response
	            String response = dthoperatorcheckService.getDthOperatorInfo(tel);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            // Handle exceptions and return a proper error response
	            return ResponseEntity.status(500).body("Error: " + e.getMessage());
	        }
	    }	

}
	
	


	

