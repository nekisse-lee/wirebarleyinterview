package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;

public class ExchangeResultResponse {

  private String code;
  private String result;

  public ExchangeResultResponse(String code, String result) {
    this.code = code;
    this.result = result;
  }

  public String getCode() {
    return code;
  }

  public String getResult() {
    return result;
  }
}
