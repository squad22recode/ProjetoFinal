package com.gestaoCash.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoCash.model.Sale;
import com.gestaoCash.repositories.SaleRepository;
import com.gestaoCash.services.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
private SaleRepository saleRepo;
	
	
	@Override
	public void saveSale(Sale sale) {
		// TODO Auto-generated method stub
		saleRepo.save(sale);
	}

}
