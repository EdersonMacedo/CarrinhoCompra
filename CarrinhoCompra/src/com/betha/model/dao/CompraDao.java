package com.betha.model.dao;

import java.util.List;

import com.betha.model.model.CompraModel;

public interface CompraDao {
	
	CompraModel salvarCompra(CompraModel compra);

	void alterar(CompraModel compra);

	void excluir(CompraModel compra);

	List<CompraModel> getCompras();

}