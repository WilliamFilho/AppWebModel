package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Permissao;
import br.edu.will.modelo.PessoaFisica;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirPermissoesPessoa {
    
    EntityManager em;
    
    public TestePersistirPermissoesPessoa() {
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
            Permissao p1 = em.find(Permissao.class, "Administrador");
            Permissao p2 = em.find(Permissao.class, "Usuario");
            pf.getPermissoes().add(p1);
            pf.getPermissoes().add(p2);
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
