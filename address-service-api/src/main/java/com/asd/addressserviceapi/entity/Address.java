package com.asd.addressserviceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name="address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String id;
    private String country;
    private String city;
}
