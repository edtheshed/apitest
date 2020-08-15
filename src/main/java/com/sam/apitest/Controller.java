package com.sam.apitest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

  @RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
  @ResponseBody
  public ResponseEntity<?> transformDetails(@RequestHeader("output-type") String outputType,
      @RequestBody String data) {
    Transformer transformer = TransformerFactory.getTransformer(outputType);
    return ResponseEntity.ok(transformer.transformData(data));
  }

}