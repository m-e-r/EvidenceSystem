package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets CaseStatus
 */
@JsonAdapter(CaseStatus.Adapter.class)
public enum CaseStatus {
  
  OPEN("Open"),
  
  CLOSED("Closed");

  private String value;

  CaseStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CaseStatus fromValue(String text) {
    for (CaseStatus b : CaseStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<CaseStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final CaseStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CaseStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CaseStatus.fromValue(String.valueOf(value));
    }
  }
}

