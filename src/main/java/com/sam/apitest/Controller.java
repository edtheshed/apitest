package com.sam.apitest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

  @RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
  @ResponseBody
  public List<PersonDetail> index() {
    List<PersonDetail> result = new ArrayList<>();
    result.add(new PersonDetail("Johnson, John", "Voorstraat 32",
        "3122gg", "020 3849381", 10000, LocalDate.of(1987, 1, 1)));
    return result;
  }

}