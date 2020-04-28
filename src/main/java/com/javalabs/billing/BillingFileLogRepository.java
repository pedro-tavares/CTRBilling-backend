package com.javalabs.billing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingFileLogRepository extends JpaRepository<BillingFileLogEntity, Long> {

	@Query(
			value = "SELECT * FROM billing_file_log b WHERE b.file_name = :fileName",
			nativeQuery = true)
	BillingFileLogEntity findByFileName(String fileName);	
}
