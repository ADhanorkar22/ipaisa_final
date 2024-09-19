package com.Ipaisa.Rupibiz.Controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ipaisa.Rupibiz.Entity.BeneficiaryAcVerifyRequest;
import com.Ipaisa.Rupibiz.Entity.BeneficiaryRegisterValidateRequest;
import com.Ipaisa.Rupibiz.Entity.BeneficiaryRemoveRequest;
import com.Ipaisa.Rupibiz.Entity.BeneficiaryResendOtpRequest;
import com.Ipaisa.Rupibiz.Entity.GetBanksRequest;
import com.Ipaisa.Rupibiz.Entity.GetHistoryRequest;
import com.Ipaisa.Rupibiz.Entity.GetIfscRequest;
import com.Ipaisa.Rupibiz.Entity.GetKycMandatoryRequest;
import com.Ipaisa.Rupibiz.Entity.GetRemitterrransferLimitRequest;
import com.Ipaisa.Rupibiz.Entity.InitiateRequest;
import com.Ipaisa.Rupibiz.Entity.KycValidateRequest;
import com.Ipaisa.Rupibiz.Entity.KycValidateService;
import com.Ipaisa.Rupibiz.Entity.RemitterDetailsRequest;
import com.Ipaisa.Rupibiz.Entity.RemitterRequest;
import com.Ipaisa.Rupibiz.Entity.RemitterValidateRequest;
import com.Ipaisa.Rupibiz.Entity.TransferRequest;
import com.Ipaisa.Rupibiz.Entity.TransferStatusRequest;
import com.Ipaisa.Rupibiz.Service.BeneficiaryAcVerifyService;
import com.Ipaisa.Rupibiz.Service.BeneficiaryRegisterService;
import com.Ipaisa.Rupibiz.Service.BeneficiaryRegisterValidateService;
import com.Ipaisa.Rupibiz.Service.BeneficiaryRemoveService;
import com.Ipaisa.Rupibiz.Service.BeneficiaryResendOtpService;
import com.Ipaisa.Rupibiz.Service.GetBanksService;
import com.Ipaisa.Rupibiz.Service.GetHistoryService;
import com.Ipaisa.Rupibiz.Service.GetIfscService;
import com.Ipaisa.Rupibiz.Service.GetRemitterrransferLimitService;
import com.Ipaisa.Rupibiz.Service.InitiateService;
import com.Ipaisa.Rupibiz.Service.RemitterDetailsService;
import com.Ipaisa.Rupibiz.Service.RemitterOttpService;
import com.Ipaisa.Rupibiz.Service.RemitterService;
import com.Ipaisa.Rupibiz.Service.RemitterValidateService;
import com.Ipaisa.Rupibiz.Service.TransferService;
import com.Ipaisa.Rupibiz.Service.TransferStatusService;
import com.Ipaisa.Rupibiz.dto.BeneficiaryRegisterDto;
@RestController
@RequestMapping("/rapi")
public class RemitterController {
	@Autowired
	private RemitterService remitterService;
	
	@Autowired
	private RemitterDetailsService remitterDetailsService;
	
	@Autowired
	private GetHistoryService getHistoryService;
	
	@Autowired
	private BeneficiaryRegisterService beneficiaryRegisterService;
	
	@Autowired
	private BeneficiaryResendOtpService beneficiaryResendOtpService;
	
	@Autowired
	private BeneficiaryRegisterValidateService  beneficiaryRegisterValidateService;
	
	@Autowired
	private BeneficiaryAcVerifyService beneficiaryAcVerifyService;
	
	@Autowired
	private BeneficiaryRemoveService beneficiaryRemoveService;
	
	@Autowired
    private TransferStatusService transferStatusService;
	
	@Autowired
	private TransferService transferService;
	
	
	@Autowired
	private RemitterValidateService remitterValidateService;
	
	@Autowired
	private GetBanksService getBanksService;
	
	@Autowired
	private GetRemitterrransferLimitService getRemitterTransferLimit;
	
	@Autowired
	private GetIfscService getIfscService;
	
	
	//****
	@Autowired
	private GetHistoryService getKycMandatoryService;
	
	@Autowired
	private InitiateService initiateService;
	
	@Autowired
	private KycValidateService KycValidate;
	
		
	//*********************	
	@Autowired
	private RemitterOttpService remitterOttpService;
	
	
	
//	//*********************getKycMandatory***********
//	@PostMapping("/getKycMandatory")
//    public ResponseEntity<String> sendGetKyc(@RequestBody GetKycMandatoryRequest getKyc ) {
//        try {
//            String response = getKycMandatoryService.sendGetKyc(getKyc);
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
//        }
//    }
	
	//*********************initiate***********

	@PostMapping("/initiate")
    public ResponseEntity<String> sendInitiateRequest(@RequestBody InitiateRequest ini ) {
        try {
            String response = initiateService.sendInitiateRequest(ini);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
	//*********************Validate Kyc*******************
	
	@PostMapping("/kycValidate")
    public ResponseEntity<String> sendKycValidateRequest(@RequestBody KycValidateRequest kycvalidate ) {
        try {
            String response = KycValidate.sendKycValidateRequest(kycvalidate);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }

	
	//********************
	
	@PostMapping("/remitter")
    public ResponseEntity<String> sendRemitterRequest(@RequestBody RemitterRequest rr ) {
        try {
            String response = remitterService.sendRemitterRequest(rr);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }	
	
	 @PostMapping("/remitterdetails")
	    public ResponseEntity<String> sendRemitterDetailsRequest(@RequestBody RemitterDetailsRequest rdr) {
	        try {
	            String response = remitterDetailsService.sendRemitterDetailsRequest(rdr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	
	 @PostMapping("/getHistory")
	    public ResponseEntity<String> sendGetHistoryRequest(@RequestBody GetHistoryRequest ghr) {
	        try {
	            String response = getHistoryService.sendGetHistoryRequest(ghr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/beneficiary_register")
	    public ResponseEntity<String> sendBeneficiaryRegisterRequest(@RequestBody BeneficiaryRegisterDto brr ) {
	        try {
	            String response = beneficiaryRegisterService.sendBeneficiaryRegisterRequest(brr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/beneficiaryResendOtp")
	    public ResponseEntity<String> sendBeneficiaryResendOtpRequest(@RequestBody BeneficiaryResendOtpRequest brotp) {
	        try {
	            String response = beneficiaryResendOtpService.sendBeneficiaryResendOtpRequest(brotp);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	
	 @PostMapping("/beneficiaryRegisterValidate")
	    public ResponseEntity<String> sendBeneficiaryRegisterValidateRequest(@RequestBody BeneficiaryRegisterValidateRequest brvr) {
	        try {
	            String response = beneficiaryRegisterValidateService.sendBeneficiaryRegisterValidateRequest(brvr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/beneficiaryAcVerify")
	    public ResponseEntity<String> sendBeneficiaryAcVerifyRequest(@RequestBody BeneficiaryAcVerifyRequest bacr) {
	        try {
	            String response = beneficiaryAcVerifyService.sendBeneficiaryAcVerifyRequest(bacr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/beneficiaryRemove")
	    public ResponseEntity<String> sendBeneficiaryRemoveRequest(@RequestBody BeneficiaryRemoveRequest brr) {
	        try {
	            String response = beneficiaryRemoveService.sendBeneficiaryRemoveRequest(brr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/transfer")
	    public ResponseEntity<String> TransferRequest(@RequestBody TransferRequest tr) {
	        try {
	            String response = transferService.sendTransferRequest(tr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/transferstatus")
	    public ResponseEntity<String> TransferStatusRequest(@RequestBody TransferStatusRequest tsr) {
	        try {
	            String response = transferStatusService.sendTransferStatusRequest(tsr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	
	 @PostMapping("/remittervalidate")
	    public ResponseEntity<String> sendRemitterValidationRequest(@RequestBody RemitterValidateRequest rvr) {
	        try {
	            String response = remitterValidateService.sendRemitterValidationRequest(rvr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	 @PostMapping("/get_banks")
	    public ResponseEntity<String> GetbanksRequest(@RequestBody GetBanksRequest gbr) {
	        try {
	            String response = getBanksService.sendGetbanksRequest(gbr);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	 
	 @PostMapping("/getremitterrransferlimit")
	    public ResponseEntity<String> sendGetRemitterrransferLimit(@RequestBody GetRemitterrransferLimitRequest getremelimit) {
	        try {
	            String response = getRemitterTransferLimit.sendGetRemitterrransferLimitRequest(getremelimit);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }
	 
	 
	 @PostMapping("/getIfsc")
	    public ResponseEntity<String> sendGetIfscRequest(@RequestBody GetIfscRequest getifsc) {
	        try {
	            String response = getIfscService.sendGetIfscRequest(getifsc);
	            return ResponseEntity.ok(response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
	        }
	    }


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	//*********************************************************
	 //remitter validation----
	    @PostMapping("/register")
	    public ResponseEntity<String> RegisterRemitter(@RequestParam String mobile,
	                                                   @RequestParam String name,
	                                                   @RequestParam String surname,
	                                                   @RequestParam String pincode) {
	        try {
	            JSONObject response = remitterOttpService.registerRemitter(mobile, name, surname, pincode);
	            if (response.getInt("is_verified") == 0) {
	                return ResponseEntity.ok("Remitter registered but needs OTP validation. Remitter ID: " + response.getString("remitter_id"));
	            }
	            return ResponseEntity.ok("Remitter successfully registered and verified.");
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error registering remitter: " + e.getMessage());
	        }
	    }
	    @PostMapping("/validate")
	    public ResponseEntity<String> ValidateRemitter(@RequestParam String mobile,
	                                                   @RequestParam String remitterId,
	                                                   @RequestParam String otp) {
	        try {
	            String response = remitterOttpService.validateRemitter(mobile, remitterId, otp);
	            return ResponseEntity.ok("Remitter validated successfully: " + response);
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error validating remitter: " + e.getMessage());
	        }
	    }
	
	 	
}


