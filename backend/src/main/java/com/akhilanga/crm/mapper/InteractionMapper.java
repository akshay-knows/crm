package com.akhilanga.crm.mapper;

import com.akhilanga.crm.domain.Interaction;
import com.akhilanga.crm.web.dto.InteractionDtos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InteractionMapper {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerName", expression = "java(entity.getCustomer().fullName())")
    @Mapping(target = "accountId", source = "customer.account.id")
    @Mapping(target = "accountName", source = "customer.account.name")
    @Mapping(target = "authorId", source = "createdByUser.id")
    @Mapping(target = "authorName", expression = "java(entity.getCreatedByUser().fullName())")
    InteractionDtos.Response toResponse(Interaction entity);
}
