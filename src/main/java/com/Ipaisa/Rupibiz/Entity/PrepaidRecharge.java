package com.Ipaisa.Rupibiz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrepaidRecharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String opcode;
    private String providerName;
    private String commission;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public PrepaidRecharge() {
		
	}
	public PrepaidRecharge(Long id, String opcode, String providerName, String commission) {
		super();
		this.id = id;
		this.opcode = opcode;
		this.providerName = providerName;
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "PrepaidRecharge [id=" + id + ", opcode=" + opcode + ", providerName=" + providerName + ", commission="
				+ commission + "]";
	}
	   
    
}
