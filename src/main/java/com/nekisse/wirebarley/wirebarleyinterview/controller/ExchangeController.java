package com.nekisse.wirebarley.wirebarleyinterview.controller;

import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.ExchangeRequest;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.ExchangeResultResponse;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.QuotesResponse;
import com.nekisse.wirebarley.wirebarleyinterview.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

  private final ExchangeService service;

  @Autowired
  public ExchangeController(ExchangeService service) {
    this.service = service;
  }

  @GetMapping("/infoList")
  public QuotesResponse quotes() {
    return service.getQuotes();
  }

  @GetMapping("")
  public ExchangeResultResponse userResponse(@Valid ExchangeRequest req) {
    return service.getUserResponse(req);
  }





}
