package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets UserType
 */
@JsonAdapter(UserType.Adapter.class)
public enum UserType {
  
  COMISSIONER("Comissioner"),
  
  SYSTEM_ADMIN("System_admin"),
  
  FORENSIC_SCIENTIST("Forensic_Scientist"),
  
  POLICE_OFFICER("Police_officer");

  private String value;

  UserType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

 
  public static UserType fromValue(String text) {
    for (UserType b : UserType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<UserType> {
    @Override
    public void write(final JsonWriter jsonWriter, final UserType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UserType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UserType.fromValue(String.valueOf(value));
    }
  }
}

