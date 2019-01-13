package com.nekisse.wirebarley.wirebarleyinterview.service.dto;

import java.util.HashMap;
import java.util.Map;

public class Quotes {

  private Map<String, Double> quotes = new HashMap<>();

  public Map<String, Double> getQuotes() {
    return quotes;
  }



  @Override
  public String toString() {
    return "Quotes{" +
        "quotes=" + quotes +
        '}';
  }
}
