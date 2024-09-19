
package com.Ipaisa.Rupibiz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ipaisa.Rupibiz.Entity.PrepaidRecharge;

@Repository
public interface PrepaidRechargeRepository extends JpaRepository<PrepaidRecharge, Long> {
    PrepaidRecharge findByProviderName(String providerName);
}

