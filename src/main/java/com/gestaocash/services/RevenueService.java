package com.gestaocash.services;

import java.util.List;

import com.gestaocash.model.Revenue;

public interface RevenueService {
  void saveRevenue(Revenue revenue);

  List<Revenue> findAllRevenues();

  Revenue findRevenueById(Long id);
  

  void updateRevenueById(Long id, Revenue updatedRevenue);

  void deleteRevenueById(Long id);
}
