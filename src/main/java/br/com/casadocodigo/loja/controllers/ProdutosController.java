package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

        this.produtoDAO.gravar(produto);

        return "produtos/ok";
    }

}
