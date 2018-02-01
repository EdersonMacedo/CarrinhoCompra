var compraModulo = angular.module('compraModulo',[]);

compraModulo.controller("compraController", function($scope, $http) {
	
	//Assumindo que a API e UI estão rodando no mesmo servidor e porta
	urlProduto = 'http://localhost:8080/CarrinhoCompra/api/produtos';
	urlCompra = 'http://localhost:8080/CarrinhoCompra/api/compras';
	
	$scope.compras = [];
	
	$scope.listarCompras = function() {
		$http.get(urlCompra).success(function (compras) {
			$scope.compras = compras;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.listarProdutos = function() {
		$http.get(urlProduto).success(function (produtos) {
			$scope.produtos = produtos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionaCompra = function(compraSelecionado) {
		$scope.compra = compraSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.compra = "";
	}
	
	$scope.salvar = function() {
		var quantidade = $scope.compra.quantidade;
		if (($scope.compra.quantidade == undefined) || (+quantidade == 0)) {
			alert("Favor informar a quantidade.");
			return false;
		}
		
		if ($scope.compra.codigo == undefined) {
		   $http.post(urlCompra,$scope.compra).success(function(compra) {
		        $scope.limparCampos();
		        $scope.listarCompras();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			  $http.put(urlCompra,$scope.compra).success(function(compra) {
				  $scope.listarCompras();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	$scope.excluir = function() {
		if ($scope.compra.codigo == undefined) {
			alert("Favor selecionar um registro para poder excluir");
			console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlCompra+'/'+$scope.compra.codigo).success(function () {
				 $scope.listarCompras();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	$scope.calcularTotalItem = function(item){
		return item.quantidade * item.produto.precoUnitario;
	}
	
	$scope.calcularTotal = function(){
		var compras = $scope.compras;
		var total = 0;
		for(var i = 0; i < compras.length; i++ ){
			total += $scope.calcularTotalItem(compras[i]);		
		}
		return total.toFixed(2);
	}
	
	$scope.listarCompras();
	$scope.listarProdutos();
	
	
});





