package com.nekisse.wirebarley.wirebarleyinterview.controller;

import com.nekisse.wirebarley.wirebarleyinterview.service.ExchangeService;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  private final ExchangeService exchangeService;

  @Autowired
  public TestController(ExchangeService exchangeService) {
    this.exchangeService = exchangeService;
  }

  @GetMapping
  public Quotes testResponse() {
    return exchangeService.getQuotesTest2();
  }
}
