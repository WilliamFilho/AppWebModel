package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Categoria;
import br.edu.will.modelo.Marca;
import br.edu.will.modelo.Produto;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirProduto {

    EntityManager em;

    public TestePersistirProduto() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
            Categoria c = new Categoria();
            c.setNome("Eletrônicos");
            Marca m = new Marca();
            m.setNome("Samsung");
            Produto p = new Produto();
            p.setNome("Monitor Samsung 23");
            p.setCategoria(c);
            p.setMarca(m);
            p.setDescricao("blablabla");
            p.setPreco(400.00);
            p.setQuantidadeEstoque(20.0);
            em.getTransaction().begin();
            em.persist(c);
            em.persist(m);
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }

}
