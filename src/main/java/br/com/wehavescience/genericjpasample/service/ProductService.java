package br.com.wehavescience.genericjpasample.service;

import java.util.List;

import br.com.wehavescience.genericjpasample.dao.ProductDAO;
import br.com.wehavescience.genericjpasample.entities.Product;
import br.com.wehavescience.genericjpasample.managers.SimpleEntityManager;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class ProductService {
	private ProductDAO dao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public ProductService(SimpleEntityManager simpleEntityManager){
		this.simpleEntityManager = simpleEntityManager;
		dao = new ProductDAO(simpleEntityManager.getEntityManager());
	}
	
	public void save(Product product){
		try{
			simpleEntityManager.beginTransaction();
			product.validate();
			dao.save(product);
			simpleEntityManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public List<Product> findAll(){
		return dao.findAll();
	}
}
