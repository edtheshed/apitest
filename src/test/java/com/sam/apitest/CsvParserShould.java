package com.sam.apitest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class CsvParserShould {

  @Test
  void return_a_list_of_person_details_when_given_a_string() {
    PersonDetail personDetail = new PersonDetail("Johnson, John", "Voorstraat 32",
        "3122gg", "020 3849381", 10000, LocalDate.of(1987, 1, 1));
    assertThat(CsvParser.parse("Name,Address,Postcode,Phone,Credit Limit,Birthday\n"
        + "\"Johnson, John\",Voorstraat 32,3122gg,020 3849381,10000,01/01/1987"))
        .isEqualTo(Collections.singletonList(personDetail));
  }
}