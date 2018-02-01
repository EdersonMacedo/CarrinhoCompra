package com.betha.model.dao;

import java.util.List;

import com.betha.model.model.ProdutoModel;

public interface ProdutoDao {

	ProdutoModel salvarProduto(ProdutoModel produto);

	void alterar(ProdutoModel produto);

	void excluir(ProdutoModel produto);

	List<ProdutoModel> getProdutos();

}