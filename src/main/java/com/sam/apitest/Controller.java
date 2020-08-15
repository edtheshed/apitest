package com.sam.apitest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

  @RequestMapping("/api")
  public String index() {
    return "response";
  }

}