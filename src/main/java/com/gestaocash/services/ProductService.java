package com.gestaoCash.services;

import java.util.List;

import com.gestaoCash.model.Product;

public interface ProductService {
	void saveProduct(Product produto);
	List<Product> findAllProducts();
	Product findProductById(long id);
}
