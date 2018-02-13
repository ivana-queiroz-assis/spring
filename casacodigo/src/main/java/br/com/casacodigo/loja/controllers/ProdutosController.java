package br.com.casacodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casacodigo.loja.dao.ProdutoDAO;
import br.com.casacodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto.toString());
		produtoDAO.gravar(produto);		
		return "produtos/ok";
	}
	
}
