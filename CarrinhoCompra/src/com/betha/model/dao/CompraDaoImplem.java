package com.betha.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.betha.model.model.CompraModel;

public class CompraDaoImplem implements CompraDao{

	@PersistenceContext(unitName="CarrinhoCompraPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public CompraModel salvarCompra(CompraModel compra) {
		entityManager.persist(compra);
		return compra;
	}

	@Override
	public void alterar(CompraModel compra) {
		CompraModel compraMerge = entityManager.merge(compra);
		entityManager.persist(compraMerge);
		
	}

	@Override
	public void excluir(CompraModel compra) {
		CompraModel compraMerge = entityManager.merge(compra);
		entityManager.remove(compraMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CompraModel> getCompras() {
	    Query query = entityManager.createQuery("from CompraModel");
	    return query.getResultList();
	}

}
