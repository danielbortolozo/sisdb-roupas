/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.resumo;

import dao.CaixaItensDAO;
import dao.EmpresaDAO;
import dao.PedidoDAO;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CaixaItens;
import model.Empresa;
import model.Pedido;
import model.PedidoItens;
import model.PedidoPagamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author daniel
 */
public class ResumoVendaView extends javax.swing.JFrame {

    
   
   // GregorianCalendar gc = new GregorianCalendar();
    public static Date dtInicial;
    public static Date dtFinal;
    PedidoDAO pDao = new PedidoDAO();;
    List<Pedido> listaAVista = new ArrayList<Pedido>();
    List<Pedido> listaAPrazo = new ArrayList<Pedido>();
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    CaixaItensDAO caixaItDao = new CaixaItensDAO();
    List<CaixaItens> listaCaixaItens = new ArrayList<>();
    JasperPrint  jp;
    public ResumoVendaView() throws ParseException {
        this.jp = null;
        initComponents();
        inicial();
        jbtAtualizarActionPerformed(null);        
    }
    
    
    private void inicial() throws ParseException{
        
       // Pedido p = new Pedido();
        System.out.println("entrei");
        
        
       
        
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlVendaAVista = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlVendaAPrazo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jlTotalVenda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbtSair = new javax.swing.JButton();
        jbtImprimir = new javax.swing.JButton();
        jbtAtualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlDinheiro = new javax.swing.JLabel();
        jlCartaoDebito = new javax.swing.JLabel();
        jlCartaoCredito = new javax.swing.JLabel();
        jlCheque = new javax.swing.JLabel();
        jlValeAliment = new javax.swing.JLabel();
        jlTotalRecebido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumo de Vendas e Recebimentos do Dia Atual.");

        jPanel1.setBackground(new java.awt.Color(167, 205, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo de Vendas do Dia."));

        jLabel1.setText("Total de Venda à Vista :");

        jlVendaAVista.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlVendaAVista.setText("jLabel2");

        jLabel2.setText("Total de Venda a Prazo:");

        jlVendaAPrazo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlVendaAPrazo.setText("jLabel3");

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setText("Total de Vendas    :");

        jlTotalVenda.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jlTotalVenda.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jlVendaAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jlVendaAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlVendaAVista))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlVendaAPrazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlTotalVenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print-icon.png"))); // NOI18N
        jbtImprimir.setText("Imprimir");
        jbtImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtImprimirActionPerformed(evt);
            }
        });

        jbtAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sync.png"))); // NOI18N
        jbtAtualizar.setText("Atualizar");
        jbtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbtImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(jbtImprimir)
                .addComponent(jbtAtualizar))
        );

        jPanel3.setBackground(new java.awt.Color(245, 254, 185));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo de Recebimentos do Dia."));

        jLabel3.setText("Total Recebido em Dinheiro ....................................:");

        jLabel4.setText("Total Recebido em Cartão Débito .......................... :");

        jLabel5.setText("Total Recebido em Cartão Crédito ..........................:");

        jLabel6.setText("Total Recebido em Cheque .....................................:");

        jLabel7.setText("Total Recebido em Vale Alimentação ......................:");

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setText("Total  Recebido ................................:");

        jlDinheiro.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlDinheiro.setText("jLabel3");

        jlCartaoDebito.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlCartaoDebito.setText("jLabel3");

        jlCartaoCredito.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlCartaoCredito.setText("jLabel3");

        jlCheque.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlCheque.setText("jLabel3");

        jlValeAliment.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlValeAliment.setText("jLabel3");

        jlTotalRecebido.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jlTotalRecebido.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlValeAliment, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlDinheiro))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlCartaoDebito))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlCartaoCredito))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlCheque))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlValeAliment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlTotalRecebido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAtualizarActionPerformed

         Date y = new Date();
        double vendaAVista = 0;
        double somaAVista = 0;
        double vendaAPrazo = 0;
        double somaAPrazo = 0;
        double somatotalVendas = 0;
      //  Date y = new Date();
        String dataPes = df.format(y);
        Date dataIni = null;
          
       
        try {
            dataIni = df.parse(dataPes);
        } catch (ParseException ex) {
            Logger.getLogger(ResumoVendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataFim = y;
       
        //Total de Venda A Vista.        
           listaAVista = pDao.listaPedidoAVistaPorPeriodoQ(dataIni, dataFim);            
        for (Pedido p : listaAVista){            
            for (PedidoPagamento pg : p.getListaPagamento()){
                vendaAVista = Double.parseDouble(pg.getTotal().toString());
                somaAVista = (somaAVista + vendaAVista);
            }           
        }
        jlVendaAVista.setText("R$ "+new DecimalFormat("#,##0.00").format(somaAVista));
        //Fim.
        
        //Total de Venda A Prazo.               
        listaAPrazo = pDao.listaPedidoAPrazoPorPeriodoQ(dataIni, dataFim);        
        for (Pedido p : listaAPrazo){            
            for (PedidoItens pi : p.getListaItens()){
                vendaAPrazo = Double.parseDouble(pi.getVlSubtotal().toString());
                somaAPrazo = (somaAPrazo + vendaAPrazo);
            }           
        }
        jlVendaAPrazo.setText("R$ "+new DecimalFormat("#,##0.00").format(somaAPrazo));
        //Fim.
        
        //Somando o A Vista e o A Prazo.
        somatotalVendas = (somaAVista + somaAPrazo);
        jlTotalVenda.setText("R$ "+new DecimalFormat("#,##0.00").format(somatotalVendas));
        //Fim.        
        
        //Somando Caixa Itens
        listaCaixaItens = caixaItDao.listaCaixaItensPorPeriodo(dataIni, dataFim);       
        double totalDinheiro = 0;
        double somaDinheiro = 0;       
        double totalCartaoDebito = 0;
        double somaCartaoDebito = 0;
        double totalCartaoCred = 0;
        double somaCartaoCred = 0;
        double totalCheque = 0;
        double somaCheque = 0;
        double totalValeAli = 0;
        double somaValeAli = 0;
        double totalRecebido = 0;
        for (CaixaItens ci : listaCaixaItens){  
            
            if (ci.getFormaPagto().equals("DINHEIRO")){
               totalDinheiro = Double.parseDouble(ci.getVlEntrada().toString());
               somaDinheiro = (somaDinheiro + totalDinheiro);              
            }
            if (ci.getFormaPagto().equals("CARTAO DEBITO")){
               totalCartaoDebito = Double.parseDouble(ci.getVlEntrada().toString());
               somaCartaoDebito = (somaCartaoDebito + totalCartaoDebito);
            }
            if (ci.getFormaPagto().equals("CARTAO CREDITO")){
                totalCartaoCred = Double.parseDouble(ci.getVlEntrada().toString());
                somaCartaoCred = (somaCartaoCred + totalCartaoCred);
            }
            if (ci.getFormaPagto().equals("CHEQUE")){
                totalCheque = Double.parseDouble(ci.getVlEntrada().toString());
                somaCheque = (somaCheque + totalCheque);                
            }  
            if (ci.getFormaPagto().equals("VALE ALIMENTACAO")){
                totalValeAli = Double.parseDouble(ci.getVlEntrada().toString());
                somaValeAli = (somaValeAli + totalValeAli);
            }                  
        }
        totalRecebido = (somaDinheiro + somaCartaoDebito + somaCartaoCred +
                         somaCheque + somaValeAli);
        jlDinheiro.setText("R$ "+ new DecimalFormat("#,##0.00").format(somaDinheiro));
        jlCartaoDebito.setText("R$ "+new DecimalFormat("#,##0.00").format(somaCartaoDebito));
        jlCartaoCredito.setText("R$ "+new DecimalFormat("#,##0.00").format(somaCartaoCred));
        jlCheque.setText("R$ "+new DecimalFormat("#,##0.00").format(somaCheque));
        jlValeAliment.setText("R$ "+new DecimalFormat("#,##0.00").format(somaValeAli));
        jlTotalRecebido.setText("R$ "+new DecimalFormat("#,##0.00").format(totalRecebido));
        //Fim.
        
        
        
    }//GEN-LAST:event_jbtAtualizarActionPerformed

    private void jbtImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImprimirActionPerformed
       
        List listaDados = new ArrayList();
        Map parametros = new HashMap();
        
        Empresa empresa = new Empresa();
        EmpresaDAO empDAO = new EmpresaDAO();
        empresa = empDAO.getEmpresa();
      
       
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
        +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        
        
        ResumoVendaRecebimento rvr = new ResumoVendaRecebimento();
        
        rvr.setTotalAVista(jlVendaAVista.getText());
        rvr.setTotalAPrazo(jlVendaAPrazo.getText());
        rvr.setTotalDinheiro(jlDinheiro.getText());
        rvr.setTotalCartaoDeb(jlCartaoDebito.getText());
        rvr.setTotalCartaoCred(jlCartaoCredito.getText());
        rvr.setTotalCheque(jlCheque.getText());
        rvr.setTotalValeAli(jlValeAliment.getText());
        rvr.setTotalVenda(jlTotalVenda.getText());
        rvr.setTotalRecebimento(jlTotalRecebido.getText());
        
        listaDados.add(new ResumoVendaRecebimento(rvr.getTotalAVista(),rvr.getTotalAPrazo(),
        rvr.getTotalDinheiro(), rvr.getTotalCartaoDeb(), rvr.getTotalCartaoCred(),
        rvr.getTotalCheque(), rvr.getTotalValeAli(), rvr.getTotalVenda(), rvr.getTotalRecebimento()));
        
        InputStream is = getClass().getResourceAsStream("resumo.jasper");              
        
      
        try {
            
          JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);  
            
          this.jp = JasperFillManager.fillReport(is, parametros, relat);
          JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true); 
        } catch (JRException ex) {
            Logger.getLogger(ResumoVendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    
    
        
    }//GEN-LAST:event_jbtImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ResumoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ResumoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ResumoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ResumoVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ResumoVendaView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbtAtualizar;
    private javax.swing.JButton jbtImprimir;
    private javax.swing.JButton jbtSair;
    private javax.swing.JLabel jlCartaoCredito;
    private javax.swing.JLabel jlCartaoDebito;
    private javax.swing.JLabel jlCheque;
    private javax.swing.JLabel jlDinheiro;
    private javax.swing.JLabel jlTotalRecebido;
    private javax.swing.JLabel jlTotalVenda;
    private javax.swing.JLabel jlValeAliment;
    private javax.swing.JLabel jlVendaAPrazo;
    private javax.swing.JLabel jlVendaAVista;
    // End of variables declaration//GEN-END:variables
}
