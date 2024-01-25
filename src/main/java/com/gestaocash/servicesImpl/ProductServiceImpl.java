package com.gestaoCash.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoCash.model.Product;
import com.gestaoCash.repositories.ProductRepository;
import com.gestaoCash.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	@Override
	public void saveProduct(Product produto) {
		prodRepo.save(produto);
	}

	@Override
	public List<Product> findAllProducts() {

		return prodRepo.findAll();

	}

	@Override
	public Product findProductById(long id) {
		
		Product product = prodRepo.findById(id).get(); 
		return product;
	}

}
