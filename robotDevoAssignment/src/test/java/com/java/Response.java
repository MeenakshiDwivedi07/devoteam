package com.java;

import java.io.ByteArrayOutputStream;

public class Response {

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();

  public ByteArrayOutputStream stream() {
    return output;
  }

  @Override
  public String toString() {
    return output.toString();
  }
}
