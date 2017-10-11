package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Cidade;
import br.edu.will.modelo.Endereco;
import br.edu.will.modelo.PessoaFisica;
import br.edu.will.modelo.TipoEndereco;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirEndereco {
    
    EntityManager em;
    
    public TestePersistirEndereco() {
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
            Endereco e = new Endereco();
            e.setBairro("Centro");
            e.setCep("99876-987");
            e.setComplemento("AP 405");
            e.setEndereco("Rua xxxx");
            e.setNickname("Casa");
            e.setNumero("459");
            e.setReferencia("Perto mercado");
            e.setTipoEndereco(em.find(TipoEndereco.class, 1));
            e.setCidade(em.find(Cidade.class, 1));
            pf.adicionarEndereco(e);
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
