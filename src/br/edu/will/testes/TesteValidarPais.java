/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.will.testes;

import br.edu.will.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author wjnet
 */
public class TesteValidarPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppWebModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        p.setNome("Uruguai");
        p.setIso("URU");
        em.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validator.validate(p);
        if (erros.size() > 0) {
            for (ConstraintViolation<Pais> erro : erros) {
                System.out.println("Erro " + erro.getMessage());
            }
        } else {
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();

        emf.close();
    }
}
