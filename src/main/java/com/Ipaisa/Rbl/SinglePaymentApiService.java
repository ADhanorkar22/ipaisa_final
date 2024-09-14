package com.Ipaisa.Rbl;

import java.util.HashMap;import java.security.SecureRandom;
import java.time.Instant;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

@Service
public class SinglePaymentApiService {

	
	public final static String URL="https://apideveloper.rblbank.com/test/sb/rbl/v1/payments/corp/payment";
	 private final OkHttpClient client = new OkHttpClient();
	 ObjectMapper mappObject=new ObjectMapper(); 
	 private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final int MAX_LENGTH = 10;

	    private static final SecureRandom random = new SecureRandom();
	    
	    private final static String debitAcctNo="";
	    private final static String debitAcctName="";
	    private final static String debitIFSC="";
	    private final static String debitMobile="";
	    private final static String debitTrnParticulars="";
	    private final static String debitPartTrnRmks="";
	 
	 public ResponseEntity<?> RblSinglePayout()
	 {
		 
//		 For NEFT/IMPS minimum Amount should be ‘1’.
//		 For FT minimum amount should be more than ‘0’
//		 For RTGS Minimum amount should be ‘200000’
//
//		 "Body": {
//				"Amount": "1.50",
//				"Debit_Acct_No": "1000112010000333",
//				"Debit_Acct_Name": "TEJU MAHTO",
//				"Debit_IFSC": "RBLB1122123",
//				"Debit_Mobile": "1234567890",
//				"Debit_TrnParticulars": "FARIDA",
//				"Debit_PartTrnRmks": "SURESH",
//				"Ben_IFSC": "DNSB0000021",
//				"Ben_Acct_No": "109566016481",
//				"Ben_Name": "SINGLE PAYMENT",
//				"Ben_Address": "MUMBAI",
//				"Ben_BankName": "ABC123123",
//				"Ben_BankCd": "176",
//				"Ben_BranchCd": "0123",
//				"Ben_Email": "mail@gmail.com",
//				"Ben_Mobile": "9895527234",
//				"Ben_TrnParticulars": "VIBEESH_@123",
//				"Ben_PartTrnRmks": "SINGLE PAYMENT",
//				"Issue_BranchCd": "0112",
//				"Mode_of_Pay": "IMPS",
//				"Remarks": "PAYEMNT QUEUE"		
//			},
//			

		 
		 
		 String transactionId = generateTransactionId();
		 
		 System.out.println("TXN ID --->>> "+transactionId);
		 
		 Map<String,Object> payload=new HashMap<String,Object>();
		 Map<String,Object> Single_Payment_Corp_Req=new HashMap<String,Object>();
		 Map<String,String> Header=new HashMap<String,String>();
		 Header.put("TranID", "1Abc22249Q01");
		 Header.put("Corp_ID", "ZSA01");
		 Header.put("Maker_ID", "M005");
		 Header.put("Checker_ID", "C003");
		 Header.put("Approver_ID", "A003");
		 
		 Single_Payment_Corp_Req.put("Header", Header);
		 
		 Map<String,String> body=new HashMap<String,String>();
		body.put("Amount", "");
		body.put("Debit_Acct_No", debitAcctNo);
		body.put("Debit_Acct_Name", debitAcctName);
		body.put("Debit_IFSC", debitIFSC);
		body.put("Debit_Mobile", debitMobile);
		body.put("Debit_TrnParticulars", debitTrnParticulars);
		body.put("Debit_PartTrnRmks", debitPartTrnRmks);
		body.put("Ben_IFSC", "");
		body.put("Ben_Acct_No", "");
		body.put("Ben_Name", "");
		body.put("Ben_Address", "");
		body.put("Ben_BankName", "");
		body.put("Ben_BankCd", "");
		body.put("Ben_BranchCd", "");
		body.put("Ben_Email", "");
		body.put("Ben_Mobile", "");
		body.put("Ben_TrnParticulars", "");
		body.put("Ben_PartTrnRmks", "");
		body.put("Issue_BranchCd", "");
		body.put("Mode_of_Pay", "");
		body.put("Remarks", "");
		body.put("RptCode", "");
		
		Single_Payment_Corp_Req.put("Body", body);
		Map<String,String> Signature=new HashMap<String,String>();
		Signature.put("Signature", "Signature");
		 
		Single_Payment_Corp_Req.put("Signature", Signature);
		
		 
		 
		 String fpayload=null;
		 try {
			 fpayload=mappObject.writeValueAsString(Single_Payment_Corp_Req);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 
		 System.out.println(""+fpayload);
		 
		 
		 return null;
		 
	 }
	
	  public static String generateTransactionId() {
	        // Get current timestamp in milliseconds
	        long currentTimeMillis = Instant.now().toEpochMilli();
	        
	        // Convert the timestamp to Base62 to ensure uniqueness and compactness
	        String base62Time = encodeBase62(currentTimeMillis);

	        // Add additional random Base62 characters if needed to meet length requirement
	        StringBuilder transactionId = new StringBuilder(base62Time);
	        while (transactionId.length() < MAX_LENGTH) {
	            transactionId.append(BASE62.charAt(random.nextInt(BASE62.length())));
	        }

	        // Trim the ID to ensure it does not exceed max length
	        if (transactionId.length() > MAX_LENGTH) {
	            transactionId.setLength(MAX_LENGTH);
	        }

	        return transactionId.toString();
	    }
	  private static String encodeBase62(long value) {
	        StringBuilder sb = new StringBuilder();
	        while (value > 0) {
	            int remainder = (int) (value % BASE62.length());
	            sb.append(BASE62.charAt(remainder));
	            value /= BASE62.length();
	        }
	        return sb.reverse().toString();
	    }
}
