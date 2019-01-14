package com.nekisse.wirebarley.wirebarleyinterview.service.dto;

public enum Nation {
  KRW("한국"),
  PHP("필리핀"),
  JPY("일본");

  private String name;

  Nation(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

}
