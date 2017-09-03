package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        this.manager.persist(produto);
    }

    public List<Produto> listar() {
        return manager.createQuery("select p from Produto p", Produto.class).getResultList();
    }
}
