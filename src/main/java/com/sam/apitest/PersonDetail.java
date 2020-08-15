package com.sam.apitest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.Objects;

@JsonSerialize
public class PersonDetail {
  private String name;
  private String address;
  private String postcode;
  private String phone;
  private int creditLimit;
  private LocalDate dateOfBirth;

  public PersonDetail(String name, String address, String postcode, String phone, int creditLimit,
      LocalDate dateOfBirth) {

    this.name = name;
    this.address = address;
    this.postcode = postcode;
    this.phone = phone;
    this.creditLimit = creditLimit;
    this.dateOfBirth = dateOfBirth;
  }

  public PersonDetail() {
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPostcode() {
    return postcode;
  }

  public String getPhone() {
    return phone;
  }

  public int getCreditLimit() {
    return creditLimit;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDetail that = (PersonDetail) o;
    return creditLimit == that.creditLimit &&
        Objects.equals(name, that.name) &&
        Objects.equals(address, that.address) &&
        Objects.equals(postcode, that.postcode) &&
        Objects.equals(phone, that.phone) &&
        Objects.equals(dateOfBirth, that.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, postcode, phone, creditLimit, dateOfBirth);
  }
}
