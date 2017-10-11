package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Foto;
import java.io.File;
import java.io.FileOutputStream;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteLerFoto {

    EntityManager em;

    public TesteLerFoto() {
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
  
            Foto f = em.find(Foto.class, 1);
            File file = new File("c:/Users/wjnet/Desktop/monitor_sansung.jpg");
            FileOutputStream out = new FileOutputStream(file);
            out.write(f.getArquivo());
            out.close();
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }

}
