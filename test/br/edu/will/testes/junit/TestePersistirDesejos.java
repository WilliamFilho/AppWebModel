package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.PessoaFisica;
import br.edu.will.modelo.Produto;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirDesejos {
    
    EntityManager em;
    
    public TestePersistirDesejos() {
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
    public void teste(){
        boolean exception = false;
        try {
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Produto p = em.find(Produto.class, 1);
            pf.getDesejos().add(p);
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
