package com.nekisse.wirebarley.wirebarleyinterview.service;

import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Nation;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ExchangeInfoApiClient {

  private final  RestTemplate restTemplate;

  @Autowired
  public ExchangeInfoApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Quotes getApiClientQuotes() {
    Quotes rateDataDto = restTemplate.getForObject(
        "http://apilayer.net" +
            "/api/live?" +
            "access_key=07b88071071212c8e286cf29cd653547&" +
            "currencies=" +
            Nation.createQuotesNation() +
            "&" +
            "source=USD&format=1", Quotes.class);

    return rateDataDto;
  }





}
