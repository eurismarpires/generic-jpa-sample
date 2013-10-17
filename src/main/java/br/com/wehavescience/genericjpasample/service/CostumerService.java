package br.com.wehavescience.genericjpasample.service;

import java.util.List;

import br.com.wehavescience.genericjpasample.dao.CostumerDAO;
import br.com.wehavescience.genericjpasample.entities.Costumer;
import br.com.wehavescience.genericjpasample.managers.SimpleEntityManager;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class CostumerService {
	private CostumerDAO dao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public CostumerService(SimpleEntityManager simpleEntityManager){
		this.simpleEntityManager = simpleEntityManager;
		dao = new CostumerDAO(simpleEntityManager.getEntityManager());
	}
	
	public void save(Costumer costumer){
		try{
			simpleEntityManager.beginTransaction();
			costumer.validate();
			dao.save(costumer);
			simpleEntityManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public List<Costumer> findAll(){
		return dao.findAll();
	}
}
