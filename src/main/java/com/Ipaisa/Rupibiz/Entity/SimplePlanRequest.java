package com.Ipaisa.Rupibiz.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplePlanRequest {


	    private String status;
	    private String message;
	    private PlanData data;

	    public SimplePlanRequest() {
	    }

	    public SimplePlanRequest(String status, String message, PlanData data) {
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

	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class PlanData {
	        private List<Plan> plans;


	        public PlanData() {
	        }

	        public PlanData(List<Plan> plans) {
	            this.plans = plans;
	        }

	        public List<Plan> getPlans() {
	            return plans;
	        }

	        public void setPlans(List<Plan> plans) {
	            this.plans = plans;
	        }

	        @JsonIgnoreProperties(ignoreUnknown = true)
	        public static class Plan {
	            private String planName;
	            private String price;
	            private String validity;
	            private String details;

	            // Constructors, getters, and setters

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
	}


