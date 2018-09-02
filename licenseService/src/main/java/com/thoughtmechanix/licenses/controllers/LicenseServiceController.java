package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(value = "v1/organizations/{organizationId}/licenses") public class LicenseServiceController
{
  @Autowired private LicenseService service;

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET) public License getLicenses(
      @PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId)
  {
    return service.getLicense(organizationId, licenseId);
  }

  @RequestMapping(value = "/add/{productName}/{licenseType}") public void addLicense(
      @PathVariable("organizationId") String organizationId, @PathVariable("productName") String productName,
      @PathVariable("licenseType") String licenseType)
  {
    License license = new License().withProductName(productName).withLicenseType(licenseType)
        .withOrganizationId(organizationId);
    service.saveLicense(license);
  }
}
