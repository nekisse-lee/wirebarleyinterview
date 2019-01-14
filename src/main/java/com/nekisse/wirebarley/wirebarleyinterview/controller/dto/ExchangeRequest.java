package com.nekisse.wirebarley.wirebarleyinterview.controller.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ExchangeRequest {

  private String code;

  @Max(value = 10000, message = "0보다 작은 금액이거나 10,000 USD보다 큰 금액, 혹은 바른 숫자가 아니라면 송금액이 바르지 않습니다")
  @Min(value = 0, message = "0보다 작은 금액이거나 10,000 USD보다 큰 금액, 혹은 바른 숫자가 아니라면 송금액이 바르지 않습니다")
  private String amount;

  public String getCode() {
    return code;
  }

  public Double getAmount() {
    return Double.valueOf(amount);
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }
}
