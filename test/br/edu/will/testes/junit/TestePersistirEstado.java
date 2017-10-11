/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Estado;
import br.edu.will.modelo.Pais;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wjnet
 */
public class TestePersistirEstado {
    EntityManager em;
    
    public TestePersistirEstado() {
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
            Estado e = new Estado();
            e.setNome("Maranhão");
            e.setUf("MA");
            e.setPais(em.find(Pais.class, 2));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        } 
        Assert.assertEquals(false, exception);
    }
    
}
