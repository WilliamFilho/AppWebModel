package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Permissao;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirPermissao {

    EntityManager em;

    public TestePersistirPermissao() {
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
            Permissao p1 = new Permissao();
            p1.setNome("Administrador");
            p1.setDescricao("Administrador do sistema");
            Permissao p2 = new Permissao();
            p2.setNome("Usuario");
            p2.setDescricao("Usuarios do sistema");
            em.getTransaction().begin();
            em.persist(p1);            
            em.persist(p2);
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
