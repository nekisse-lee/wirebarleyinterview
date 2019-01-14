package com.nekisse.wirebarley.wirebarleyinterview.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilServiceTest {

  @Test
  public void 소수점_둘쨰자리_버림_테스트() {
    assertEquals("100.99", UtilService.convert(100.994124));
  }

  @Test
  public void 세자리_콤마_테스트() {
    String convertStr = UtilService.convert(10000.111);
    assertEquals("10,000.11", convertStr);
  }

  @Test
  public void 세자리_콤마_테스트2() {
    String convertStr = UtilService.convert(10000111.111123);
    assertEquals("10,000,111.11", convertStr);
  }
}