package com.capgemini.angularproject.dao;

import java.util.List;

import com.capgemini.angularproject.bean.ProductInfo;

public interface ProductDAO {
	List<ProductInfo> getAllProducts();
	boolean createProductInfo(ProductInfo ref);
	boolean updateProductInfo(ProductInfo ref);
	boolean deleteProductInfo(int id);
}
