package com.nekisse.wirebarley.wirebarleyinterview.service;

import java.math.BigDecimal;

public class ExchangeCalculator {
  private ExchangeCalculator() {}

  public static double exchange(double amount, double ratesOfExchange) {
    BigDecimal decimalAmount = BigDecimal.valueOf(amount);
    BigDecimal decimalRatesOfExchange = BigDecimal.valueOf(ratesOfExchange).setScale(2, BigDecimal.ROUND_DOWN);
    return decimalAmount.multiply(decimalRatesOfExchange).doubleValue();
  }
}
