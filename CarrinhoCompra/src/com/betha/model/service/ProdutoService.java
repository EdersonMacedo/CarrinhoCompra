package com.betha.model.service;

import java.util.List;

import com.betha.model.model.ProdutoModel;

public interface ProdutoService {
	
	ProdutoModel salvarProduto(ProdutoModel produtosModel);

	void alterar(ProdutoModel produtosModel);

	void excluir(ProdutoModel produtosModel);

	List<ProdutoModel> getProdutos();
}
