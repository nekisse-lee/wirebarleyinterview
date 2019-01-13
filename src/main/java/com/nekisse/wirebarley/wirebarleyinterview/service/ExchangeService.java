package com.nekisse.wirebarley.wirebarleyinterview.service;

import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {


  private final ExchangeInfoApiClient exchangeInfoApiClient;

  public ExchangeService(ExchangeInfoApiClient exchangeInfoApiClient) {
    this.exchangeInfoApiClient = exchangeInfoApiClient;
  }


  /*public QuotesResponse getQuotes() {
    return  new QuotesResponse();
  }*/


  public Quotes getQuotes() {
    Quotes quoData = exchangeInfoApiClient.getQuoData();
    System.out.println(quoData);
    return quoData;
  }




}
