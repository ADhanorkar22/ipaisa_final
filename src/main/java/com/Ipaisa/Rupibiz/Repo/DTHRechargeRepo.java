package com.Ipaisa.Rupibiz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ipaisa.Rupibiz.Entity.DTHRecharge;

@Repository
public interface DTHRechargeRepo extends JpaRepository<DTHRecharge, Long>{
	
   DTHRecharge findByProviderName(String providerName);

}
