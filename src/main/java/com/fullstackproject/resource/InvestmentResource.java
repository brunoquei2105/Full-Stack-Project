package com.fullstackproject.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fullstackproject.domain.Investment;
import com.fullstackproject.service.InvestmentService;

@RestController
@RequestMapping(value = "/investment")
public class InvestmentResource {
	
	@Autowired
	private InvestmentService investmentService;
	
	@GetMapping
	public ResponseEntity<List<Investment>> getAll(){
		List<Investment> investments = investmentService.findAll();
		return ResponseEntity.ok().body(investments);
	}
	
	@GetMapping(value = "/id")
	public ResponseEntity<Investment> getById(@PathVariable Long id){
		Investment investment = investmentService.findById(id);
		return ResponseEntity.ok().body(investment);
	}
	
	@DeleteMapping(value = "/id")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		investmentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Investment> postInvestment(@RequestBody Investment investment){
			investment = investmentService.createInvestment(investment);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(investment.getCode()).toUri();
			return ResponseEntity.created(uri).body(investment);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Investment> putInvestmentById(@PathVariable Long id, 
			@RequestBody Investment investment){
		investment = investmentService.updateInvestment(id, investment);
		return ResponseEntity.ok().body(investment);
	}
	
	
	

}
