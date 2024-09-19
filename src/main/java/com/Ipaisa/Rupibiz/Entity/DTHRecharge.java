
package com.Ipaisa.Rupibiz.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DTHRecharge")
public class DTHRecharge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	@Column(name="opcode")
	private String opcode;
	@Column(name="providerName")
    private String providerName;
	@Column(name="comission")
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
	public DTHRecharge()
	{}
	
	@Override
	public String toString() {
		return "DTHRecharge [id=" + id + ", opcode=" + opcode + ", providerName=" + providerName + ", commission="
				+ commission + "]";
	}
	public DTHRecharge(Long id, String opcode, String providerName, String commission) {
		super();
		this.id = id;
		this.opcode = opcode;
		this.providerName = providerName;
		this.commission = commission;
	}
	public Object getOpcode1() {
		// TODO Auto-generated method stub
		return null;
	}

}
