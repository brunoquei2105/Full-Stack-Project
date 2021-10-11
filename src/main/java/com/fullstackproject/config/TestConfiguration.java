package com.fullstackproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fullstackproject.domain.Category;
import com.fullstackproject.domain.Investment;
import com.fullstackproject.repository.CategoryRepository;
import com.fullstackproject.repository.InvestmentRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
			
		Category c1 = new Category(null, "fundo imobiliário", "BMP22");
		Category c2 = new Category(null,"ação", "ITAU4");
		
		Investment i1 = new Investment(null, "1234", 64.5, 2, Instant.parse("2019-06-20T19:53:07Z"), c1);
		
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		investmentRepository.saveAll(Arrays.asList(i1));
	}
}
