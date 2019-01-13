package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;

import java.util.List;

public class QuotesResponse {

  private List<QuotesInfo> quotesInfoList;

  public QuotesResponse(List<QuotesInfo> quotesInfoList) {
    this.quotesInfoList = quotesInfoList;
  }

  public List<QuotesInfo> getQuotesInfoList() {
    return quotesInfoList;
  }


}
