package com.Ipaisa.Service;

import java.io.IOException;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;

import org.jetbrains.annotations.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
//import jakarta.servlet.http.HttpServletRequest;
import okhttp3.*;
import okio.Buffer;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.Ipaisa.Entitys.BulkPaymentRequest;
import com.Ipaisa.Entitys.InstantPayBody;
import com.Ipaisa.Entitys.InstantPayOut;
import com.Ipaisa.Entitys.User;
import com.Ipaisa.Repository.InstantPayoutRepository;
import com.Ipaisa.Repository.UserRepositery;
import com.Ipaisa.dto.TransactionStatusRequestDTO;
import com.Ipaisa.fina.SprintNxtService;
import com.Ipaisa.utils.OkHttpClientSingleton;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

import okhttp3.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger;
//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

//import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;

@Service
@Transactional
public class InstantPayService implements LatitudeLongitude ,PayeeAccountNumber{

    @Value("${instantpay.client_id}")
    private String Client_Id;

    @Value("${instantpay.client_secret}")
    private String Client_Secret;

    @Autowired
    private HttpServletRequest request;
    @Autowired
   	private UserRepositery uRepo;
    
    @Autowired
    private InstantPayoutRepository instantPayoutService;
    @Autowired
    private SetChargesInterface setChargesInterface;
    @Autowired
    private SetChargesService setChargesService;
    
    
    

    private final OkHttpClient client;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(InstantPayService.class.getName());
    private static final Random RANDOM = new Random();
    private static final AtomicLong COUNTER = new AtomicLong(1);
    public static final String bankProfileId="35253668680";
    Double charge=0.0;
   
  

    public InstantPayService() {
		super();
		client=OkHttpClientSingleton.getInstance();
	}

	public String encryptAndSendData(InstantPayBody payload ,String mobileno ,Double ourCharge) throws Exception {
        // Construct the request body
//		String id=generateTransactionId();
//    	System.out.println("iddd---------------->>> "+id);






        Map<String, Object> payer = new HashMap<>();
        payer.put("bankProfileId", bankProfileId);
        payer.put("accountNumber", PayeeAccountNumber.payerAccNumber);

        Map<String, Object> payee = new HashMap<>();
        payee.put("name", payload.getName());
        payee.put("accountNumber", payload.getPayeeaccountNumber());
        payee.put("bankIfsc", payload.getBankIfsc());

        Map<String, Object> body = new HashMap<>();
        body.put("payer", payer);
        body.put("payee", payee);
        body.put("transferMode", payload.getTransferMode());
        body.put("transferAmount", payload.getTransferAmount());
        body.put("externalRef", generateTransactionId());
        body.put("latitude", LatitudeLongitude.Latitde);
        body.put("longitude",LatitudeLongitude.Longitude);
        body.put("remarks", PayeeAccountNumber.remark);
        body.put("purpose", PayeeAccountNumber.purpose);

        String data = objectMapper.writeValueAsString(body);

        // Setting the Values in database
        InstantPayOut instantPayoyt = new InstantPayOut();
        User user=uRepo.findByMobileNumber(mobileno);
        System.out.println("user======>"+user);
        instantPayoyt.setUser(user);
        instantPayoyt.setExternalRef((String)body.get("externalRef"));
//        instantPayoyt.s((String)body.get("transferAmount"));
        instantPayoyt.setTxnValue(payload.getTransferAmount());
        instantPayoyt.setPayeeAccount(payload.getPayeeaccountNumber());
        instantPayoyt.setPayeeName(payload.getName());
        instantPayoyt.setEnvironment("LIVE");
        instantPayoyt.setPayerAccount("120664700000021");

        instantPayoyt.setStatus("Pending");
//        instantPayoyt.set((String) body.get("bankIfsc"));
        System.out.println("externalRef --  "+(String)body.get("externalRef"));
        ////////////////// Update Wallet Balance /////////////////////////////////
        instantPayoyt.setWalletOpeningBalance(user.getWalletBalance());
        String amt=(String) payload.getTransferAmount();
        double amount=Double.parseDouble(amt);


        double finalAmount=amount+ourCharge;



            user.setWalletBalance(user.getWalletBalance()-finalAmount);
            uRepo.save(user);


        instantPayoyt.setWalletClosingBalance(user.getWalletBalance());
        instantPayoutService.save(instantPayoyt);

        return sendEncryptedData(data,mobileno,payload.getTransferMode(),ourCharge);
    }

    private String sendEncryptedData(String data,String mobileno, String transfermode,Double ourCharge) throws Exception {
    	
    	 String responseBody=null;
    	URL url = new URL("http://ifconfig.me/ip");
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    	String endpointIp = in.readLine();
    	in.close();
    	System.out.println("Public IP Address: " + endpointIp);
     
       
        // Build the request
        MediaType mediaType = MediaType.parse("application/hal+json");
        RequestBody body = RequestBody.create(mediaType, data);

        Request request = new Request.Builder()
                .url("https://api.instantpay.in/payments/payout")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("X-Ipay-Auth-Code", "1")
                .addHeader("X-Ipay-Client-Id", Client_Id)
                .addHeader("X-Ipay-Client-Secret", Client_Secret)
                .addHeader("X-Ipay-Endpoint-Ip", endpointIp) // Set the endpoint IP dynamically
                .addHeader("content-type", "application/hal+json")
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            logRequest(request);
            String responseContentType = response.header("Content-Type");
            LOGGER.log(Level.INFO, "Response Content-Type: {0}", responseContentType);

            Headers headers = response.headers();
            for (int i = 0, size = headers.size(); i < size; i++) {
                String headerName = headers.name(i);
                String headerValue = headers.value(i);
                LOGGER.log(Level.INFO, "{0}: {1}", new Object[]{headerName, headerValue});
            }
            

            responseBody = response.body().string();
//            InstantPayOut instantPayoyt = objectMapper.readValue(responseBody, InstantPayOut.class);
//            instantPayoutService.save(instantPayoyt);
            
            
            
            
            
            ObjectMapper objectMapper = new ObjectMapper();
            try {


                Map<String, Object> jsonMap = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
                Map<String, Object> data1 = (Map<String, Object>) jsonMap.get("data");

                // Extract values from JSON
//                InstantPayOut instantPayoyt = new InstantPayOut();
                InstantPayOut instantPayoyt = this.instantPayoutService.findByExternalRef((String) data1.get("externalRef"));
                User user=uRepo.findByMobileNumber(mobileno);
                System.out.println("user======>"+user);
                instantPayoyt.setUser(user);
                instantPayoyt.setStatuscode((String) jsonMap.get("statuscode"));
                instantPayoyt.setActcode((String) jsonMap.get("actcode"));
                instantPayoyt.setStatus((String) jsonMap.get("status"));
                instantPayoyt.setExternalRef((String) data1.get("externalRef"));
                instantPayoyt.setPoolReferenceId((String) data1.get("poolReferenceId"));
                instantPayoyt.setTxnValue((String) data1.get("txnValue"));
                instantPayoyt.setTxnReferenceId((String) data1.get("txnReferenceId"));

                Map<String, Object> pool = (Map<String, Object>) data1.get("pool");
                if (pool != null) {
                    instantPayoyt.setPoolAccount((String) pool.get("account"));
                    instantPayoyt.setPoolOpeningBal((String) pool.get("openingBal"));
                    instantPayoyt.setPoolMode((String) pool.get("mode"));
                    instantPayoyt.setPoolAmount((String) pool.get("amount"));
                    instantPayoyt.setPoolClosingBal((String) pool.get("closingBal"));
                }

                Map<String, Object> payer = (Map<String, Object>) data1.get("payer");
                if (payer != null) {
                    instantPayoyt.setPayerAccount((String) payer.get("account"));
                    instantPayoyt.setPayerName((String) payer.get("name"));
                }

                Map<String, Object> payee = (Map<String, Object>) data1.get("payee");
                if (payee != null) {
                    instantPayoyt.setPayeeAccount((String) payee.get("account"));
                    instantPayoyt.setPayeeName((String) payee.get("name"));
                }
                String timestampString = (String) jsonMap.get("timestamp");
                if (timestampString != null && !timestampString.isEmpty()) {
                    try {
                        LocalDateTime timestamp = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        instantPayoyt.setTimestamp(timestamp);
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parsing timestamp: " + timestampString);
                        e.printStackTrace();
                    }
                }

                instantPayoyt.setIpayUuid((String) jsonMap.get("ipay_uuid"));
                instantPayoyt.setOrderid((String) jsonMap.get("orderid"));
                instantPayoyt.setEnvironment((String) jsonMap.get("environment"));

//     ////////////////// Update Wallet Balance /////////////////////////////////
//                instantPayoyt.setWalletOpeningBalance(user.getWalletBalance());
//                String amt=(String) data1.get("txnValue");
//                double amount=Double.parseDouble(amt);
//
//
//                double finalAmount=amount+ourCharge;
//
//                String status=(String) jsonMap.get("status");
//                if("Transaction Successful".equals(status))
//                {
//                	user.setWalletBalance(user.getWalletBalance()-finalAmount);
//                	uRepo.save(user);
//                }
//
//                instantPayoyt.setWalletClosingBalance(user.getWalletBalance());
//                instantPayoutService.save(instantPayoyt);
         
                
                
                         
                
                
            LOGGER.log(Level.INFO, "Response Body: {0}", responseBody);

            // Decrypt the response body
            return responseBody;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during HTTP request", e);
            return responseBody;
        }
        } catch (SocketTimeoutException e) {
            LOGGER.log(Level.SEVERE, "Timeout occurred during HTTP request", e);
            throw new Exception("Request timed out. Please try again.");

    }
      
    }


//    private String getClientIpAddress() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            return request.getRemoteAddr();
//        }
//        return null;
//    }

    private void logRequest(Request request) {
        LOGGER.log(Level.INFO, "-- Request --");
        LOGGER.log(Level.INFO, "URL: {0}", request.url());
        LOGGER.log(Level.INFO, "Method: {0}", request.method());

        Headers headers = request.headers();
        for (String name : headers.names()) {
            LOGGER.log(Level.INFO, "Header: {0} - {1}", new Object[]{name, headers.get(name)});
        }

        RequestBody requestBody = request.body();
        if (requestBody != null) {
            try {
                LOGGER.log(Level.INFO, "Body: {0}", requestBodyToString(requestBody));
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error reading request body", e);
            }
        }
    }

    private String requestBodyToString(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }
    
   
    public static String generateTransactionId() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        int randomNum = 100000 + RANDOM.nextInt(900000); // 6-digit random number
        long counterValue = COUNTER.getAndIncrement();
        return timestamp + randomNum + counterValue;
    }
    
    
    
//    public String processBulkPayments(BulkPaymentRequest bulkRequest, String mobileno) throws Exception {
//        StringBuilder responseBuilder = new StringBuilder();
//        User user = uRepo.findByMobileNumber(mobileno);
//        double totalAmount = bulkRequest.getPayments().stream()
//                                       .mapToDouble(payment -> Double.parseDouble(payment.getTransferAmount()))
//                                       .sum();
//
//        if (user.getWalletBalance() < totalAmount) {
//            return "Insufficient balance for bulk payments";
//        }
//
//        for (InstantPayBody payment : bulkRequest.getPayments()) {
//            String response = encryptAndSendData(payment, mobileno);
//            responseBuilder.append(response).append("\n");
//        }
//
//        return responseBuilder.toString();
//    }
//    
    


    @Scheduled(fixedRate = 15 * 60 *1000)
    public void checkTxnStatus() throws IOException {
        LocalTime currentTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(23, 30);
        LocalTime endTime = LocalTime.of(0, 30);

        // Skip execution during maintenance period (11:30 PM to 12:30 AM)
        if (currentTime.isAfter(startTime) || currentTime.isBefore(endTime)) {
            System.out.println("Skipping execution due to maintenance window");
            return;
        }

        // Endpoint URL
        List<InstantPayOut> list = instantPayoutService.findAllTxnCreated("Pending");

        //  list.stream().filter(e -> e.getStatus().equals("created")).collect(Collectors.toList());

        System.out.println("list=========>" + list);

        for (InstantPayOut instantPayout : list) {
            System.out.println("in loop");

             String response = getResponse(instantPayout.getExternalRef());
           // String response = getResponse();

            System.out.println(response);
            Map<String, Object> jsonMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });
            Map<String, Object> data1 = (Map<String, Object>) jsonMap.get("data");
/////


            if (data1.get("transactionStatusCode").equals("TXN")) {
                String timestampString = (String) data1.get("transactionDateTime");
                System.out.println("transactionDateTime: " + timestampString);

                if (timestampString != null && !timestampString.isEmpty()) {
                    try {
                        LocalDateTime timestamp = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        instantPayout.setTimestamp(timestamp);
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parsing timestamp: " + timestampString);
                        e.printStackTrace();
                    }
                }

                String txnValue = (String) data1.get("transactionAmount");
                System.out.println("transactionAmount: " + txnValue);
                instantPayout.setTxnValue(txnValue);

                String txnReferenceId = (String) data1.get("transactionReferenceId");
                System.out.println("transactionReferenceId: " + txnReferenceId);
                instantPayout.setTxnReferenceId(txnReferenceId);

                String status = (String) data1.get("transactionStatus");
                System.out.println("transactionStatus: " + status);
                instantPayout.setStatus(status);

                String statusCode = (String) data1.get("transactionStatusCode");
                System.out.println("transactionStatusCode: " + statusCode);
                instantPayout.setStatuscode(statusCode);

                String ipayUuid = (String) jsonMap.get("ipay_uuid");
                System.out.println("ipay_uuid: " + ipayUuid);
                instantPayout.setIpayUuid(ipayUuid);

                Map<String, Object> pool = (Map<String, Object>) data1.get("pool");
                System.out.println("pool: " + pool);

                if (pool != null) {
                    Map<String, Object> transaction = (Map<String, Object>) pool.get("transaction");
                    System.out.println("transaction: " + transaction);

                    if (transaction != null) {
                        String poolReferenceId = (String) transaction.get("referenceId");
                        System.out.println("poolReferenceId: " + poolReferenceId);
                        instantPayout.setPoolReferenceId(poolReferenceId);
                        instantPayout.setOrderid(poolReferenceId);

                        String poolOpeningBal = (String) transaction.get("openingBalance");
                        System.out.println("openingBalance: " + poolOpeningBal);
                        instantPayout.setPoolOpeningBal(poolOpeningBal);

                        String poolMode = (String) transaction.get("mode");
                        System.out.println("mode: " + poolMode);
                        instantPayout.setPoolMode(poolMode);

                        String poolAmount = (String) transaction.get("paymentAmount");
                        System.out.println("paymentAmount: " + poolAmount);
                        instantPayout.setPoolAmount(poolAmount);

                        String poolClosingBal = (String) transaction.get("closingBalance");
                        System.out.println("closingBalance: " + poolClosingBal);
                        instantPayout.setPoolClosingBal(poolClosingBal);
                    }
                }

                instantPayoutService.save(instantPayout);


            } else if (data1.get("transactionStatusCode").equals("TUP")) {
                System.out.println("in TUP");
                continue;
            } else {
                Double ourCharge=0.0;
                Map<String, Object> pool = (Map<String, Object>) data1.get("pool");
                System.out.println("pool: " + pool);

                if (pool != null) {
                    Map<String, Object> reversal = (Map<String, Object>) pool.get("reversal");
                    System.out.println("transaction: " + reversal);



                    if (reversal.get("referenceId") != null) {
                        /////


                        String timestampString = (String) data1.get("transactionDateTime");
                        System.out.println("transactionDateTime: " + timestampString);

                        if (timestampString != null && !timestampString.isEmpty()) {
                            try {
                                LocalDateTime timestamp = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                instantPayout.setTimestamp(timestamp);
                            } catch (DateTimeParseException e) {
                                System.err.println("Error parsing timestamp: " + timestampString);
                                e.printStackTrace();
                            }
                        }

                        String txnValue = (String) data1.get("transactionAmount");
                        System.out.println("transactionAmount: " + txnValue);
                        instantPayout.setTxnValue(txnValue);

                        Map<String, Object> mode = (Map<String, Object>) data1.get("order");


                        ourCharge=setChargesInterface.getFinalCharge(Double.parseDouble(txnValue), mode.get("optional4").toString());

                        String txnReferenceId = (String) data1.get("transactionReferenceId");
                        System.out.println("transactionReferenceId: " + txnReferenceId);
                        instantPayout.setTxnReferenceId(txnReferenceId);

                        String status = (String) data1.get("transactionStatus");
                        System.out.println("transactionStatus: " + status);
                        instantPayout.setStatus("REFUND");

                        String statusCode = (String) data1.get("transactionStatusCode");
                        System.out.println("transactionStatusCode: " + statusCode);
                        instantPayout.setStatuscode("SPD");

                        String ipayUuid = (String) jsonMap.get("ipay_uuid");
                        System.out.println("ipay_uuid: " + ipayUuid);
                        instantPayout.setIpayUuid(ipayUuid);




                            Map<String, Object> transaction = (Map<String, Object>) pool.get("transaction");
                            System.out.println("transaction: " + transaction);

                            if (transaction != null) {
                                String poolReferenceId = (String) transaction.get("referenceId");
                                System.out.println("poolReferenceId: " + poolReferenceId);
                                instantPayout.setPoolReferenceId(poolReferenceId);
                                instantPayout.setOrderid(poolReferenceId);

                                String poolOpeningBal = (String) reversal.get("openingBalance");
                                System.out.println("openingBalance: " + poolOpeningBal);
                                instantPayout.setPoolOpeningBal(poolOpeningBal);

                                String poolMode = (String) reversal.get("mode");
                                System.out.println("mode: " + poolMode);
                                instantPayout.setPoolMode(poolMode);

                                String poolAmount = (String) transaction.get("paymentAmount");
                                System.out.println("paymentAmount: " + poolAmount);
                                instantPayout.setPoolAmount(poolAmount);

                                String poolClosingBal = (String) reversal.get("closingBalance");
                                System.out.println("closingBalance: " + poolClosingBal);
                                instantPayout.setPoolClosingBal(poolClosingBal);
                            }
                            User user=instantPayout.getUser();
                        instantPayout.setWalletOpeningBalance(user.getWalletBalance());
                      //  String amt=(String) payload.getTransferAmount();
                        double amount=Double.parseDouble(txnValue);


                        double finalAmount=amount+ourCharge;



                        user.setWalletBalance(user.getWalletBalance()+finalAmount);
                        uRepo.save(user);


                        instantPayout.setWalletClosingBalance(user.getWalletBalance());

                        instantPayoutService.save(instantPayout);
                    }


                }



            }
    }
    }


        private String getResponse (String externalRef) throws IOException {

            String curl = "https://api.instantpay.in/reports/txnStatus";

            URL url = new URL("http://ifconfig.me/ip");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String endpointIp = in.readLine();
            in.close();
            System.out.println("Public IP Address: " + endpointIp);
            // Hardcoded headers
            Request.Builder requestBuilder = new Request.Builder()
                    .url(curl)
                    .addHeader("X-Ipay-Auth-Code", "1")
                    .addHeader("X-Ipay-Client-Id", Client_Id)
                    .addHeader("X-Ipay-Client-Secret", Client_Secret)
                    .addHeader("X-Ipay-Endpoint-Ip", endpointIp)
                    .addHeader("Content-Type", "application/json");

            // Request body with parameters from user
            Map<String, String> requestBodyMap = new HashMap<>();
         //   requestBodyMap.put("transactionDate", LocalDate.now().toString());
            requestBodyMap.put("transactionDate", "2024-09-13");
            requestBodyMap.put("externalRef", externalRef);
           // requestBodyMap.put("source", "ORDER");

            // Convert request body map to JSON string
            String requestBodyJson = objectMapper.writeValueAsString(requestBodyMap);

            // Create Request Body
            RequestBody body = RequestBody.create(requestBodyJson, MediaType.get("application/json; charset=utf-8"));

            // Build the request
            Request request = requestBuilder.post(body).build();

            // Execute request and get response
            try (Response response = client.newCall(request).execute()) {  // Correct usage of OkHttpClient's newCall()
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                // Return response body as a string
                return response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }





}
