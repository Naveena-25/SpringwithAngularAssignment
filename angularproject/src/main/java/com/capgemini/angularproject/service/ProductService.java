package com.capgemini.angularproject.service;

import java.util.List;

import com.capgemini.angularproject.bean.ProductInfo;

public interface ProductService {
	List<ProductInfo> getAllProducts();
	boolean createProductInfo(ProductInfo ref);
	boolean updateProductInfo(ProductInfo ref);
	boolean deleteProductInfo(int id);
}
