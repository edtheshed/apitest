package com.sam.apitest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TransformerFactoryShould {

  @Test
  void return_json_transformer_when_requested() {
    var transformer = TransformerFactory.getTransformer("json");
    assertThat(transformer).isInstanceOf(JsonTransformer.class);
  }

  @Test
  void return_html_transformer_when_requested() {
    var transformer = TransformerFactory.getTransformer("html");
    assertThat(transformer).isInstanceOf(HtmlTransformer.class);
  }

  @Test
  void throw_exception_if_requested_is_unknown() {
    assertThrows(UnsupportedOperationException.class,
        () -> TransformerFactory.getTransformer("unknown"));

  }
}