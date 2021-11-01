package com.example.contactsbackend.contacts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactsMapper {
  ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);

  @Mappings({
          @Mapping(target = "name", source = "name"),
          @Mapping(target = "birthday", source = "birthday"),
          @Mapping(target = "bloodType", source = "bloodType"),
          @Mapping(target = "phone", source = "phone"),
          @Mapping(target = "note", source = "note")
  })
  ContactsEntity toEntity (Contacts contacts);

  @Mappings({
          @Mapping(target = "id", ignore = true),
          @Mapping(target = "createDataTime", ignore = true),
          @Mapping(target = "createBy", ignore = true),
          @Mapping(target = "lastModifieDateTime", ignore = true),
          @Mapping(target = "lastModifiedBy", ignore = true),
          @Mapping(target = "version", ignore = true),
          @Mapping(target = "lastVersion", ignore = true),
          @Mapping(target = "deleted", ignore = true)
  })
  Contacts fromEntity (ContactsEntity contactsEntity);
}
