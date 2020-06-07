/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Produto;
import model.ProdutoGrade;
import model.ProdutoGradeItens;

/**
 *
 * @author daniel
 */
public class ProdutoGradeDAO {    
      
    public void salvar(ProdutoGrade produtoGrade){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();          
        manager.persist(produtoGrade); 
        
        for (ProdutoGradeItens pgi : produtoGrade.getListaGradeItens()){
            pgi.setProdutoGrade(produtoGrade);
            manager.persist(pgi);
        }       
        tx.commit();
        manager.close();
    } 
    
    public void alterar (ProdutoGrade produtoGrade){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();       
        manager.merge(produtoGrade);
        for (ProdutoGradeItens pgi : produtoGrade.getListaGradeItens()){
            if (pgi.getId() == null){
               pgi.setProdutoGrade(produtoGrade);
               manager.merge(pgi);                
            } else {               
                ProdutoGradeItens prodGradI =  manager.find(ProdutoGradeItens.class, pgi.getId());
                prodGradI.setAtributo(pgi.getAtributo());
                prodGradI.setEstoque(pgi.getEstoque());
                prodGradI.setEstoqueMinimo(pgi.getEstoqueMinimo());
                manager.merge(prodGradI);
            }               
        }        
        tx.commit();
        manager.close();                       
    }     
}
