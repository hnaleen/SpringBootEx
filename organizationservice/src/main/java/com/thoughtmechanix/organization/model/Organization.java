package com.thoughtmechanix.organization.model;

public class Organization
{
  private final String id;

  private final String organizationName;

  public Organization(String id, String organizationName)
  {
    this.id = id;
    this.organizationName = organizationName;
  }

  public String getId()
  {
    return id;
  }

  public String getOrganizationName()
  {
    return organizationName;
  }
}
