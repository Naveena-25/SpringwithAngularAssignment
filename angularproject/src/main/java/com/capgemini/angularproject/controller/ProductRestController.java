package com.capgemini.angularproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.angularproject.bean.ProductInfo;
import com.capgemini.angularproject.bean.ProductResponse;
import com.capgemini.angularproject.service.ProductServiceImpl;
import com.capgemini.springrest.bean.EmployeeResponse;

@RestController
public class ProductRestController {
	@Autowired
	private ProductServiceImpl service;

	@PostMapping(path="/addProduct",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductResponse addProduct(@RequestBody ProductInfo productInfo) {
		boolean isAdded =  service.createProductInfo(productInfo);
		ProductResponse response = new ProductResponse();
		if(isAdded) {
			response.setMessage("Product Inserted successfully");
		}
		else {
			response.setError(true);
		}
		return response;
	}
	@GetMapping(path="/getAllProducts",produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllEmployees() {
		List<ProductInfo> productList=service.getAllProducts();
		ProductResponse response=new ProductResponse();
		if(productList!=null && !productList.isEmpty()) {
			response.setProductList(productList);
		}else {
			response.setError(true);
			response.setMessage("no record found");
		}
		return response;
	}
	@PutMapping(path="/updateProduct",
			consumes = { MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductResponse updateProduct(@RequestBody ProductInfo ref) {
		boolean isupdated = service.updateProductInfo(ref);		
		ProductResponse response = new ProductResponse();
		if (isupdated) {   
			response.setMessage("Response is updated");
		} else {
			response.setError(true);
			response.setMessage("Record is not updated");
		}
		return response;
	}
	@DeleteMapping(path = "/deleteProduct/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ProductResponse deleteEmployee(@PathVariable(name = "id")  int productId) {
		ProductResponse response = new ProductResponse();
		boolean isDeleted = service.deleteProductInfo(productId);
		if (isDeleted) {
			response.setMessage("record deleted for id" +productId);
		} else {
			response.setError(true);
			response.setMessage("No Records found to delete/unble to delete"+productId);
		}
		return response;
	}//end of delete
}
