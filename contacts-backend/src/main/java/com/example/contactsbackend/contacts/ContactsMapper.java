package com.example.contactsbackend.contacts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactsMapper {

  @Mappings({
          @Mapping(target = "name", source = "name"),
          @Mapping(target = "birthday", source = "birthday"),
          @Mapping(target = "bloodType", source = "bloodType"),
          @Mapping(target = "phone", source = "phone"),
          @Mapping(target = "job", source = "job"),
          @Mapping(target = "note", source = "note")
  })
  ContactsEntity toEntity (Contacts contacts);

  @Mappings({
          @Mapping(target = "name", source = "name"),
          @Mapping(target = "birthday", source = "birthday"),
          @Mapping(target = "bloodType", source = "bloodType"),
          @Mapping(target = "phone", source = "phone"),
          @Mapping(target = "job", source = "job"),
          @Mapping(target = "note", source = "note")
  })
  Contacts fromEntity(ContactsEntity contactsEntity);

  @Mappings({
          @Mapping(target = "name", source = "name"),
          @Mapping(target = "birthday", source = "birthday"),
          @Mapping(target = "bloodType", source = "bloodType"),
          @Mapping(target = "phone", source = "phone"),
          @Mapping(target = "job", source = "job"),
          @Mapping(target = "note", source = "note"),
          @Mapping(target = "lastVersion", defaultValue = "true")
  })
  List<ContactsEntity> toEntityList (List<Contacts> contactsList);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "birthday", source = "birthday"),
            @Mapping(target = "bloodType", source = "bloodType"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "job", source = "job"),
            @Mapping(target = "note", source = "note")
    })
    List<Contacts> fromEntityList(List<ContactsEntity> contactsEntityList);

}
