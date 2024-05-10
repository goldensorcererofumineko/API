package com.weavus.apistudy.payment.model;

import com.weavus.apistudy.dto.PaymentHistory;
import lombok.Data;

import java.util.List;


@Data
public class PaymentHistoryInfoModel {

    private List<PaymentHistory> paymentHistoryList;
    private long totalPrice;

}
