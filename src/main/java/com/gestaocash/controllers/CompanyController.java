package com.gestaoCash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestaoCash.model.AddressCompany;
import com.gestaoCash.model.Company;
import com.gestaoCash.model.Users;
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
	
	DataUserAuth data = new DataUserAuth();
	
	@PostMapping("/cadastrar-empresa")
	public String registerCompany(@ModelAttribute("company") Company company) {

		long id = data.DataUser().getId();
		Users usuario = userService.findUserById(id);
		
		company.setUsuario(usuario);
		
		usuario.setEmpresa(compService.saveCompany(company));
		userService.saveUser(usuario);
		
		
		return "redirect:/usuario/area-cliente";
	}

}
