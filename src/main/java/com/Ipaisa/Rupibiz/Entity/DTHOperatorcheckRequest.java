package com.Ipaisa.Rupibiz.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTHOperatorcheckRequest {
	

	    private String status;
	    private String message;
	    private DthOperatorData data;



	    public DTHOperatorcheckRequest() {
	    }

	    public DTHOperatorcheckRequest(String status, String message, DthOperatorData data) {
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

	    public DthOperatorData getData() {
	        return data;
	    }

	    public void setData(DthOperatorData data) {
	        this.data = data;
	    }
	    
	    //====================DTH_Operator_Data===============================

	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class DthOperatorData {
	        private String operatorName;
	        private String operatorCode;
	        private String serviceType;
	        private String contact;

	        

	        public DthOperatorData() {
	        }

	        public DthOperatorData(String operatorName, String operatorCode, String serviceType, String contact) {
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

	        public String getContact() {
	            return contact;
	        }

	        public void setContact(String contact) {
	            this.contact = contact;
	        }
	    }
	}



