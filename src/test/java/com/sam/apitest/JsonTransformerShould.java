package com.sam.apitest;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class JsonTransformerShould {

  @Test
  void return_a_json_object_when_given_a_csv_string() {
    var jsonTransformer = new JsonTransformer();

    PersonDetail personDetail = new PersonDetail("Johnson, John", "Voorstraat 32",
        "3122gg", "020 3849381", 10000, LocalDate.of(1987, 1, 1));
    var personDetails = Collections.singletonList(personDetail);
    Gson gson = new Gson();
    String json = gson.toJson(personDetails);

    assertThat(json).isEqualTo(jsonTransformer.transformData("Name,Address,Postcode,Phone,Credit Limit,Birthday\n"
        + "\"Johnson, John\",Voorstraat 32,3122gg,020 3849381,10000,01/01/1987"));
  }
}