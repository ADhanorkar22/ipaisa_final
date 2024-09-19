package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MplanRechargeRequest {
	
	    private String status;
	    private String message;
	    private List<Plan> data;

	    public MplanRechargeRequest() {
	    }

	    public MplanRechargeRequest(String status, String message, List<Plan> data) {
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

	    public List<Plan> getData() {
	        return data;
	    }

	    public void setData(List<Plan> data) {
	        this.data = data;
	    }

//===Plan====================	    
	    
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class Plan {
	        private String planName;
	        private String price;
	        private String validity;
	        private String details;

	       

	        public Plan() {
	        }

	        public Plan(String planName, String price, String validity, String details) {
	            this.planName = planName;
	            this.price = price;
	            this.validity = validity;
	            this.details = details;
	        }

	        public String getPlanName() {
	            return planName;
	        }

	        public void setPlanName(String planName) {
	            this.planName = planName;
	        }

	        public String getPrice() {
	            return price;
	        }

	        public void setPrice(String price) {
	            this.price = price;
	        }

	        public String getValidity() {
	            return validity;
	        }

	        public void setValidity(String validity) {
	            this.validity = validity;
	        }

	        public String getDetails() {
	            return details;
	        }

	        public void setDetails(String details) {
	            this.details = details;
	        }
	    }
	}



