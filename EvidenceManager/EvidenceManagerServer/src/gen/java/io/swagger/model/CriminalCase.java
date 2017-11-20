/*
 * EvidenceManagerAPI
 * API for the project
 *
 * OpenAPI spec version: 5
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Evidence;
import io.swagger.model.Suspect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CriminalCase
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T09:27:35.152Z")
public class CriminalCase   {
  @JsonProperty("caseDescription")
  private String caseDescription = null;

  @JsonProperty("caseEvidence")
  private List<Evidence> caseEvidence = new ArrayList<Evidence>();

  @JsonProperty("caseName")
  private String caseName = null;

  @JsonProperty("caseSuspect")
  private List<Suspect> caseSuspect = new ArrayList<Suspect>();

  @JsonProperty("date")
  private Date date = null;

  @JsonProperty("id")
  private String id = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    OPEN("Open"),
    
    CLOSED("Closed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

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

  public CriminalCase caseEvidence(List<Evidence> caseEvidence) {
    this.caseEvidence = caseEvidence;
    return this;
  }

  public CriminalCase addCaseEvidenceItem(Evidence caseEvidenceItem) {
    this.caseEvidence.add(caseEvidenceItem);
    return this;
  }

   /**
   * Get caseEvidence
   * @return caseEvidence
  **/
  @ApiModelProperty(value = "")
  public List<Evidence> getCaseEvidence() {
    return caseEvidence;
  }

  public void setCaseEvidence(List<Evidence> caseEvidence) {
    this.caseEvidence = caseEvidence;
  }

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

  public CriminalCase caseSuspect(List<Suspect> caseSuspect) {
    this.caseSuspect = caseSuspect;
    return this;
  }

  public CriminalCase addCaseSuspectItem(Suspect caseSuspectItem) {
    this.caseSuspect.add(caseSuspectItem);
    return this;
  }

   /**
   * Get caseSuspect
   * @return caseSuspect
  **/
  @ApiModelProperty(value = "")
  public List<Suspect> getCaseSuspect() {
    return caseSuspect;
  }

  public void setCaseSuspect(List<Suspect> caseSuspect) {
    this.caseSuspect = caseSuspect;
  }

  public CriminalCase date(Date date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public CriminalCase id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CriminalCase status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
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
    return Objects.equals(this.caseDescription, criminalCase.caseDescription) &&
        Objects.equals(this.caseEvidence, criminalCase.caseEvidence) &&
        Objects.equals(this.caseName, criminalCase.caseName) &&
        Objects.equals(this.caseSuspect, criminalCase.caseSuspect) &&
        Objects.equals(this.date, criminalCase.date) &&
        Objects.equals(this.id, criminalCase.id) &&
        Objects.equals(this.status, criminalCase.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseDescription, caseEvidence, caseName, caseSuspect, date, id, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CriminalCase {\n");
    
    sb.append("    caseDescription: ").append(toIndentedString(caseDescription)).append("\n");
    sb.append("    caseEvidence: ").append(toIndentedString(caseEvidence)).append("\n");
    sb.append("    caseName: ").append(toIndentedString(caseName)).append("\n");
    sb.append("    caseSuspect: ").append(toIndentedString(caseSuspect)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

