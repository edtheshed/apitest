package com.sam.apitest;

import com.google.gson.Gson;

public class JsonTransformer implements Transformer {

  @Override
  public String transformData(String data) {
    var personDetails = CsvParser.parse(data);
    Gson gson = new Gson();
    return gson.toJson(personDetails);
  }
}
