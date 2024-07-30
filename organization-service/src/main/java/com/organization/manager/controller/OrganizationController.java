package com.organization.manager.controller;

import com.organization.manager.dto.OrganizationDto;
import com.organization.manager.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto organization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(organization, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String orgCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(orgCode);

        return ResponseEntity.ok(organizationDto);
    }
}
