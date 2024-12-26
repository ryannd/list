package com.ryannd.list_api.utils;

import com.ryannd.list_api.dto.EntryDto;
import com.ryannd.list_api.entity.Entry;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    @Mapping(target = "mediaRequest", ignore = true)
    EntryDto toDto(Entry entry);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntryFromDto(EntryDto dto, @MappingTarget Entry entry);
}
