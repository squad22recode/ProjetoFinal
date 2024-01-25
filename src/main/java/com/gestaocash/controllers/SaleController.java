package com.gestaoCash.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestaoCash.model.Client;
import com.gestaoCash.model.Product;
import com.gestaoCash.model.Sale;
import com.gestaoCash.model.Users;
import com.gestaoCash.repositories.SaleRepository;
import com.gestaoCash.services.ClientService;
import com.gestaoCash.services.ProductService;
import com.gestaoCash.services.SaleService;
import com.gestaoCash.services.UserService;
import com.gestaoCash.utils.DataUserAuth;

import dto.SaleDto;

@Controller
@RequestMapping("/usuario/area-cliente")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private ProductService prodService;
	@Autowired
	private UserService userService;
	@Autowired 
	private ClientService clientService;
	
	private DataUserAuth data = new DataUserAuth();
	
	@PostMapping("/cadastrar-venda")
	public String saveSales(Sale sale) throws JsonProcessingException {
		
		//transformando string em jsonlist
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> jacksonList = objectMapper.readValue(sale.getProdutos(), new TypeReference<List<Product>>(){});
		
		//calcular valor total da venda
		double totalValue = 0;
		double desconto = sale.getDesconto()/100 * totalValue;
		
		for (Product list : jacksonList) {
			//buscar produto pela id que vem através do array
			Product product = prodService.findProductById(list.getId());
			//altera a quantidade do produto no estoque
			product.setQuantidade(product.getQuantidade()- list.getQuantidade());
			//calcula o valor total
			totalValue += list.getCusto()*list.getQuantidade();
			//salva alterações na tabela produto no banco
			prodService.saveProduct(product);
		}
		
	    //seta o valor total
	    sale.setValorTotal(totalValue - desconto);
		saleService.saveSale(sale);
		
		return "redirect:/usuario/area-cliente/empresa";
	}
	
	@GetMapping("/cadastrar-venda")
	public ModelAndView getRegisteSale() {
		ModelAndView view = new ModelAndView("/empresa/add-vendas");
		view.addObject("sale", new Sale());
		Users user = userService.findUserById(data.DataUser().getId());
		
		List<Product> products = prodService.findAllProducts().stream().filter(product-> product.getEmpresa().getIdEmpresa() == user.getEmpresa().getIdEmpresa()).collect(Collectors.toList());
		List<Client> clients = clientService.findAllClient().stream().filter(client-> client.getEmpresa().getIdEmpresa() == user.getEmpresa().getIdEmpresa()).collect(Collectors.toList());
		
		
		view.addObject("product", new Product());
		view.addObject("clients", clients);
		view.addObject("products", products);
		return view;
		
	}
}
