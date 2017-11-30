package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Token
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-30T15:14:56.475Z")
public class Token {
  @SerializedName("Id")
  private String id = null;

  @SerializedName("usertype")
  private String usertype = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("timeStamp")
  private String timeStamp = null;

  public Token id(String id) {
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

  public Token usertype(String usertype) {
    this.usertype = usertype;
    return this;
  }

   /**
   * Get usertype
   * @return usertype
  **/
  @ApiModelProperty(value = "")
  public String getUsertype() {
    return usertype;
  }

  public void setUsertype(String usertype) {
    this.usertype = usertype;
  }

  public Token name(String name) {
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

  public Token timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

   /**
   * Get timeStamp
   * @return timeStamp
  **/
  @ApiModelProperty(value = "")
  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.id, token.id) &&
        Objects.equals(this.usertype, token.usertype) &&
        Objects.equals(this.name, token.name) &&
        Objects.equals(this.timeStamp, token.timeStamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, usertype, name, timeStamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    usertype: ").append(toIndentedString(usertype)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
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

