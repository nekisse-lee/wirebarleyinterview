package com.nekisse.wirebarley.wirebarleyinterview.service.dto;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Nation {
  KRW("한국"),
  PHP("필리핀"),
  JPY("일본"),
  ARS("아르헨티나");

  private String name;

  Nation(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public static String createQuotesNation() {
    return Arrays.stream(Nation.values()).map(Enum::name).collect(Collectors.joining(","));
  }

}
