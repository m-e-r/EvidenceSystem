package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-20T09:27:31.815Z")
public class User {
  @SerializedName("username")
  private String username = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("employeeId")
  private String employeeId = null;

  @SerializedName("address")
  private String address = null;

  @SerializedName("birthday")
  private String birthday = null;

  @SerializedName("name")
  private String name = null;
  
  @SerializedName("usertype")
  private UserType role = null;

  public User username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User password(String password) {
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

  public User employeeId(String employeeId) {
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

  public User address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User birthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

   /**
   * Get birthday
   * @return birthday
  **/
  @ApiModelProperty(value = "")
  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "")
  public String name() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
    
  //Temp getter and setter
  public UserType getRole() {
      return this.role;
  }
  
  public void setRole(UserType role) {
      this.role =role;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.username, user.username) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.employeeId, user.employeeId) &&
        Objects.equals(this.address, user.address) &&
        Objects.equals(this.birthday, user.birthday) &&
        Objects.equals(this.name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, employeeId, address, birthday, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role.toString())).append("\n");
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

