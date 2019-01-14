package com.nekisse.wirebarley.wirebarleyinterview.service;

import com.nekisse.wirebarley.wirebarleyinterview.service.utils.ExchangeCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExchangeCalculatorTest {

  @Test
  public void 환율계산기_기본() {
    double exchange = ExchangeCalculator.exchange(100, 1119.1);
    assertEquals(111910.0, exchange, 0.0);
  }

  @Test
  public void 환율_소수두번째자리_버리고_계산() {
    double exchange = ExchangeCalculator.exchange(10.0, 1119.99999999);
    assertEquals(11199.9, exchange, 0.0);
  }
}