package com.example.contactsbackend.contacts;

import com.example.contactsbackend.utils.AbstractEntity;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ContactsEntity extends AbstractEntity {

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
