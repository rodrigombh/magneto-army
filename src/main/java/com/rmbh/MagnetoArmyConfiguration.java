package com.rmbh;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class MagnetoArmyConfiguration extends Configuration {
	
	@NotEmpty
  private String template;

  @JsonProperty
  public String getTemplate() {
      return template;
  }

  @JsonProperty
  public void setTemplate(String template) {
      this.template = template;
  }
  
}
