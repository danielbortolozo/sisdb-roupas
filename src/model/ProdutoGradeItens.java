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
    private String valor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto_grade", referencedColumnName = "id",
             foreignKey = @ForeignKey(name="fk_produtoGrade_produtoGradeItens"))
    private ProdutoGrade produtoGrade;
    
}