package com.nekisse.wirebarley.wirebarleyinterview.service;

import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.QuotesInfo;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.QuotesResponse;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExchangeService {


  Logger logger = LoggerFactory.getLogger(ExchangeService.class);


  private final ExchangeInfoApiClient exchangeInfoApiClient;

  public ExchangeService(ExchangeInfoApiClient exchangeInfoApiClient) {
    this.exchangeInfoApiClient = exchangeInfoApiClient;
  }




  public QuotesResponse getQuotes() {
    Quotes apiClientQuotes = exchangeInfoApiClient.getApiClientQuotes();

    logger.info(apiClientQuotes.toString());

    Set<Map.Entry<String, Double>> quotes = apiClientQuotes.getQuotes().entrySet();
    List<QuotesInfo> quotesInfos = new ArrayList<>();
    for (Map.Entry<String, Double> quote : quotes) {
      quotesInfos.add(new QuotesInfo(quote.getKey(),quote.getKey(),quote.getValue()));
    }

    logger.info(quotesInfos.toString());

    return new QuotesResponse(quotesInfos);
  }


//test
  public Quotes getQuotesTest() {
    Quotes quoData = exchangeInfoApiClient.getApiClientQuotes();
    logger.info(quoData.toString());
    Map<String, Double> quotes = quoData.getQuotes();
    logger.info(quotes.toString());
    for (Map.Entry<String, Double> stringDoubleEntry : quotes.entrySet()) {
      logger.info(stringDoubleEntry.getKey());
      logger.info(String.valueOf(stringDoubleEntry.getValue()));
    }
    return quoData;
  }


  //
  public Quotes getQuotesTest2() {
    Quotes quoData = exchangeInfoApiClient.getApiClientQuotes();
    logger.info(quoData.toString());
    Set<String> quotes = quoData.getQuotes().keySet();
    for (String quote : quotes) {
      logger.info(quote);

    }
    return quoData;
  }




}
