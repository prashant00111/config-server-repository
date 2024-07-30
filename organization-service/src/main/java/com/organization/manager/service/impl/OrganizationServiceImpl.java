package com.organization.manager.service.impl;

import com.organization.manager.dto.OrganizationDto;
import com.organization.manager.entity.Organization;
import com.organization.manager.mapper.OrganizationMapper;
import com.organization.manager.repository.OrganizationRepository;
import com.organization.manager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String orgCode) {
        Organization organization = organizationRepository.findByOrgCode(orgCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
