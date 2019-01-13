package com.nekisse.wirebarley.wirebarleyinterview.controller;

import com.nekisse.wirebarley.wirebarleyinterview.service.ExchangeService;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {


  @Autowired
  private ExchangeService service;

  /*@GetMapping("/info")
  public QuotesResponse quotesResponse() {
    return service.getQuotes();
  }*/




}
