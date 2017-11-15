package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;


/**
 * Gets or Sets UserType
 */
public enum UserType {
  
  @SerializedName("CO")
  COMISSIONER("CO"),
  
  @SerializedName("SA")
  SYSTEM_ADMIN("SA"),
  
  @SerializedName("FS")
  FORENSIC_SCIENTIST("FS"),
  
  @SerializedName("PO")
  POLICE_OFFICER("PO");

  private String value;

  UserType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

