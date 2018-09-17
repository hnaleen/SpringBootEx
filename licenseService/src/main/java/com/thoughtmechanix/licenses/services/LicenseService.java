package com.thoughtmechanix.licenses.services;

import com.netflix.discovery.converters.Auto;
import com.thoughtmechanix.licenses.client.OrganizationDiscoveryClient;
import com.thoughtmechanix.licenses.client.OrganizationFeignClient;
import com.thoughtmechanix.licenses.client.OrganizationRibbonRestTemplateClient;
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

  @Autowired
  OrganizationRibbonRestTemplateClient organizationRibbonRestTemplateClient;

  @Autowired
  OrganizationFeignClient organizationFeignClient;

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
    else if (clientType.equalsIgnoreCase("Rest"))
    {
      return organizationRibbonRestTemplateClient.getOrganization(organizationId);
    }
    else if (clientType.equalsIgnoreCase("Feign"))
    {
      return organizationFeignClient.getOrganization(organizationId);
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
