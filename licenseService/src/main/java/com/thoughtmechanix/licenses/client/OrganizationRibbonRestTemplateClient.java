package com.thoughtmechanix.licenses.client;

import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component public class OrganizationRibbonRestTemplateClient
{
  @Autowired private RestTemplate restTemplate;

  public Organization getOrganization(String organizationId)
  {
    ResponseEntity<Organization> responseEntity = restTemplate
        .exchange("http://organizationservice/v1/organizations/{organizationId}", HttpMethod.GET, null,
            Organization.class, organizationId);
    return responseEntity.getBody();
  }
}
