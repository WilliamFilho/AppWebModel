package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.TipoEndereco;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirTipoEndereco {

    EntityManager em;

    public TestePersistirTipoEndereco() {
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
            TipoEndereco te1 = new TipoEndereco();
            te1.setDescricao("Residencial");
            TipoEndereco te2 = new TipoEndereco();
            te2.setDescricao("Trabalho");
            em.getTransaction().begin();
            em.persist(te1);            
            em.persist(te2);            
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
