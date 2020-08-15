package com.sam.apitest;

public class TransformerFactory {

  public static Transformer getTransformer(String outputType) {
    if ("json".equals(outputType)) {
      return new JsonTransformer();
    } else if ("html".equals(outputType)) {
      return new HtmlTransformer();
    }
    throw new UnsupportedOperationException("Requested output type not supported");
  }
}
