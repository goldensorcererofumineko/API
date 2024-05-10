package com.weavus.apistudy.credit.repo;

import com.weavus.apistudy.credit.dto.CreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoInfoRepo extends JpaRepository<CreditInfo, String> {
}
