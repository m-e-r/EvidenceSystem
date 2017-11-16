package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;


/**
 * Gets or Sets UserType
 */
public enum UserType {
  
  @SerializedName("Comissioner")
  COMISSIONER("Comissioner"),
  
  @SerializedName("System admin")
  SYSTEM_ADMIN("System admin"),
  
  @SerializedName("Forensic Scientist")
  FORENSIC_SCIENTIST("Forensic Scientist"),
  
  @SerializedName("Police officer")
  POLICE_OFFICER("Police officer");

  private String value;

  UserType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

