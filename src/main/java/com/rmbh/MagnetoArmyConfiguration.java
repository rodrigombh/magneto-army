package com.rmbh;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class MagnetoArmyConfiguration extends Configuration {
	
	@NotEmpty
  private String template;

	@NotEmpty
	private String accessKey;
	
	@NotEmpty
	private String secretKey;
	
  @JsonProperty
  public String getTemplate() {
      return template;
  }

  @JsonProperty
  public void setTemplate(String template) {
      this.template = template;
  }

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
  
}
