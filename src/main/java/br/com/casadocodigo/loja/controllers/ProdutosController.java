package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {

        this.produtoDAO.gravar(produto);

        redirectAttributes.addFlashAttribute("sucesso", "Produto adicionado com sucesso");

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {

        ModelAndView modelAndView = new ModelAndView("produtos/lista");

        List<Produto> produtos = produtoDAO.listar();
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }

}
