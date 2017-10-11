package br.edu.will.testes.junit;

import br.edu.will.jpa.EntityManagerUtil;
import br.edu.will.modelo.Compra;
import br.edu.will.modelo.CompraID;
import br.edu.will.modelo.CompraItem;
import br.edu.will.modelo.PessoaJuridica;
import br.edu.will.modelo.Produto;
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
public class TestePersistirCompra {

    EntityManager em;

    public TestePersistirCompra() {
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
            PessoaJuridica pj = em.find(PessoaJuridica.class, 2);
            Compra obj = new Compra();
            CompraID id = new CompraID();
            id.setPessoaJuridica(pj);
            id.setNumeroNota(12345);
            obj.setId(id);
            obj.setData(Calendar.getInstance());
            CompraItem item = new CompraItem();
            item.setProduto(p);
            item.setValorUnitario(p.getPreco());
            item.setQuantidade(5.0);
            item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
            obj.adicionarItem(item);            
            em.getTransaction().begin();
            em.persist(obj);                        
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
