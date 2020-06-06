/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */

@Entity
@Table(name = "produto_grade")
public class ProdutoGrade {
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
     
    private String cor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto", referencedColumnName = "id", 
            foreignKey = @ForeignKey(name="fk_produto_produtoGrade"))     
    private Produto produto;
    
    @OneToMany(mappedBy = "produtoGrade", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<ProdutoGradeItens> listaGradeItens;
    

    public ProdutoGrade() {
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

   

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<ProdutoGradeItens> getListaGradeItens() {
        return listaGradeItens;
    }

    public void setListaGradeItens(List<ProdutoGradeItens> listaGradeItens) {
        this.listaGradeItens = listaGradeItens;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final ProdutoGrade other = (ProdutoGrade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}
