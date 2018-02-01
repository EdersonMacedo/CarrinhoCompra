package com.betha.model.service;

import java.util.List;

import com.betha.model.model.CompraModel;

public interface CompraService {
	
	CompraModel salvarCompra(CompraModel compraModel);

	void alterar(CompraModel compraModel);

	void excluir(CompraModel compraModel);

	List<CompraModel> getCompras();
}
