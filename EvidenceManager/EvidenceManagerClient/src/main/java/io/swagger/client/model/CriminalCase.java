package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CriminalCase
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-26T09:34:52.371Z")
public class CriminalCase {
  @SerializedName("caseName")
  private String caseName = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("caseDescription")
  private String caseDescription = null;

  public CriminalCase caseName(String caseName) {
    this.caseName = caseName;
    return this;
  }

   /**
   * Get caseName
   * @return caseName
  **/
  @ApiModelProperty(value = "")
  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public CriminalCase id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CriminalCase caseDescription(String caseDescription) {
    this.caseDescription = caseDescription;
    return this;
  }

   /**
   * Get caseDescription
   * @return caseDescription
  **/
  @ApiModelProperty(value = "")
  public String getCaseDescription() {
    return caseDescription;
  }

  public void setCaseDescription(String caseDescription) {
    this.caseDescription = caseDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CriminalCase criminalCase = (CriminalCase) o;
    return Objects.equals(this.caseName, criminalCase.caseName) &&
        Objects.equals(this.id, criminalCase.id) &&
        Objects.equals(this.caseDescription, criminalCase.caseDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseName, id, caseDescription);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CriminalCase {\n");
    
    sb.append("    caseName: ").append(toIndentedString(caseName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseDescription: ").append(toIndentedString(caseDescription)).append("\n");
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

