/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Estado;
import br.edu.will.modelo.Pais;
import br.edu.will.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wjnet
 */
public class TestePersistirPessoaFisica {
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("782.107.450-00");
            pf.setEmail("williamfilho20@gmai.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("William Filho");
            pf.setNomeUsuario("Javax");
            pf.setRg("1542224747");
            pf.setSenha("210344");
            pf.setTelefone("99-9885647-57");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        } 
        Assert.assertEquals(false, exception);
    }
    
}
