package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;

public class QuotesInfo {
  private String nation;
  private String nationCode;
  private String  ratesOfExchange;

  public QuotesInfo(String nation, String nationCode, String  ratesOfExchange) {
    this.nation = nation;
    this.nationCode = nationCode;
    this.ratesOfExchange = ratesOfExchange;
  }

  public String getNation() {
    return nation;
  }

  public String getNationCode() {
    return nationCode;
  }

  public String  getRatesOfExchange() {
    return ratesOfExchange;
  }


  @Override
  public String toString() {
    return "QuotesInfo{" +
        "nation='" + nation + '\'' +
        ", nationCode='" + nationCode + '\'' +
        ", ratesOfExchange=" + ratesOfExchange +
        '}';
  }
}
