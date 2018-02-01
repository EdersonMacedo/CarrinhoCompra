package com.betha.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.betha.model.dao.ProdutoDao;
import com.betha.model.model.ProdutoModel;

public class ProdutoServiceImplem implements ProdutoService {

	@Inject
	private ProdutoDao professorDaoInterface;

	@Override
	public List<ProdutoModel> getProdutos() {
		return professorDaoInterface.getProdutos();
	}

	@Override
	@Transactional
	public ProdutoModel salvarProduto(ProdutoModel professorModel) {
		return professorDaoInterface.salvarProduto(professorModel);
	}

	@Override
	@Transactional
	public void alterar(ProdutoModel professorModel) {
		professorDaoInterface.alterar(professorModel);
	}

	@Override
	@Transactional
	public void excluir(ProdutoModel professorModel) {
		professorDaoInterface.excluir(professorModel);
	}

}
