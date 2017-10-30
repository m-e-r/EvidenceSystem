package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Evidence
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-30T16:59:51.265Z")
public class Evidence {
  @SerializedName("evidenceNumber")
  private Integer evidenceNumber = null;

  @SerializedName("evidenceDescription")
  private String evidenceDescription = null;

  @SerializedName("location")
  private String location = null;

  public Evidence evidenceNumber(Integer evidenceNumber) {
    this.evidenceNumber = evidenceNumber;
    return this;
  }

   /**
   * Get evidenceNumber
   * @return evidenceNumber
  **/
  @ApiModelProperty(value = "")
  public Integer getEvidenceNumber() {
    return evidenceNumber;
  }

  public void setEvidenceNumber(Integer evidenceNumber) {
    this.evidenceNumber = evidenceNumber;
  }

  public Evidence evidenceDescription(String evidenceDescription) {
    this.evidenceDescription = evidenceDescription;
    return this;
  }

   /**
   * Get evidenceDescription
   * @return evidenceDescription
  **/
  @ApiModelProperty(value = "")
  public String getEvidenceDescription() {
    return evidenceDescription;
  }

  public void setEvidenceDescription(String evidenceDescription) {
    this.evidenceDescription = evidenceDescription;
  }

  public Evidence location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Evidence evidence = (Evidence) o;
    return Objects.equals(this.evidenceNumber, evidence.evidenceNumber) &&
        Objects.equals(this.evidenceDescription, evidence.evidenceDescription) &&
        Objects.equals(this.location, evidence.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evidenceNumber, evidenceDescription, location);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evidence {\n");
    
    sb.append("    evidenceNumber: ").append(toIndentedString(evidenceNumber)).append("\n");
    sb.append("    evidenceDescription: ").append(toIndentedString(evidenceDescription)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

