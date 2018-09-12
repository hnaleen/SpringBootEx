package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.model.Organization;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class OrganizationService
{
  public Organization getOrganization(String organizationId)
  {
    return new Organization("ORG:" + organizationId, UUID.randomUUID().toString());
  }
}
