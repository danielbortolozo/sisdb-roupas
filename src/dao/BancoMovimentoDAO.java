/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;


import model.BancoMovimento;

/**
 *
 * @author root
 */
public class BancoMovimentoDAO {
    EntityManager manager;
    public void salvar(BancoMovimento bancoMov){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();        
        manager.merge(bancoMov);        
        tx.commit();
        manager.close();
               
    }
    
    public void excluir(BancoMovimento bancoMov){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
            
        BancoMovimento b = manager.find(BancoMovimento.class, bancoMov.getId());
        
        manager.remove(b);
        
        tx.commit();
        manager.close();        
    }
    public BancoMovimento bancoMovimento(int idBanco){
        EntityManager manager = JPAUtil.getEntityManager();        
        Query query = null;
        float saldo = 0;
         BancoMovimento bm = new BancoMovimento();
         try{
           query = manager.createQuery("Select bm.saldo FROM BancoMovimento bm where bm.idBanco = :idBanco and ");  
	   query.setParameter("idBanco", idBanco);     
	   
          
           bm = (BancoMovimento) query.getSingleResult();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao executar o sql! Error:"+ex.getMessage());
        }   
	return bm;        
        
    }
    
     public List<BancoMovimento> listaPorPeriodoMovimentoConta(Date dtIni, Date dtFim, Long idBanco) {
        manager = JPAUtil.getEntityManager();
        String jpql = "SELECT bm FROM BancoMovimento bm WHERE bm.dtLancamento BETWEEN :dtIni AND :dtFim AND bm.idBanco = :idBanco";
        return this.manager.createQuery(jpql, BancoMovimento.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .setParameter("idBanco", idBanco)        
        .getResultList();
    }
    
    
//     public Collection<VendaCab> listVendaReceberDia(Date vencimento){  
//        EntityManager manager = JPAUtil.getEntityManager();        
//        Query query = null;
//        try{
//           query = manager.createQuery("Select v FROM VendaCab v where v.vencimento = :vencimento and v.status='ABERTO' ");  
//	   query.setParameter("vencimento", vencimento);     
//	   
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "Erro ao executar o sql! Error:"+ex.getMessage());
//        }   
//	return query.getResultList();  
//    }
    
    
    
}
