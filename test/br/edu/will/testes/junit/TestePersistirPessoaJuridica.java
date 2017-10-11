package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.PessoaJuridica;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirPessoaJuridica {
    
    EntityManager em;
    
    public TestePersistirPessoaJuridica() {
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
            PessoaJuridica pj = new PessoaJuridica();       
            pj.setEmail("williamfilho20@gmail.com");            
            pj.setNome("Francisco William Saraiva");            
            pj.setTelefone("(99)98856-4757");
            pj.setCnpj("07.182.220/0001-22");
            pj.setIe("123456789012345");
            em.getTransaction().begin();
            em.persist(pj);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
