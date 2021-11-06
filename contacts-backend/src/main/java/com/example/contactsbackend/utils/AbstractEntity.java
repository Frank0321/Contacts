package com.example.contactsbackend.utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static lombok.Builder.*;

/**
 * FileName : AbstractEntity
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : 統一 Entity 會繼承的類別
 */
@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "tableRule")
    @GenericGenerator(name = "tableRule", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @Parameter(name = "table_name", value = "sequence_pooled"),
            @Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @Parameter(name = "optimizer", value = "pooled-lo"),
            @Parameter(name = "initial_value", value = "100001"),
            @Parameter(name = "increment_size", value = "100")
    })
    protected Long id;

    /**
     * 建立時間
     */
    @CreatedDate
    protected LocalDateTime createDataTime;

    /**
     * 建立人員 (會因為登入人員做修改，待設計)
     */
    @CreatedBy
    protected String createBy;

    /**
     * 最後修改時間
     */
    @LastModifiedDate
    protected LocalDateTime lastModifieDateTime;

    /**
     * 最後修改人員
     */
    @LastModifiedBy
    protected String lastModifiedBy;
    /**
     * 資料儲存版本
     */
    @Version
    protected Long version;

    /**
     * 是否為最新的版本
     */
    @Default
    protected boolean lastVersion = true;

    /**
     * 是否被刪除
     */
    @Default
    protected boolean deleted = false;
}
