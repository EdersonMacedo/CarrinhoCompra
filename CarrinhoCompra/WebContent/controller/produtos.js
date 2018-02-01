var produtoModulo = angular.module('produtoModulo', []);

produtoModulo.controller("produtosController", function($scope, $http) {
	urlProdutos =  'http://localhost:8080/CarrinhoCompra/api/produtos';
	
	$scope.listarProdutos = function() {
		$http.get(urlProdutos).success(function(produtos) {
			$scope.produtos = produtos;

		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.selecionaProduto = function(produtoSelecionado) {
		$scope.produto = produtoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.produto = "";
		$scope.listarProdutos();
	}

	$scope.salvar = function() {

		if ($scope.produto.precoUnitario == undefined || +$scope.produto.precoUnitario == 0) {
			alert("Favor informar o preço do seu produto");
			return false;
		}
		if ($scope.produto.codigo == undefined) {
			$http.post(urlProdutos, $scope.produto).success(
				function(produto) {
					$scope.limparCampos();
				}).error(function(erro) {
					alert(erro);
				});
		}else {
			$http.put(urlProdutos, $scope.produto).success(
			function(produto) {
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function() {
		if ($scope.produto.codigo == undefined) {
			alert("Favor selecionar um produto a ser excuído");
		} else {
			$http.delete(urlProdutos+'/'+$scope.produto.codigo).success(function (){
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}

	$scope.listarProdutos();
});
