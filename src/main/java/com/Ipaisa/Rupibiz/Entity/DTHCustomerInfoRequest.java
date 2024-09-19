package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTHCustomerInfoRequest {
	

	    private String status;
	    private String message;
	    private PlanData data;


	    public DTHCustomerInfoRequest() {
	    }

	    public DTHCustomerInfoRequest(String status, String message, PlanData data) {
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

	    public PlanData getData() {
	        return data;
	    }

	    public void setData(PlanData data) {
	        this.data = data;
	    }
//==============Plan_Data====================================
	    
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class PlanData {
	        private String planName;
	        private String price;
	        private String validity;
	        private String channelCount;

	        

	        public PlanData() {
	        }

	        public PlanData(String planName, String price, String validity, String channelCount) {
	            this.planName = planName;
	            this.price = price;
	            this.validity = validity;
	            this.channelCount = channelCount;
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

	        public String getChannelCount() {
	            return channelCount;
	        }

	        public void setChannelCount(String channelCount) {
	            this.channelCount = channelCount;
	        }
	    }
	}

