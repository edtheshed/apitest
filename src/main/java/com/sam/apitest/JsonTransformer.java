package com.sam.apitest;

public class JsonTransformer implements Transformer {

  @Override
  public String transformData(String data) {
    return "test";
  }
}
