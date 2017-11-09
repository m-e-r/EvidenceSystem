package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Evidence
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-09T12:37:08.563Z")
public class Evidence {
  @SerializedName("title")
  private String title = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("personResponsible")
  private String personResponsible = null;

  @SerializedName("category")
  private String category = null;

  public Evidence title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Evidence id(String id) {
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

  public Evidence description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public Evidence personResponsible(String personResponsible) {
    this.personResponsible = personResponsible;
    return this;
  }

   /**
   * Get personResponsible
   * @return personResponsible
  **/
  @ApiModelProperty(value = "")
  public String getPersonResponsible() {
    return personResponsible;
  }

  public void setPersonResponsible(String personResponsible) {
    this.personResponsible = personResponsible;
  }

  public Evidence category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
    return Objects.equals(this.title, evidence.title) &&
        Objects.equals(this.id, evidence.id) &&
        Objects.equals(this.description, evidence.description) &&
        Objects.equals(this.location, evidence.location) &&
        Objects.equals(this.personResponsible, evidence.personResponsible) &&
        Objects.equals(this.category, evidence.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, id, description, location, personResponsible, category);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.id)
            .append("\n")
            .append(this.title);
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

