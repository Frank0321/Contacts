package com.example.contactsbackend.contacts;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * FileName : Contract
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : 通訊錄的物件
 */
@Builder
@Data
@EqualsAndHashCode
public class Contacts {

    /**
     * 員工編號
     */
    private Long empId;

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
    private BloodType bloodType;

    /**
     * 電話
     */
    private String phone;

    /**
     * 職位
     */
    private String job;

    /**
     * 備註
     */
    private String note;

}
