package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.CriminalCase;
import java.util.ArrayList;
import java.util.List;

/**
 * LawEnforcer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-20T09:27:31.815Z")
public class LawEnforcer {
  @SerializedName("caseList")
  private List<CriminalCase> caseList = new ArrayList<CriminalCase>();

  @SerializedName("name")
  private String name = null;

  @SerializedName("employeeId")
  private String employeeId = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("userName")
  private String userName = null;

  public LawEnforcer caseList(List<CriminalCase> caseList) {
    this.caseList = caseList;
    return this;
  }

  public LawEnforcer addCaseListItem(CriminalCase caseListItem) {
    this.caseList.add(caseListItem);
    return this;
  }

   /**
   * Get caseList
   * @return caseList
  **/
  @ApiModelProperty(value = "")
  public List<CriminalCase> getCaseList() {
    return caseList;
  }

  public void setCaseList(List<CriminalCase> caseList) {
    this.caseList = caseList;
  }

  public LawEnforcer name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LawEnforcer employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @ApiModelProperty(value = "")
  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public LawEnforcer password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LawEnforcer userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LawEnforcer lawEnforcer = (LawEnforcer) o;
    return Objects.equals(this.caseList, lawEnforcer.caseList) &&
        Objects.equals(this.name, lawEnforcer.name) &&
        Objects.equals(this.employeeId, lawEnforcer.employeeId) &&
        Objects.equals(this.password, lawEnforcer.password) &&
        Objects.equals(this.userName, lawEnforcer.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseList, name, employeeId, password, userName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LawEnforcer {\n");
    
    sb.append("    caseList: ").append(toIndentedString(caseList)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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

