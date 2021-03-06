package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteListarCidade {

    EntityManager em;

    public TesteListarCidade() {
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
            String jpql = "from Cidade order by nome";
            List<Cidade> lista = em.createQuery(jpql).getResultList();
            for (Cidade c : lista){
                System.out.println("ID: "+c.getId()+ " Nome: "+c.getNome() + " Estado: "+c.getEstado().getNome());
            }
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }

}
