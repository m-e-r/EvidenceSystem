package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Suspect
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-30T16:59:51.265Z")
public class Suspect {
  @SerializedName("suspectDescription")
  private String suspectDescription = null;

  public Suspect suspectDescription(String suspectDescription) {
    this.suspectDescription = suspectDescription;
    return this;
  }

   /**
   * Get suspectDescription
   * @return suspectDescription
  **/
  @ApiModelProperty(value = "")
  public String getSuspectDescription() {
    return suspectDescription;
  }

  public void setSuspectDescription(String suspectDescription) {
    this.suspectDescription = suspectDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Suspect suspect = (Suspect) o;
    return Objects.equals(this.suspectDescription, suspect.suspectDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(suspectDescription);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Suspect {\n");
    
    sb.append("    suspectDescription: ").append(toIndentedString(suspectDescription)).append("\n");
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

