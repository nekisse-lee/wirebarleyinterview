package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;

import java.util.List;
import java.util.Map;

public class QuotesResponse {

  List<QuotesInfo> quotesInfoList;

  public List<QuotesInfo> getQuotesInfoList() {
    return quotesInfoList;
  }

  public void setQuotesInfoList(List<QuotesInfo> quotesInfoList) {
    this.quotesInfoList = quotesInfoList;
  }
}
