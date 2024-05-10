package com.weavus.apistudy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

//@DynamicUpdate
@NoArgsConstructor
@Entity
@Getter
@Setter
public class CreditInfo {

    @Id
    @Column(length = 19)
    private String creditNumber;

    @Column(length = 100)
    private String name;

    @Column(length = 20)
    private long gendoGaku;

    @Column(length = 20)
    private long siyoGaku;

}
