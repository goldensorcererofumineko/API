package com.weavus.apistudy.credit.controller;

import com.weavus.apistudy.credit.repo.CreditoInfoRepo;
import com.weavus.apistudy.credit.dto.CreditInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditController {
    @Autowired
    private CreditoInfoRepo creditoInfoDao;

    @GetMapping("/")
    public String init() {

        return "hello world";
    }

    @PostMapping("/creditInfo")
    public CreditInfo saveCreditInfo(@RequestBody CreditInfo creditInfo) {

        CreditInfo info = creditoInfoDao.save(creditInfo);

        return info;

    }

    @PatchMapping("/creditInfo")
    public CreditInfo UpdateCreditInfo(@RequestBody CreditInfo creditInfo) {

        CreditInfo info = creditoInfoDao.save(creditInfo);

        return info;

    }

    @GetMapping("/creditInfo/{id}")
    public CreditInfo GetCreditInfo(@PathVariable String id) {

        CreditInfo info = creditoInfoDao.findById(id).orElse(null);

        return info;

    }

    @PatchMapping("/payment/id/{id}/price/{price}")
    public ResponseEntity<String> payment(@PathVariable String id,@PathVariable long price) {

        CreditInfo info = creditoInfoDao.findById(id).orElse(null);

        if(info.getGendoGaku() < info.getSiyoGaku() + price) {
            return ResponseEntity.badRequest().body("失敗");
        } else {
            CreditInfo creditInfo = new CreditInfo();
            creditInfo.setCreditNumber(id);
            creditInfo.setSiyoGaku(info.getSiyoGaku() + price);
            creditoInfoDao.save(creditInfo);
            return ResponseEntity.ok("支払い完了");
        }

    }
//    @PatchMapping("/payment/id/{id}/price/{price}")
//    public ResponseEntity<String> payment(@PathVariable String id, @PathVariable long price) {
//
//        CreditInfo info = creditInfoDao.findById(id).orElse(null);
//
//        if(info.getGendoGaku() < info.getSiyoGaku() + price) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("限度額が足りません。");
//        } else {
//            CreditInfo creditInfo = new CreditInfo();
//            creditInfo.setCreditNo(id);
//            creditInfo.setSiyoGaku(info.getSiyoGaku() + price);
//
//            creditInfoDao.save(creditInfo);
//            return ResponseEntity.status(HttpStatus.OK).body("限度額が足りません。");
//
//        }
//
//    }
}
