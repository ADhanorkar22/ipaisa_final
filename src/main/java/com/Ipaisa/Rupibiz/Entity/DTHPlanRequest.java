package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTHPlanRequest {
	

	    private String status;
	    private String message;
	    private OfferData data;


	    public DTHPlanRequest() {
	    }

	    public DTHPlanRequest(String status, String message, OfferData data) {
	        this.status = status;
	        this.message = message;
	        this.data = data;
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

	    public OfferData getData() {
	        return data;
	    }

	    public void setData(OfferData data) {
	        this.data = data;
	    }

//==========OfferData================
	    
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class OfferData {
	        private String offerName;
	        private String offerDescription;
	        private String validity;
	        private String price;


	        public OfferData() {
	        }

	        public OfferData(String offerName, String offerDescription, String validity, String price) {
	            this.offerName = offerName;
	            this.offerDescription = offerDescription;
	            this.validity = validity;
	            this.price = price;
	        }

	        public String getOfferName() {
	            return offerName;
	        }

	        public void setOfferName(String offerName) {
	            this.offerName = offerName;
	        }

	        public String getOfferDescription() {
	            return offerDescription;
	        }

	        public void setOfferDescription(String offerDescription) {
	            this.offerDescription = offerDescription;
	        }

	        public String getValidity() {
	            return validity;
	        }

	        public void setValidity(String validity) {
	            this.validity = validity;
	        }

	        public String getPrice() {
	            return price;
	        }

	        public void setPrice(String price) {
	            this.price = price;
	        }
	    }
	}



