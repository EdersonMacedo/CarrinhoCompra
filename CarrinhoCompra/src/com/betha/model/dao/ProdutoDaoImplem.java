package com.betha.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.betha.model.model.ProdutoModel;

public class ProdutoDaoImplem implements ProdutoDao{

	@PersistenceContext(unitName="CarrinhoCompraPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public ProdutoModel salvarProduto(ProdutoModel produto) {
		entityManager.persist(produto);
		return produto;
	}

	@Override
	public void alterar(ProdutoModel produto) {
		ProdutoModel produtoMerge = entityManager.merge(produto);
		entityManager.persist(produtoMerge);
		
	}

	@Override
	public void excluir(ProdutoModel produto) {
		ProdutoModel produtoMerge = entityManager.merge(produto);
		entityManager.remove(produtoMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdutoModel> getProdutos() {
	    Query query = entityManager.createQuery("from ProdutoModel");
	    return query.getResultList();
	}

}
