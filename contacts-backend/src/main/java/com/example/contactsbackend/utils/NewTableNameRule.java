package com.example.contactsbackend.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * FileName : NewTableNameRule
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description :
 */
public class NewTableNameRule extends SpringPhysicalNamingStrategy {

    private static final String TABLE_PREFIX = "CONT_";

    //table 前面需要添加的前綴字
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        Identifier identifier = super.toPhysicalTableName(name, jdbcEnvironment);
        return new Identifier(TABLE_PREFIX + identifier.getText(), identifier.isQuoted());
    }

    //table 後面須處理的事情 : 移除 Entity
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        String identifier = name.replace("_Entity", "");
        return new Identifier(identifier, quoted);
    }
}
