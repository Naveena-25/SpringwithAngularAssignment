package com.capgemini.angularproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.angularproject.bean.ProductInfo;
import com.capgemini.angularproject.dao.ProductDAO;
@Service
public class ProductServiceImpl implements ProductDAO{
	@Autowired
	private ProductDAO dao;
	@Override
	public List<ProductInfo> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public boolean createProductInfo(ProductInfo ref) {
	
		return dao.createProductInfo(ref);
	}

	@Override
	public boolean updateProductInfo(ProductInfo ref) {

		return dao.updateProductInfo(ref);
	}

	@Override
	public boolean deleteProductInfo(int id) {
		return dao.deleteProductInfo(id);
	}

}
