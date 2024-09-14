package com.Ipaisa.Rbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rbl")
public class RblSinglePayController {

	
	@Autowired
	private SinglePaymentApiService apiService;
	
	@PostMapping("/payout")
	public String postMethodName() {
		apiService.RblSinglePayout();
		
		return null;
	}
	
	
}
