package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Foto;
import br.edu.will.modelo.Produto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirFoto {

    EntityManager em;

    public TestePersistirFoto() {
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
  
            Produto p = em.find(Produto.class, 1);
            Foto f = new Foto();
            f.setNome("monitor_sansung.jpg");
            f.setDescricao("Foto do produto");
            Path path = Paths.get("c:/Users/wjnet/Desktop/monitor_sansung.jpg");
            f.setArquivo(Files.readAllBytes(path));
            p.adicionarFoto(f);         
            em.getTransaction().begin();
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
