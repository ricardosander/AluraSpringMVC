package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        this.manager.persist(produto);
    }

}
