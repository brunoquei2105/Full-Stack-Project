package com.fullstackproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstackproject.domain.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long>{

}
