/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.will.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author wjnet
 */
@Entity
@Table(name="estado")
public class Estado implements Serializable{
    @Id
    @SequenceGenerator(name="seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.IDENTITY)
    private Integer id;   
    @Length(max = 50, message = "O Nome não pode ter mais que {max} caracteres")
    @NotBlank (message = "O Nome deve ser informado")
    @NotNull (message = "O Nome não pode ser nulo")
    @Column(name="nome", length = 50, nullable = false)
    private String nome;
    @Length(max = 2, message = "A UF não pode ter mais que {max} caracteres")
    @NotBlank (message = "O UF deve ser informada")
    @NotNull (message = "O UF não pode ser nulo")
    @Column(name="uf", length = 2, nullable = false)
    private String uf;
    @NotNull(message="O País deve ser informado ")
    @ManyToOne
    @JoinColumn(name="pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name="fk_pais")
    private Pais pais;

    public Estado() {
    }

    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
