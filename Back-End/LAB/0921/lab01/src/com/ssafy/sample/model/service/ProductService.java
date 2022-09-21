package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductService {
	private ProductDaoImpl mgr = new ProductDaoImpl();
	private ProductService() {}
	private static ProductService instance = new ProductService();
	
	public static ProductService getInstance() {
		return instance;
	}
	
	public boolean insert(Product product) throws SQLException{
		if (mgr.insert(product) == 1) {
			return true;
		}
		return false;
	}
	public boolean deleteProduct(String code) throws SQLException {
		if (mgr.delete(code) == 1) {
			return true;
		}
		return false;
	}
	public List<Product> selectAll() {
		return mgr.selectAll();
	}
	public Product selectOne(String code) {
		return mgr.selectOne(code);
	}
	
}
