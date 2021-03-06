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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Evidence
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T14:13:15.147Z")
public class Evidence extends Tokenfy  {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("personResponsible")
  private String personResponsible = null;

  @JsonProperty("title")
  private String title = null;

  public Evidence category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @JsonProperty("category")
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Evidence description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @JsonProperty("description")
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Evidence id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Evidence location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty("location")
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Evidence personResponsible(String personResponsible) {
    this.personResponsible = personResponsible;
    return this;
  }

  /**
   * Get personResponsible
   * @return personResponsible
   **/
  @JsonProperty("personResponsible")
  @ApiModelProperty(value = "")
  public String getPersonResponsible() {
    return personResponsible;
  }

  public void setPersonResponsible(String personResponsible) {
    this.personResponsible = personResponsible;
  }

  public Evidence title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @JsonProperty("title")
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
    return Objects.equals(this.category, evidence.category) &&
        Objects.equals(this.description, evidence.description) &&
        Objects.equals(this.id, evidence.id) &&
        Objects.equals(this.location, evidence.location) &&
        Objects.equals(this.personResponsible, evidence.personResponsible) &&
        Objects.equals(this.title, evidence.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, id, location, personResponsible, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evidence {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    personResponsible: ").append(toIndentedString(personResponsible)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

