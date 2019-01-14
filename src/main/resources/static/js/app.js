
$(document).ready(function() {
  var $tbody = $('#tbody');

  var quotesRateMap = {};

  var init = function() {
    $.ajax({
      url: '/exchange/infoList',
      method: 'GET',
      contentType: 'application/json; charset=utf-8',
      success: function(response) {
        var quotes = response.quotesInfoList;

        console.log(quotes);

        for (var i = 0, length = quotes.length; i < length; i++) {
          quotesRateMap[quotes[i].nation] = quotes[i];
          // console.log(quotes[i]);
        }


        renderSelectBoxOption(response);
        renderRatesOfExchangeBox(quotes[0]);
      },
      error: function(response) {
        alert(response.message);
      }
    });
  };

  var renderSelectBoxOption = function(data) {
    var source = $('#exchange-select-template').html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $('#nation').html(html);
  };

  var renderRatesOfExchangeBox = function(data) {
    var source = $('#exchange-ratesOfExchange-template').html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $('#exchange-ratesOfExchange').html(html);
  };

  var renderResultBox = function(data) {
    var source = $('#exchange-result-template').html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $tbody.html('');
    $tbody.html(html);
  };

  $('#nation').change(function() {
    renderRatesOfExchangeBox(quotesRateMap[this.value]);
  });

  $('#btnSubmit').click(function() {
    var request = {
      code: $("#nation option:selected").val(),
      amount: $('#transferAmount').val()
    };
    $.ajax({
      url: '/exchange',
      method: 'GET',
      data: request,
      contentType: 'application/json; charset=utf-8',
      success: function(response) {
        renderResultBox(response);
      },
      error: function(response) {
        //console.log('response', response);
        alert(response.message);
      }
    });
  });



  init();
});
