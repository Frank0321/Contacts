package com.example.contactsbackend.contacts;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

/**
 * FileName : Contract
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : 通訊錄的物件
 */
@Builder
@Data
public class Contacts {

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
     * 備註
     */
    private String note;

}
