package com.nekisse.wirebarley.wirebarleyinterview.service;

import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.ExchangeRequest;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.ExchangeResultResponse;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.QuotesInfo;
import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.QuotesResponse;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Nation;
import com.nekisse.wirebarley.wirebarleyinterview.service.dto.Quotes;
import com.nekisse.wirebarley.wirebarleyinterview.service.utils.ExchangeCalculator;
import com.nekisse.wirebarley.wirebarleyinterview.service.utils.UtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExchangeService {


  private static final String STR_USD = "USD";
  Logger logger = LoggerFactory.getLogger(ExchangeService.class);


  private final ExchangeInfoApiClient exchangeInfoApiClient;

  public ExchangeService(ExchangeInfoApiClient exchangeInfoApiClient) {
    this.exchangeInfoApiClient = exchangeInfoApiClient;
  }




  public QuotesResponse getQuotes() {
    Quotes apiClientQuotes = exchangeInfoApiClient.getApiClientQuotes();

//    logger.info(apiClientQuotes.toString());

    Set<Map.Entry<String, Double>> quotes = apiClientQuotes.getQuotes().entrySet();
    List<QuotesInfo> quotesInfos = new ArrayList<>();
    quotes.forEach(entry -> {
      Nation nation = Nation.valueOf(removeStrIfStartWith(entry.getKey()));
      String ratesOfExchange = UtilService.convert(entry.getValue());
      quotesInfos.add(new QuotesInfo(nation.name(), nation.getName(), ratesOfExchange));
    });
//    logger.info(quotesInfos.toString());
    return new QuotesResponse(quotesInfos);
  }



  private String removeStrIfStartWith(String fullName) {
    if (fullName.startsWith(STR_USD)) {
      return fullName.replace(STR_USD, "");
    }
    return fullName;

  }


  public ExchangeResultResponse getUserResponse(ExchangeRequest req) {

    Quotes exchangeData = exchangeInfoApiClient.getApiClientQuotes();
    double ratesOfExchange = exchangeData.get(STR_USD + req.getCode());
//    logger.info(String.valueOf(ratesOfExchange));
    double exchange = ExchangeCalculator.exchange(req.getAmount(), ratesOfExchange);
    System.out.println("exchange = " + exchange);
    String result = UtilService.convert(exchange);

//    logger.info(result + "result", result);
    return new ExchangeResultResponse(req.getCode(), result);
  }

}
