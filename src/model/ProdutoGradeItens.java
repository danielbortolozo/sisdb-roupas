/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "produto_grade_itens")
public class ProdutoGradeItens {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String atributo;
    private float estoque;
    private float estoqueMinimo;
   
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto_grade", referencedColumnName = "id",
             foreignKey = @ForeignKey(name="fk_produtoGrade_produtoGradeItens"))
    private ProdutoGrade produtoGrade;

    public ProdutoGradeItens(String atributo, float estoque, float estoqueMinimo, Long id) {
        this.atributo = atributo;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.id = id;
    }

    public ProdutoGradeItens() {
    }

       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public float getEstoque() {
        return estoque;
    }

    public void setEstoque(float estoque) {
        this.estoque = estoque;
    }

    public ProdutoGrade getProdutoGrade() {
        return produtoGrade;
    }

    public void setProdutoGrade(ProdutoGrade produtoGrade) {
        this.produtoGrade = produtoGrade;
    }

    public float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(float estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    
        
}
