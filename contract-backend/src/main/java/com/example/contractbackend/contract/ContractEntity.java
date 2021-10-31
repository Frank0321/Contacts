package com.example.contractbackend.contract;

import com.example.contractbackend.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

/**
 * FileName : ContractEntity
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : 通訊錄的資料庫
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractEntity extends AbstractEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 血型
     */
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    /**
     * 電話
     */
    private String phone;

    /**
     * 備註
     */
    private String note;
}
