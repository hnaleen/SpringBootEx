package com.thoughtmechanix.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig
{
  @Value("${config.comment}")
  String tracerProperty;

  public String getTracerProperty()
  {
    return tracerProperty;
  }
}
