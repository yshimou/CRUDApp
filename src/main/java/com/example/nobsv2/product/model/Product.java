package com.example.nobsv2.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //maps java class to mySQL
@Data
@Table(name = "product")
public class Product {

  @Id //all tables in mySQL need a primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generates id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private Double price;
}
