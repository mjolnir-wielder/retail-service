package com.target.retailservice.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.target.retailservice.dao.RetailServiceDao;
import com.target.retailservice.model.Product;
import com.target.retailservice.util.RetailServiceUtil;

@Service()
public class GetProductById {

	@Autowired
	private RetailServiceDao retailServiceDao;

	@Autowired
	private RestTemplate restTemplate;
	private final static String jsonPathForProductName = "$.product.item.product_description.title";

	public Product execute(String productId) {
		Product fetchedProduct = this.retailServiceDao.fetchProductById(productId);
		fetchedProduct.setName(this.fetchProductName(productId));
		return fetchedProduct;
	}

	private String fetchProductName(String productId) {

		final String url = "https://redsky.target.com/v2/pdp/tcin/{productId}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("productId", productId);
		URI uri = UriComponentsBuilder.fromUriString(url).buildAndExpand(params).toUri();
		String jsonString = this.restTemplate.getForObject(uri, String.class);
		return RetailServiceUtil.getValueByJsonPath(jsonString, jsonPathForProductName);
	}

}
