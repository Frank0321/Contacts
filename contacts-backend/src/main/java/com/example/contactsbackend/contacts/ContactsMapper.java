package com.example.contactsbackend.contacts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactsMapper {
  ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);

  @Mappings({
      @Mapping(target = "name", source = "name")
  })
  ContactsEntity toEntity (Contacts contacts);
}
