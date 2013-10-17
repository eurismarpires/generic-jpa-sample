package br.com.wehavescience.genericjpasample.main;

import br.com.wehavescience.genericjpasample.entities.Costumer;
import br.com.wehavescience.genericjpasample.entities.Product;
import br.com.wehavescience.genericjpasample.managers.SimpleEntityManager;
import br.com.wehavescience.genericjpasample.service.CostumerService;
import br.com.wehavescience.genericjpasample.service.ProductService;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class MainClass {
	public static void main(String[] args) {
		String persistenceUnitName = "WeHaveSciencePU";
		
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
		
		/**
		 * THE SERVICE LAYER ENCAPSULATES EVERY BEGIN/COMMIT/ROLLBACK
		 */
		CostumerService costumerService = new CostumerService(simpleEntityManager);
		ProductService productService = new ProductService(simpleEntityManager);
		
		costumerService.save(new Costumer("test", "test"));
		costumerService.save(new Costumer("test", "test"));
		costumerService.save(new Costumer("test", "test"));
		costumerService.save(new Costumer("test", "test"));
		
		for(Costumer c : costumerService.findAll()){
			System.out.println(c.getName());
		}
		
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		
		for(Product p : productService.findAll()){
			System.out.println(p.getName());
		}
		
		/**
		 * ALWAYS NEED TO BE CALLED!
		 */
		simpleEntityManager.close();
	}
}
