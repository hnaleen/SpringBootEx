package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.model.Organization;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService
{
  public Organization getOrganization(String organizationId)
  {
    return new Organization(UUID.randomUUID().toString(), organizationId);
  }
}
