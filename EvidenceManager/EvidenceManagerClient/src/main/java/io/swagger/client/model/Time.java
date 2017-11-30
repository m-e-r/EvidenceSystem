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
 * Time
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-30T15:14:56.475Z")
public class Time {
  @SerializedName("startTime")
  private String startTime = null;

  @SerializedName("endTime")
  private String endTime = null;

  @SerializedName("stillGoing")
  private Boolean stillGoing = null;

  public Time startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public Time endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Time stillGoing(Boolean stillGoing) {
    this.stillGoing = stillGoing;
    return this;
  }

   /**
   * Get stillGoing
   * @return stillGoing
  **/
  @ApiModelProperty(value = "")
  public Boolean isStillGoing() {
    return stillGoing;
  }

  public void setStillGoing(Boolean stillGoing) {
    this.stillGoing = stillGoing;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Time time = (Time) o;
    return Objects.equals(this.startTime, time.startTime) &&
        Objects.equals(this.endTime, time.endTime) &&
        Objects.equals(this.stillGoing, time.stillGoing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startTime, endTime, stillGoing);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Time {\n");
    
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    stillGoing: ").append(toIndentedString(stillGoing)).append("\n");
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

