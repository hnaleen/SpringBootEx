package com.thoughtmechanix.licenses.model;

public class License
{
  String licenseId;

  String organizationId;

  String productName;

  String licenseType;

  public String getLicenseId()
  {
    return licenseId;
  }

  public String getOrganizationId()
  {
    return organizationId;
  }

  public String getProductName()
  {
    return productName;
  }

  public String getLicenseType()
  {
    return licenseType;
  }

  public License withId(String licenseId)
  {
    this.licenseId = licenseId;
    return this;
  }

  public License withProductName(String productName)
  {
    this.productName = productName;
    return this;
  }

  public License withLicenseType(String licenseType)
  {
    this.licenseType = licenseType;
    return this;
  }

  public License withOrganizationId(String organizationId)
  {
    this.organizationId = organizationId;
    return this;
  }
}
