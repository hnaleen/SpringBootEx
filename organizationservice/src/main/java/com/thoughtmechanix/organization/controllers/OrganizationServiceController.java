package com.thoughtmechanix.organization.controllers;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/v1/organizations") public class OrganizationServiceController
{
  @Autowired OrganizationService organizationService;

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET) Organization getOrganization(
      @PathVariable("organizationId") String organizationId)
  {
    return organizationService.getOrganization(organizationId);
  }

}
