package com.giga.repository;

import com.giga.entity.Entry;
import com.giga.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, String> {
}
