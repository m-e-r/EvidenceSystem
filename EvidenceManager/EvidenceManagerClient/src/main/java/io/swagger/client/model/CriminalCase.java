package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Suspect;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/**
 * CriminalCase
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-22T09:15:28.707Z")
public class CriminalCase {
  @SerializedName("caseDescription")
  private String caseDescription = null;

  @SerializedName("caseEvidence")
  private List<Evidence> caseEvidence = new ArrayList<Evidence>();

  @SerializedName("caseName")
  private String caseName = null;

  @SerializedName("caseSuspect")
  private List<Suspect> caseSuspect = new ArrayList<Suspect>();

  @SerializedName("date")
  private LocalDate date = null;

  @SerializedName("id")
  private String id = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    @SerializedName("Open")
    OPEN("Open"),
    
    @SerializedName("Closed")
    CLOSED("Closed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("status")
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

  public CriminalCase date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
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

