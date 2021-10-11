package com.fullstackproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fullstackproject.domain.Investment;
import com.fullstackproject.repository.InvestmentRepository;


@Service
public class InvestmentService {
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	@GetMapping
	public List<Investment> findAll(){
		return investmentRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Investment findById(@PathVariable Long id) {
		return investmentRepository.findById(id).orElseThrow(null);
	}
	
	@PostMapping
	public Investment createInvestment(@RequestBody Investment investment) {
		return investmentRepository.save(investment);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		investmentRepository.deleteById(id);
		
	}
	
	@PutMapping(value = "/{id}")
	@SuppressWarnings("deprecation")
	public Investment updateInvestment(@PathVariable Long id, 
			@RequestBody Investment investment) {
		 Investment entityInvestment = investmentRepository.getOne(id);
		 updateData(entityInvestment, investment);
		 return investmentRepository.save(entityInvestment);
	}
	
private void updateData(Investment entityInvestment, Investment investment) {
		
		entityInvestment.setCategory(investment.getCategory());
		entityInvestment.setCoteQuatity(investment.getCoteQuatity());
		entityInvestment.setCoteValue(investment.getCoteValue());
	
	
	}
}
