package com.gestaoCash.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestaoCash.model.AddressCompany;
import com.gestaoCash.model.Client;
import com.gestaoCash.model.Company;
import com.gestaoCash.model.Product;
import com.gestaoCash.model.Sale;
import com.gestaoCash.model.Users;
import com.gestaoCash.services.ClientService;
import com.gestaoCash.services.CompanyService;
import com.gestaoCash.services.UserService;
import com.gestaoCash.utils.DataUserAuth;

@Controller
@RequestMapping("usuario/area-cliente")
public class CompanyController {
	
	@Autowired
	private CompanyService compService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClientService clientService;
	
	DataUserAuth data = new DataUserAuth();
	
	@GetMapping("/empresa")
	public ModelAndView getAllCompany() {
		ModelAndView view = new ModelAndView("/empresa/empresa");
		Long id = data.DataUser().getId();
		Users user = userService.findUserById(id);
		List<Client> clients = clientService.findAllClient().stream().filter(client-> client.getEmpresa().getIdEmpresa() == user.getEmpresa().getIdEmpresa()).collect(Collectors.toList());
		if (user.getEmpresa() != null) {
			view.addObject("companyEdit", user.getEmpresa());
		}
		
		view.addObject("product", new Product());
		view.addObject("clients", clients);
		view.addObject("user", user);
		view.addObject("client", new Client());
		view.addObject("company", new Company());
		return view;
	}
	
	
	@PostMapping("/cadastrar-empresa")
	public String registerCompany(@ModelAttribute("company") Company company) {

		long id = data.DataUser().getId();
		Users usuario = userService.findUserById(id);
		
		company.setUsuario(usuario);
		
		usuario.setEmpresa(compService.saveCompany(company));
		userService.saveUser(usuario);
		
		
		return "redirect:/usuario/area-cliente";
	}
	
	@PostMapping("/editar-empresa")
	public String editCompany(@ModelAttribute("company") Company company) {
		
		long id = data.DataUser().getId();
		Users usuario = userService.findUserById(id);
		compService.findCompanyById(usuario.getEmpresa().getIdEmpresa());
		company.setIdEmpresa(usuario.getEmpresa().getIdEmpresa());
		company.setUsuario(usuario);

		compService.saveCompany(company);
		userService.saveUser(usuario);
		return "redirect:/usuario/area-cliente";
	}

}
