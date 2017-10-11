package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.PessoaFisica;
import br.edu.will.modelo.Produto;
import br.edu.will.modelo.Venda;
import br.edu.will.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirVenda {

    EntityManager em;

    public TestePersistirVenda() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setParcelas(3);
            v.setPessoaFisica(pf);
            VendaItens vi = new VendaItens();
            vi.setProduto(p);
            vi.setQuantidade(5.0);
            vi.setValorUnitario(p.getPreco());
            vi.setValorTotal(vi.getQuantidade()*vi.getValorUnitario());
            v.adicionarItem(vi);     
            em.getTransaction().begin();
            em.persist(v);            
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
