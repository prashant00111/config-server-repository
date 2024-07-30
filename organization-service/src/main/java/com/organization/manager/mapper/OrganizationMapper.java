package com.organization.manager.mapper;

import com.organization.manager.dto.OrganizationDto;
import com.organization.manager.entity.Organization;

public class OrganizationMapper {

    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getName(),
                organizationDto.getDescription(),
                organizationDto.getOrgCode(),
                organizationDto.getCreatedDate()
        );
        return organization;
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getOrgCode(),
                organization.getCreatedDate()
        );
        return organizationDto;
    }
}
