package org.kybprototyping.taskmanager.taskmanager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

final class Helper {

  private static final ObjectMapper INSTANCE = new ObjectMapper();

  private Helper() {
    throw new UnsupportedOperationException("This class is supposed to be a helper class!");
  }

  static String toJson(Object value) {
    try {
      return INSTANCE.writeValueAsString(value);
    } catch (Exception e) {
      throw new TaskManagerException(e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  static <T> Class<T> findClass(String className) {
    try {
      return (Class<T>) Class.forName(className);
    } catch (ClassNotFoundException | ClassCastException e) {
      throw new TaskManagerException(e.getMessage());
    }
  }

  static <T> T fromJson(String json) {
    try {
      return INSTANCE.readValue(json, new TypeReference<>() {});
    } catch (JsonProcessingException e) {
      throw new TaskManagerException(e.getMessage());
    }
  }

}
