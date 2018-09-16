package com.thoughtmechanix.organization.model;

public class Organization
{
  private final String id;

  private final String organizationName;

  private final String contactName;

  private final String contactEmail;

  public Organization(String id, String organizationName)
  {
    this.id = id;
    this.organizationName = organizationName;
    this.contactName = "contact @ " + organizationName;
    this.contactEmail = organizationName + "@gmail.com";
  }

  public String getId()
  {
    return id;
  }

  public String getOrganizationName()
  {
    return organizationName;
  }

  public String getContactName()
  {
    return contactName;
  }

  public String getContactEmail()
  {
    return contactEmail;
  }
}
