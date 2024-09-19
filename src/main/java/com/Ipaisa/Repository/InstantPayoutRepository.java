package com.Ipaisa.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ipaisa.Entitys.EasebuzzPayin;
import com.Ipaisa.Entitys.InstantPayOut;
import com.Ipaisa.Entitys.User;

import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface InstantPayoutRepository extends JpaRepository<InstantPayOut, Long> {
	
	List<InstantPayOut> findByUser(User user);
	InstantPayOut findByExternalRef(String externalRef);

	@Query("select e FROM InstantPayOut e WHERE e.status=:status")
	List<InstantPayOut> findAllTxnCreated(String status);
	
	
		

}
