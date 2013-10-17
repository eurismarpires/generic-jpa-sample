package br.com.wehavescience.genericjpasample.dao;

import javax.persistence.EntityManager;

import br.com.wehavescience.genericjpasample.entities.Product;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class ProductDAO extends GenericDAO<Long, Product> {
	public ProductDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
