package com.javalabs.billing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecordEntity, Long> {

    @Query(
    		value = "SELECT * FROM billing_record b WHERE b.file_name = :FileName ORDER BY b.call_time",
			nativeQuery = true)
    List<BillingRecordEntity> findByFileName(String FileName);
}
