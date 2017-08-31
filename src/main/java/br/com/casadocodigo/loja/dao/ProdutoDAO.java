package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        this.manager.persist(produto);
    }

}
