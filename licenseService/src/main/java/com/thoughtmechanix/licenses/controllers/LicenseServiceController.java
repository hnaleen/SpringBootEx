package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(value = "v1/organizations/{organizationId}/licenses") public class LicenseServiceController
{
  @Autowired private LicenseService service;

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET) public License getLicenses(
      @PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId)
  {
    return service.getLicense(organizationId, licenseId);
  }

  @RequestMapping(value = "/{licenseId}/{clientType}", method = RequestMethod.GET) public License getLicenses(
      @PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId, @PathVariable("clientType")
      String clientType)
  {
    System.out.println("clientType : " + clientType );
    return service.getLicense(organizationId, licenseId, clientType);
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
