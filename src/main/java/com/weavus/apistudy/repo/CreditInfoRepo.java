package com.weavus.apistudy.repo;

import com.weavus.apistudy.dto.CreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditInfoRepo extends JpaRepository<CreditInfo, String> {
}
