package com.nekisse.wirebarley.wirebarleyinterview.service.utils;

import java.math.BigDecimal;

public class UtilService {

  private static final String FORMAT = "%,.2f";

  public static String convert(double v) {
    BigDecimal value = new BigDecimal(String.valueOf(v)).setScale(2, BigDecimal.ROUND_FLOOR);
//    System.out.println("value = " + value);
    return String.format (FORMAT, value);
  }
}
