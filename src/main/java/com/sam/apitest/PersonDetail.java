package com.sam.apitest;

import java.time.LocalDate;

public class PersonDetail {

  private final String name;
  private final String address;
  private final String postcode;
  private final String phone;
  private final int creditLimit;
  private final LocalDate dateOfBirth;

  public PersonDetail(String name, String address, String postcode, String phone, int creditLimit,
      LocalDate dateOfBirth) {

    this.name = name;
    this.address = address;
    this.postcode = postcode;
    this.phone = phone;
    this.creditLimit = creditLimit;
    this.dateOfBirth = dateOfBirth;
  }
}
