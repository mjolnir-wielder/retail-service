package com.target.retailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.retailservice.dao.RetailServiceDao;
import com.target.retailservice.model.Product;

@Service()
public class UpdateProductPrice {
	
	@Autowired
	private RetailServiceDao retailServiceDao;
	
	public Long execute(String productId, Product product) {
		return this.retailServiceDao.updateProductPrice(productId, product);
	}

}
