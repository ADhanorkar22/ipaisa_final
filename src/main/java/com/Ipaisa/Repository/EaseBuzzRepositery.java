package com.Ipaisa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ipaisa.Entitys.EasebuzzPayin;
import com.Ipaisa.Entitys.User;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


@Repository
 public interface EaseBuzzRepositery extends JpaRepository<EasebuzzPayin, Long> {

	EasebuzzPayin findByTxnid(String txnid);
	List<EasebuzzPayin> findByUser(User user);
	

//	 @Query("SELECT p FROM EasebuzzPayin p WHERE p.user.id = :userId ORDER BY p.addedon DESC LIMIT 5")
//	List<EasebuzzPayin> findLatestTransactions(@Param("userId") String userId);
//	


@Query("SELECT p FROM EasebuzzPayin p WHERE p.user.id = :userId ORDER BY p.addedon DESC")
List<EasebuzzPayin> findLatestTransactions(@Param("userId") String userId, Pageable pageable);
	
	
}
