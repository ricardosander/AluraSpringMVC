package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/form")
    public ModelAndView form() {

        ModelAndView modelAndView = new ModelAndView("produtos/form");

        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String gravar(Produto produto) {

        this.produtoDAO.gravar(produto);

        return "produtos/ok";
    }

}
