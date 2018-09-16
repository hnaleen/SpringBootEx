package com.thoughtmechanix.licenses.services;

import com.thoughtmechanix.licenses.client.OrganizationDiscoveryClient;
import com.thoughtmechanix.licenses.config.ServiceConfig;
import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.model.Organization;
import com.thoughtmechanix.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService
{
  @Autowired
  private LicenseRepository licenseRepository;

  @Autowired ServiceConfig config;

  @Autowired
  OrganizationDiscoveryClient organizationDiscoveryClient;

  public License getLicense(String organizationId, String licenseId)
  {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    return license.withComment(config.getTracerProperty());
  }

  public License getLicense(String organizationId, String licenseId, String clientType)
  {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    Organization organization = retrieveOrgInfo(organizationId, clientType);
    return license
        .withOrganizationName(organization.getName())
        .withContactName(organization.getContactName())
        .withContactEmail(organization.getContactEmail())
        .withComment(config.getTracerProperty());
  }

  private Organization retrieveOrgInfo(String organizationId, String clientType)
  {
    if (clientType.equalsIgnoreCase("Discovery"))
    {
       return organizationDiscoveryClient.getOrganization(organizationId);
    }
    return null;
  }

  public List<License> getLicensesByOrg(String organizationId)
  {
    return licenseRepository.findByOrganizationId(organizationId);
  }

  public void saveLicense(License license)
  {
    license.withId(UUID.randomUUID().toString());
    licenseRepository.save(license);
  }
}
