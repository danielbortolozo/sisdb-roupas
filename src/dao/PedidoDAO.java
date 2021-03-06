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
//import javax.transaction.Transactional;
import model.Pedido;
import model.PedidoItens;
import model.Pessoa;

/**
 *
 * @author daniel
 */
public class PedidoDAO {
    EntityManager manager;
    
    public Pedido salvar(Pedido p){
        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(p);
            for (PedidoItens itens : p.getListaItens()) {
                itens.setPedido(p);
                manager.persist(itens);                
            }            
            manager.flush();
            tx.commit();   
             
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Pedido. Error:" + ex.getMessage());
        } finally {
            
            manager.close();
        }
        return p;
        
    }
    
    public void alterar(Pedido p){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(p);
            for (PedidoItens itens : p.getListaItens()){
                itens.setPedido(p);
                manager.merge(itens);
            }
           
           
            tx.commit();  
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Gravar Pedido. Error:" + ex.getMessage());
        } finally {
            
            manager.close();
        }
    }
    
    public void remover(Pedido pedido){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            
            Pedido p = manager.find(Pedido.class, pedido.getId());
            manager.remove(p);            
            tx.commit();  
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Excluir Pedido. Error:" + ex.getMessage());
        } finally {
            manager.close();
        }
    }
     public void removerItens(PedidoItens pItens){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            
            PedidoItens p = manager.find(PedidoItens.class, pItens.getId());
            manager.remove(p);            
            tx.commit();  
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Excluir Itens do Pedido. Error:" + ex.getMessage());
        } finally {
            manager.close();
        } 
    }
    
    public List<Pedido> listaPedidoFiadoTodos(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<Pedido> pedidos = manager.createQuery("from Pedido where status = 'FIADO' order by dtCad", Pedido.class).getResultList();
        manager.close();
        return pedidos;
    }
    public List<Pedido> listaPedidoCrediarioTodos(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<Pedido> pedidos = manager.createQuery("from Pedido where status = 'CREDIARIO' order by dtCad", Pedido.class).getResultList();
        manager.close();
        return pedidos;
    }
    
    
    
    
    public List<Pedido> listaPedidoDelivery(){
        EntityManager manager = JPAUtil.getEntityManager();
        //EntityTransaction tx = manager.getTransaction();
       // tx.begin();
        List<Pedido> pedidos = manager.createQuery("from Pedido where status = 'EM ANDAMENTO' OR status = 'PRONTO P/ ENTREGA'"
                + " OR status = 'SAIU P/ ENTREGA'  order by dtCad", Pedido.class).getResultList();
        manager.close();
        return pedidos;
    }
    
       
    public Pedido pedidoID(int id){        
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Pedido pedido = manager.find(Pedido.class, id);
        
        manager.close();
        return pedido;            
    }
    
    
    public Pedido pedidoId(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        
        try{
        Query query = manager.createQuery(
                        "from Pedido where id = :id ");
        query.setParameter("id", id);
        return (Pedido) query.getSingleResult(); 
        }catch (Exception e){
           return null;  
         }
        
    }
    
       
    public List<Pedido> listaPedidoFiadoPorCliente(Pessoa cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from Pedido where status = 'FIADO' and cliente = :cliente");
          query.setParameter("cliente", cliente);
          
          //List veiculos = query.getResultList();
         return query.getResultList();        
    }
    public List<Pedido> listaPedidoCrediarioPorCliente(Pessoa cliente){
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery(
                        "from Pedido where status = 'CREDIARIO' and cliente = :cliente");
          query.setParameter("cliente", cliente);
          
          //List veiculos = query.getResultList();
         return query.getResultList();        
    }
    
        
    public List<Pedido> listaPedidoAVistaPorPeriodo(Date dtIni, Date dtFim) {
        EntityManager manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim AND c.tipoVenda = 'A VISTA'";
        return manager.createQuery(jpql, Pedido.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    } 
    public List<Pedido> listaPedidoAPrazoPorPeriodo(Date dtIni, Date dtFim) {
        EntityManager manager = JPAUtil.getEntityManager();
        System.out.println("vou fazer a pesquisa");
        String jpql = "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim AND c.tipoVenda <> 'A VISTA'";
        return manager.createQuery(jpql, Pedido.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    } 
    
    public List<Pedido> listaPedidoTodosPorPeriodo(Date dtIni, Date dtFim){
        
        EntityManager manager = JPAUtil.getEntityManager();
        System.out.println("vou fazer a pesquisa");
        String jpql = "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim ";
        return manager.createQuery(jpql, Pedido.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
        
        
    }
    
    public List<Pedido> listaPedidoAPrazoPorPeriodoQ(Date dtIni, Date dtFim){
        
        manager = JPAUtil.getEntityManager();
        
        Query query = manager.createQuery(
                        "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim AND c.tipoVenda <> 'A VISTA'");
        query.setParameter("dtIni", dtIni);
        query.setParameter("dtFim", dtFim);
        manager.clear(); 
       // manager.flush();
        return query.getResultList();        
    }
    
     public List<Pedido> listaPedidoAVistaPorPeriodoQ(Date dtIni, Date dtFim){
       
        manager = JPAUtil.getEntityManager(); 
        
        Query query = manager.createQuery(
                        "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim AND c.tipoVenda = 'A VISTA'");
        query.setParameter("dtIni", dtIni);
        query.setParameter("dtFim", dtFim); 
        
        manager.clear();  
       // manager.flush();
        return query.getResultList();   
        
        
    }
    
    
    
    
    
    public List<Pedido> listaTodosPedidoPorPeriodo(Date dtIni, Date dtFim) {
        EntityManager manager = JPAUtil.getEntityManager();
        String jpql = "SELECT c FROM Pedido c WHERE c.dtCad BETWEEN :dtIni AND :dtFim order by c.dtCad";
        return manager.createQuery(jpql, Pedido.class)
        .setParameter("dtIni", dtIni)
        .setParameter("dtFim", dtFim)
        .getResultList();
    } 
    
    public List<PedidoItens> listarItensPedidoPorPeriodo(Date dtIni, Date dtFim, String categoria) {
        List<PedidoItens> pedidosItens = null;
        try {
            manager = JPAUtil.getEntityManager();
            Query query = manager.createQuery(
                    "Select p from PedidoItens p where p.pedido.dtCad BETWEEN :dtIni AND :dtFim AND"
                            + " p.produto.categoria.descricao = :categoria order by p.produto.categoria.descricao");
            query.setParameter("dtIni", dtIni);
            query.setParameter("dtFim", dtFim);
            query.setParameter("categoria", categoria);
            pedidosItens = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return pedidosItens;
    }
        
}
