package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ProdutoValidation());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/form")
    public ModelAndView form() {

        ModelAndView modelAndView = new ModelAndView("produtos/form");

        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return this.form();
        }

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
