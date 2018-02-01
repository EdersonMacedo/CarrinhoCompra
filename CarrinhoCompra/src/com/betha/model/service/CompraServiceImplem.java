package com.betha.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.betha.model.dao.CompraDao;
import com.betha.model.model.CompraModel;

public class CompraServiceImplem implements CompraService {

	@Inject
	private CompraDao compraDaoInterface;

	@Override
	public List<CompraModel> getCompras() {
		return compraDaoInterface.getCompras();
	}

	@Override
	@Transactional
	public CompraModel salvarCompra(CompraModel compraModel) {
		return compraDaoInterface.salvarCompra(compraModel);
	}

	@Override
	@Transactional
	public void alterar(CompraModel compraModel) {
		compraDaoInterface.alterar(compraModel);
	}

	@Override
	@Transactional
	public void excluir(CompraModel compraModel) {
		compraDaoInterface.excluir(compraModel);
	}

}
