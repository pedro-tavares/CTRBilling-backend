package com.javalabs.billing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecordEntity, Long> {

}
