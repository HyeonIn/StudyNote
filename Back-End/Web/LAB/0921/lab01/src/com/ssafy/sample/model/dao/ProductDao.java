package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductDao {
	int insert(Product product) throws SQLException;
	int delete(String code) throws SQLException;
	Product selectOne(String code);
	List<Product> selectAll();
	
}
