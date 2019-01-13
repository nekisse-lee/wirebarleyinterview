package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;

public class QuotesInfo {
  private String nation;
  private String nationCode;
  private double ratesOfExchange;

  public QuotesInfo(String nation, String nationCode, double ratesOfExchange) {
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

  public double getRatesOfExchange() {
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
