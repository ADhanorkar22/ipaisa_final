package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTHRofferRequest {
	
       private String status;
	    private String message;
	    private String offerDetails;

	    public DTHRofferRequest() {
	    }

	    public DTHRofferRequest(String status, String message, String offerDetails) {
	        this.status = status;
	        this.message = message;
	        this.offerDetails = offerDetails;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getOfferDetails() {
	        return offerDetails;
	    }

	    public void setOfferDetails(String offerDetails) {
	        this.offerDetails = offerDetails;
	    }

		@Override
		public String toString() {
			return "DTHRofferRequest [status=" + status + ", message=" + message + ", offerDetails=" + offerDetails
					+ "]";
		}
	    
	    
	}



