package com.capgemini.angularproject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@JsonRootName("proInfo")
@Table(name="products")
public class ProductInfo {
	@Id
	@Column
	private int id;
	@Column
	private String productName;
	@Column
	private String imageUrl;
	@Column
	private double price;
	@Column
	private String productDescription;
}
