package com.thoughtmechanix.licenses.model;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
public class License
{
  @Id
  @Column(name = "license_id", nullable = false)
  String licenseId;

  @Column(name = "organization_id", nullable = false)
  String organizationId;

  @Column(name = "product_name", nullable = false)
  String productName;

  @Column(name = "license_type", nullable = false)
  String licenseType;

  @Transient
  String comment;

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

  public String getComment()
  {
    return comment;
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

  public License withComment(String comment)
  {
    this.comment = comment;
    return this;
  }
}
