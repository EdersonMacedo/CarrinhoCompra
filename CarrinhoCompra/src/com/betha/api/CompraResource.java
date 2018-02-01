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

import com.betha.model.model.CompraModel;
import com.betha.model.service.CompraService;



@Path("/compras")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CompraResource {

	@Inject
	private CompraService compraServiceInterface;
	
	@GET
	public List<CompraModel> getCompras() {
		return compraServiceInterface.getCompras();
	}
	
	@POST
	public CompraModel salvar(CompraModel compraModel) {
		return compraServiceInterface.salvarCompra(compraModel);
	}
	
	@PUT
	public void atualizar(CompraModel compraModel) {
		compraServiceInterface.alterar(compraModel);
	}
	
	@DELETE
	@Path("/{codigoCompra}")
	public void excluir(@PathParam("codigoCompra") Integer codigoCompra) {
		CompraModel compraModel = new CompraModel();
		compraModel.setCodigo(codigoCompra);
		compraServiceInterface.excluir(compraModel);
	}
}