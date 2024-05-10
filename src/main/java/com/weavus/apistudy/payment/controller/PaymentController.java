package com.weavus.apistudy.payment.controller;

import com.weavus.apistudy.dto.PaymentHistory;
import com.weavus.apistudy.payment.model.PaymentHistoryInfoModel;
import com.weavus.apistudy.repo.PaymentHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentHistoryRepo paymentHistoryRepo;

    @GetMapping("/payment/list")
    public PaymentHistoryInfoModel payment(String month, String cardNo) {
        List<PaymentHistory> paymentHistorieList = paymentHistoryRepo.findByCardNoAndMonth(cardNo, month);
        PaymentHistoryInfoModel model = new PaymentHistoryInfoModel();

        long sum = 0;
        for (PaymentHistory paymentHistory :paymentHistorieList) {
            sum += paymentHistory.getPrice();
        }

        model.setPaymentHistoryList(paymentHistorieList);
        model.setTotalPrice(sum);

        return model;

    }


}
