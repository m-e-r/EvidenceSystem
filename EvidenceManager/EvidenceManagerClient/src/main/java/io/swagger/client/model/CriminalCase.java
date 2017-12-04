package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Evidence;
import io.swagger.client.model.Suspect;
import io.swagger.client.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CriminalCase
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-04T13:34:31.150Z")
public class CriminalCase {
  @SerializedName("caseDescription")
  private String caseDescription = null;

  @SerializedName("caseEvidence")
  private List<Evidence> caseEvidence = null;

  @SerializedName("caseName")
  private String caseName = null;

  @SerializedName("caseSuspect")
  private List<Suspect> caseSuspect = null;

  @SerializedName("date")
  private String date = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("responsible")
  private String responsible = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("associates")
  private List<User> associates = null;

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
    if (this.caseEvidence == null) {
      this.caseEvidence = new ArrayList<Evidence>();
    }
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
    if (this.caseSuspect == null) {
      this.caseSuspect = new ArrayList<Suspect>();
    }
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

  public CriminalCase date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
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

  public CriminalCase responsible(String responsible) {
    this.responsible = responsible;
    return this;
  }

   /**
   * Get responsible
   * @return responsible
  **/
  @ApiModelProperty(value = "")
  public String getResponsible() {
    return responsible;
  }

  public void setResponsible(String responsible) {
    this.responsible = responsible;
  }

  public CriminalCase status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CriminalCase associates(List<User> associates) {
    this.associates = associates;
    return this;
  }

  public CriminalCase addAssociatesItem(User associatesItem) {
    if (this.associates == null) {
      this.associates = new ArrayList<User>();
    }
    this.associates.add(associatesItem);
    return this;
  }

   /**
   * Get associates
   * @return associates
  **/
  @ApiModelProperty(value = "")
  public List<User> getAssociates() {
    return associates;
  }

  public void setAssociates(List<User> associates) {
    this.associates = associates;
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
        Objects.equals(this.responsible, criminalCase.responsible) &&
        Objects.equals(this.status, criminalCase.status) &&
        Objects.equals(this.associates, criminalCase.associates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseDescription, caseEvidence, caseName, caseSuspect, date, id, responsible, status, associates);
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
    sb.append("    responsible: ").append(toIndentedString(responsible)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    associates: ").append(toIndentedString(associates)).append("\n");
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

