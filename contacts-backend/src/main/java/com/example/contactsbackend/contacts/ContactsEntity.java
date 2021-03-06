package com.example.contactsbackend.contacts;

import com.example.contactsbackend.utils.AbstractEntity;
import com.example.contactsbackend.utils.JPAcomment;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * FileName : ContractEntity
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : 通訊錄的資料庫
 */
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JPAcomment("員工通訊錄")
public class ContactsEntity extends AbstractEntity {

    /**
     * 員工編號
     * 識別每一個員工的唯一性
     */
    @JPAcomment("員工編號")
    private Long empId;
    /**
     * 姓名
     */
    @JPAcomment("姓名")
    private String name;

    /**
     * 生日
     */
    @JPAcomment("生日")
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
     * 職位
     */
    private String job;

    /**
     * 備註
     */
    private String note;
}
