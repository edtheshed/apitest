package com.sam.apitest;

import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.parsing.Parser;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = ApitestApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationShould {

  @LocalServerPort
  int serverPort;

  @BeforeEach
  void setUp() {
    RestAssured.port = serverPort;
    RestAssured.defaultParser = Parser.JSON;
  }

  @Test
  void respond_with_a_structure_of_the_data_when_sent_a_single_record() throws JSONException {
    var csvList = "Name,Address,Postcode,Phone,Credit Limit,Birthday\n"
        + "\"Johnson, John\",Voorstraat 32,3122gg,020 3849381,10000,01/01/1987";
    JSONObject request = new JSONObject();
    request.put("file", csvList);

    PersonDetail personDetail = new PersonDetail("Johnson, John", "Voorstraat 32",
        "3122gg", "020 3849381", 10000, LocalDate.of(1987, 1, 1));
    var personDetails = Collections.singletonList(personDetail);

    var results = RestAssured.given()
        .contentType("application/json")
        .body(request.toString())
        .header(new Header("input-type", "csv"))
        .header(new Header("output-type", "json"))
        .post("/api")
        .then()
        .extract()
        .as(PersonDetail[].class);

    assertThat(results).isEqualTo(personDetails.toArray());
  }

}
