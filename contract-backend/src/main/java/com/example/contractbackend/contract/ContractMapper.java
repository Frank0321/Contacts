package com.example.contractbackend.contract;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * FileName : ContractMapper
 * CreatTime : 2021/11/1
 * Author : Frank.Chang
 * Description :
 */
@Mapper
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "bloodType", source = "bloodType"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "note", source = "note")
    })
    ContractEntity toEntity (Contract contract);
}
