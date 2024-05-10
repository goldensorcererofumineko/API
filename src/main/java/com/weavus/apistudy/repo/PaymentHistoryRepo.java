package com.weavus.apistudy.repo;

import com.weavus.apistudy.dto.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory, Integer> {

    List<PaymentHistory> findByCardNoAndMonth(String cardNo, String month);
}
