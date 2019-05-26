package com.target.retailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.retailservice.model.Product;
import com.target.retailservice.service.GetProductById;
import com.target.retailservice.service.UpdateProductPrice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/retail-service")
@Api(value="retail-service")
public class RetailServiceController {
	
	@Autowired
	private GetProductById getProductById;
	
	@Autowired
	private UpdateProductPrice updateProductPrice;
	
    @GetMapping("/products/{id}")
    @ApiOperation(value = "provides product details corresponding to the id supplied as a path variable", response = Product.class)
	public Product getProductById(@PathVariable("id") String id) {
		return this.getProductById.execute(id);
	}
    
    @PutMapping("/products/{id}")
    @ApiOperation(value = "updates the product price based on the input Product and return the modified record count", response = Long.class)
	public Long updateProductPrice(@PathVariable("id") String id, @RequestBody(required=true) Product product) {
		return this.updateProductPrice.execute(id, product);
	}

}
