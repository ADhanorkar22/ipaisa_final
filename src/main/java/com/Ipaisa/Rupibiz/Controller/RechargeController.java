package com.Ipaisa.Rupibiz.Controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ipaisa.Rupibiz.Entity.RechargeV5Request;
import com.Ipaisa.Rupibiz.Service.BillFetchService;
import com.Ipaisa.Rupibiz.Service.GetBalanceNewService;
import com.Ipaisa.Rupibiz.Service.GetBalanceService;
import com.Ipaisa.Rupibiz.Service.GetRechargeStatusService;
import com.Ipaisa.Rupibiz.Service.RechargeDTHService;
import com.Ipaisa.Rupibiz.Service.RechargeService;
import com.Ipaisa.Rupibiz.Service.RechargeV5Service;
import com.Ipaisa.Rupibiz.Service.RegisterComplaintService;
import com.Ipaisa.Rupibiz.dto.ReachargeDetailsParameters;

@RestController
@RequestMapping("/apis")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;
    
    @Autowired
    private GetBalanceService getBalanceService;
    
    
    @Autowired
    private RegisterComplaintService registerComplaintService;
    
    @Autowired
    private BillFetchService billFetchService;

    
    @Autowired
    private RechargeV5Service rechargeV5Service;
    
    @Autowired
    private GetBalanceNewService getBalancenew;
    
    @Autowired
    private GetRechargeStatusService getRechargeStatusService;
    
    @Autowired
    private RechargeDTHService dthService;
       
    
    @PostMapping("/recharge")
    public ResponseEntity<String> sendRechargeRequest(@RequestBody ReachargeDetailsParameters rr ) {
        try {
            String response = rechargeService.sendRechargeRequest(rr);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
    @PostMapping("/dth")
    public ResponseEntity<String> sendRechargeRequestt(@RequestBody ReachargeDetailsParameters rr ) {
        try {
        	System.out.println(rr.getProviderName());
            String response = dthService.sendRechargeRequestt(rr);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
   
       @PostMapping("/getBalance")
    public ResponseEntity<String> sendRechargeRequest1() {
        try {
            String response = getBalanceService.sendRechargeRequest();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
       
       @PostMapping("/GetBalanceNew")
       public ResponseEntity<String>GetBalanceNew() {
           try {
               String response = getBalancenew.GetBalanceNew();
             
               return ResponseEntity.ok(response);
           } catch (IOException e) {
               return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
           }

   }
    
    @PostMapping("/rechargeV5")
    public ResponseEntity<String> sendRechargeRequest2(@RequestBody RechargeV5Request rrv) {
        try {
            String response = rechargeV5Service.sendRechargeRequest(rrv);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
    
    
    @GetMapping("/GetRechargeSatus")
    public ResponseEntity<String>GetRechargeStatusRequest() {
        try {
            String response = getRechargeStatusService.GetRechargeStatusRequest();
          
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }

}
    
//    @PostMapping("/billFetchh")
//    public ResponseEntity<String> sendRechargeRequest3() {
//        try {
//            String response = billFetchService.sendRechargeRequest();
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
//        }
//    }
    
//    @PostMapping("/billFetchh")
//    public ResponseEntity<String> sendRechargeRequest3(@RequestParam BillFetchRequest bfr) {
//        System.out.println(bfr.toString());
//    	try {
//            String response = billFetchService.sendRechargeRequest(bfr);
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
//        }
//    }

    @PostMapping("/billFetchh")
    public ResponseEntity<String> sendRechargeRequest3(@RequestParam Map<String, String> parameters) {
        System.out.println(parameters);
    	try {
            String response = billFetchService.sendRechargeRequest(parameters);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
    @PostMapping("/register-complaint")
    public ResponseEntity<String> sendRechargeRequest4() {
        try {
            String response = registerComplaintService.sendRechargeRequest();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }

    
    
    
}




