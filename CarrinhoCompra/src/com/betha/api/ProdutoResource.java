package com.betha.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.betha.model.model.ProdutoModel;
import com.betha.model.service.ProdutoService;



@Path("/produtos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@Inject
	private ProdutoService service;
	
	@GET
	public List<ProdutoModel> getProdutoes() {
		return service.getProdutos();
	}
	
	@POST
	public ProdutoModel salvar(ProdutoModel produtoModel) {
		return service.salvarProduto(produtoModel);
	}
	
	@PUT
	public void atualizar(ProdutoModel produtoModel) {
		service.alterar(produtoModel);
	}
	
	@DELETE
	@Path("/{codigoProduto}")
	public void excluir(@PathParam("codigoProduto") Integer codigoProduto) {
		ProdutoModel produtoModel = new ProdutoModel();
		produtoModel.setCodigo(codigoProduto);
		service.excluir(produtoModel);
	}
}