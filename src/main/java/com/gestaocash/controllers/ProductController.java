package com.gestaoCash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestaoCash.model.Company;
import com.gestaoCash.model.Product;
import com.gestaoCash.services.ProductService;
import com.gestaoCash.utils.DataUserAuth;

@Controller
@RequestMapping("/usuario/area-cliente")
public class ProductController {

	@Autowired 
	private ProductService prodService;
	
	DataUserAuth userAuth = new DataUserAuth();
	
	@PostMapping("/cadastrar-produto")
	public String addProduct(@ModelAttribute("product") Product product) {
		
		Company company = userAuth.DataUser().getEmpresa();
		product.setEmpresa(company);
		prodService.saveProduct(product);
		return "redirect:/usuario/area-cliente";
	}
}
