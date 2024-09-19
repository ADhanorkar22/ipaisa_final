package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorRequest {


	    private String status;
	    private String message;
	    private OperatorData data;

	    
	    public OperatorRequest() {
	    }

	    public OperatorRequest(String status, String message, OperatorData data) {
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

	    public OperatorData getData() {
	        return data;
	    }

	    public void setData(OperatorData data) {
	        this.data = data;
	    }

	  //===Operator_Data===================
	    
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class OperatorData {
	        private String operatorName;
	        private String operatorCode;
	        private String serviceType;
	        private String contact;

	        

	        public OperatorData() {
	        }

	        public OperatorData(String operatorName, String operatorCode, String serviceType, String contact) {
	            this.operatorName = operatorName;
	            this.operatorCode = operatorCode;
	            this.serviceType = serviceType;
	            this.contact = contact;
	        }

	        public String getOperatorName() {
	            return operatorName;
	        }

	        public void setOperatorName(String operatorName) {
	            this.operatorName = operatorName;
	        }

	        public String getOperatorCode() {
	            return operatorCode;
	        }

	        public void setOperatorCode(String operatorCode) {
	            this.operatorCode = operatorCode;
	        }

	        public String getServiceType() {
	            return serviceType;
	        }

	        public void setServiceType(String serviceType) {
	            this.serviceType = serviceType;
	        }

	    }
}


