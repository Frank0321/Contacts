package com.example.contactsbackend;

import com.example.contactsbackend.contacts.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static com.example.contactsbackend.contacts.BloodType.*;

/**
 * FileName : SelectEfficacyTest
 * CreatTime : 2022/1/17
 * Author : Frank.Chang
 * Description : 比較子查詢與新增一個欄位判定最新資料的效能差異
 */
@Slf4j
@SpringBootTest
public class SelectEfficacyTest {

    @Autowired
    ContactsService service;

    /**
     * 以相同 EmpId 但不停地更新(更新員工名稱)做為測試資料
     */
    @Test
    void SQLEffectSameEmpIdTest(){
        log.info("use same EmpId to test effect");
        Contacts contacts = Contacts.builder().name("EffectTest")
                .birthday(LocalDate.now())
                .bloodType(A)
                .phone("0912456789")
                .build();
        service.createContacts(contacts);
        for (int i = 0; i <= 5000; i++) {
            contacts.setName("Effect_"+ i);
            service.updateContacts(contacts);
        }
        showDifferentMethodSpendTimes();
    }

    /**
     * 直接產生大量的員工資料進行測試
     */
    @Test
    void SQLEffectDifferentEmpIdTest(){
        log.info("use different EmpId to test effect");
        for (int i = 0; i <= 5000; i++) {
            service.createContacts(Contacts.builder()
                    .name("EffectTest"+i)
                    .birthday(LocalDate.now())
                    .bloodType(A)
                    .phone("0912456789")
                    .build());
        }
        showDifferentMethodSpendTimes();
    }

    /**
     * 較符合實踐的狀況進行測試
     * 先產生資料後，隨機更新次數
     */
    @Test
    void SQLEffectMixTest(){
        log.info("test effect by close real");
        for (int i = 0; i <= 5000; i++) {
            Contacts build = Contacts.builder()
                    .name("Effect" + i)
                    .birthday(LocalDate.now())
                    .bloodType(A)
                    .phone("0987654321")
                    .build();
            service.createContacts(build);
            for (int j = 0; j <(int) Math.random()*100; j++) {
                build.setName("Change_"+ j);
                service.updateContacts(build);
            }
        }
        showDifferentMethodSpendTimes();
    }

    /**
     * 兩種方法個別所需要花的時間
     */
    private void showDifferentMethodSpendTimes(){
        long start = System.currentTimeMillis();
        List<Contacts> list1 = service.findAllByUsingSubQuery();
        long end = System.currentTimeMillis();
        log.info("finish query by use subQuery : " + (end-start) + "ms");

        start = System.currentTimeMillis();
        List<Contacts> list2 = service.findAllLastVersionIsTrueDeleteFalse();
        end = System.currentTimeMillis();
        log.info("finish query by last version : " + (end-start) + "ms");

        log.info(list1.size() == list2.size() ? "same list size" : "different list size");
        Contacts contacts = list1.stream().filter(n -> !list2.contains(n)).findFirst().orElse(null);
        log.info(contacts == null ? "return same data" : contacts.toString());
    }

}
