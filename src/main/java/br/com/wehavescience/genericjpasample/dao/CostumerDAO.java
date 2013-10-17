package br.com.wehavescience.genericjpasample.dao;

import javax.persistence.EntityManager;

import br.com.wehavescience.genericjpasample.entities.Costumer;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class CostumerDAO extends GenericDAO<Long, Costumer> {
	public CostumerDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
