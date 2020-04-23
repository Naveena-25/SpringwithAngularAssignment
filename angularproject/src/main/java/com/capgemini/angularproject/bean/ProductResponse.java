package com.capgemini.angularproject.bean;

import java.util.List;

import lombok.Data;
@Data
public class ProductResponse {
	private boolean error;
	private String message;
	private ProductInfo productInfo;
	private List<ProductInfo> productList;
}
