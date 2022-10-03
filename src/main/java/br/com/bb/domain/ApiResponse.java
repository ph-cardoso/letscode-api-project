package br.com.bb.domain;

import java.time.LocalDateTime;

public class ApiResponse<T> {
  public LocalDateTime timeStamp;
  public String message;
  public T data;

  public ApiResponse(String message, T data) {
    this.timeStamp = LocalDateTime.now();
    this.message = message;
    this.data = data;
  }
}
