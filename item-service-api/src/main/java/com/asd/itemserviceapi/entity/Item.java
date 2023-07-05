package com.asd.itemserviceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="item")
@Entity
public class Item {
    @Id
    private String id;
    private String description;
    private double unitPrice;
    private int qty;
}
