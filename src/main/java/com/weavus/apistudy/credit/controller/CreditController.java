package com.weavus.apistudy.credit.controller;

import com.weavus.apistudy.repo.CreditInfoRepo;
import com.weavus.apistudy.dto.CreditInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditController {
    @Autowired
    private CreditInfoRepo creditoInfoDao;
    @Autowired
    private CreditInfoRepo creditInfoRepo;

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
    public ResponseEntity<String> payment(@PathVariable String id, @PathVariable long price) {

        CreditInfo info = creditInfoRepo.findById(id).orElse(null);

        long updatedSiyoGaku = info.getSiyoGaku() + price;

        if(info.getGendoGaku() < info.getSiyoGaku() + price) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("限度額が足りません。");
        } else {
            info.setSiyoGaku(updatedSiyoGaku);

            creditInfoRepo.save(info);
            return ResponseEntity.status(HttpStatus.OK).body("決済完了。");

        }

    }
}
