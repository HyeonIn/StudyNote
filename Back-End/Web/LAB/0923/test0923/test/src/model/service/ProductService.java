package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ProductDao;
import model.dto.ProductDTO;

public class ProductService {
private ProductDao mgr = ProductDao.getInstance();
	
	private ProductService() {}
	private static ProductService instance = new ProductService();
	public static ProductService getInstance() {
		return instance;
	}
	
	public List<ProductDTO> selectAll() {
		return mgr.selectAll();
	}
	public ProductDTO selectOne(String pcode) {
		return mgr.selectOne(pcode);
	}
	public boolean insert(ProductDTO product){
		if (mgr.insert(product) == 1) {
			return true;
		}
		return false;
	}
}
