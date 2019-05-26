package com.target.retailservice.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.target.retailservice.model.Product;

@Repository()
public class RetailServiceDao {

	private MongoDatabase database;

	public RetailServiceDao() {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		this.database = new MongoClient("localhost", 27017).getDatabase("mydb").withCodecRegistry(pojoCodecRegistry);
	}

	public Product fetchProductById(String id) {
		MongoCollection<Product> collection = database.getCollection("Product", Product.class);
		Product product = collection.find(eq("productId", id)).first();
		return product;
	}

	public Long updateProductPrice(String productId, Product product) {
		MongoCollection<Product> collection = database.getCollection("Product", Product.class);
		return collection.updateOne(eq("productId", productId), set("price.value", product.getPrice().getValue()))
				.getModifiedCount();
	}
}
