/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.PedidoDAO;
import dao.PessoaDAO;
import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maps.java.Geocoding;
import maps.java.MapsJava;
import model.Pedido;
import model.PedidoItens;
import model.Pessoa;
import util.Localizacao;

/**
 *
 * @author daniel
 */
public class PedidoPesquisaDeliveryView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoPesquisaDeliveryView
     */
    
    private Localizacao local = new Localizacao();
    
    Locale locale = new Locale("pt", "BR");
    SimpleDateFormat formatadorHD = new SimpleDateFormat("dd/MM/yyyy' - 'HH':'mm", locale);
    PedidoDAO pedidoDao = new PedidoDAO();
    Pedido pedido = new Pedido();
    List<PedidoItens> listaItens;
    
    public PedidoPesquisaDeliveryView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jbtMapa.setEnabled(false);
        carregaTable();
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
        jtfPesquisa = new javax.swing.JTextField();
        jbtMapa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jbtEditar = new javax.swing.JButton();
        jlDestino = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Delivery"));

        jbtMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mapa.png"))); // NOI18N
        jbtMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMapaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PEDIDO Nº", "INICIADO EM:", "CLIENTE", "TELEFONE", "STATUS", "SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setToolTipText("Novo Pedido");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setToolTipText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        jbtEditar.setText("Editar");
        jbtEditar.setEnabled(false);
        jbtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jlDestino.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jlDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        PedidoDeliveryView pdv = new PedidoDeliveryView(new JFrame(), true, 0, null);
        pdv.setTitle("Pedido Delivery");
        pdv.setLocationRelativeTo(null); // centraliza a tela
        pdv.dispose();
        pdv.setUndecorated(true);
        pdv.setVisible(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMapaActionPerformed

        
        MapsJava.setKey("AIzaSyAvwNVgq9PbEDmRlFjr5GIHDpChmAFu-ys ");
        MapsJava.setRegion("BR");
        MapsJava.setLanguage("PT");
//
      
        if (!menuView.Menu.localizacao.equals("")){ 

            //Origem
            try{
            String enderecoOrigem = menuView.Menu.localizacao;
            Geocoding ObjGeocoding=new Geocoding();
            Point2D.Double resultado = null;
            try {
                resultado = ObjGeocoding.getCoordinates(enderecoOrigem);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(PedidoDeliveryView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(PedidoDeliveryView.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(resultado.x!=0.0 && resultado.y!=0.0){               
                local.setLatitud(resultado.x);
                local.setLongitud(resultado.y);
                local.setDireccion(ObjGeocoding.getAddressFound());
            }
            //Fim Origem
            
            
                
            int codPedido = 0;
            codPedido = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            
            this.pedido = this.pedidoDao.pedidoID(codPedido);
//
//            //Destino
            String destino = null;
            destino = (this.pedido.getPedidoEntrega().getLogradouro()+" "+this.pedido.getPedidoEntrega().getNumero()+
                    " "+this.pedido.getPedidoEntrega().getBairro()+" "+this.pedido.getPedidoEntrega().getCidade()+
                    " "+this.pedido.getPedidoEntrega().getEstado());
                    
                //    (jtfLogradouro.getText()+" "+jtfNumero.getText()+" "+jtfBairro.getText()+
//                " "+jtfCidade.getText()+" "+jtfEstado.getText());
//
          
                try {
                    validarDestino(destino);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(Level.SEVERE, null, ex);
            }
           

            //PesquisaProdutoView pProd = new PesquisaProdutoView(new java.awt.Frame(), true,  "DELIVERY");

            calculaRuta(destino);
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Talvez você está sem Internet! Error: "+e.getMessage());
        }
    }//GEN-LAST:event_jbtMapaActionPerformed
 
}
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jbtMapa.setEnabled(true);
        jbtEditar.setEnabled(true);
        
        
        int codPedido = 0;
        codPedido = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            
        this.pedido = this.pedidoDao.pedidoID(codPedido);
        String destino = null;
        destino = (this.pedido.getPedidoEntrega().getLogradouro()+" "+this.pedido.getPedidoEntrega().getNumero()+
                  " "+this.pedido.getPedidoEntrega().getBairro()+" "+this.pedido.getPedidoEntrega().getCidade());               
        jlDestino.setText("Entregador: "+this.pedido.getEntregador().getNome()+" | Endereço: "+destino);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditarActionPerformed
        
        int idPedido  = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        
        pedido = pedidoDao.pedidoID(idPedido);
        
        
        
        listaItens = new ArrayList<>();
        
        listaItens = pedido.getListaItens();
        
        PedidoDeliveryView pedidoDelivery = new PedidoDeliveryView(new JFrame(), true, 1,  this.pedido);
       
        pedidoDelivery.setTitle("Pedido Delivery");
        pedidoDelivery.setLocationRelativeTo(null); // centraliza a tela
        pedidoDelivery.dispose();
        pedidoDelivery.setUndecorated(true);
        pedidoDelivery.setVisible(true);
        pedidoDelivery.jbtPagamento.setEnabled(true);
        
        String vlTotalProd, vlUnitProd, quantidadeStr;
        
    }//GEN-LAST:event_jbtEditarActionPerformed

    
    public void carregaTable(){
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        pedidos = pedidoDAO.listaPedidoDelivery();
        
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        
        BigDecimal subTotal = new BigDecimal(BigInteger.ZERO) ;
        String dataHora;
        int i =0;
        for (Pedido pedido : pedidos){            
            for (PedidoItens iten : pedido.getListaItens()){                
                subTotal = subTotal.add(iten.getVlSubtotal());                        
            }            
        dataHora = formatadorHD.format(pedido.getDtCad());
        amodel.addRow(new Object[]{pedido.getId(), dataHora, pedido.getCliente().getNome(),
        pedido.getPedidoEntrega().getTelefone(), pedido.getStatus(), subTotal}); 
        
        subTotal = new BigDecimal(BigInteger.ZERO);
        } 
        
    }
           
   private void validarDestino(String destino) throws UnsupportedEncodingException, MalformedURLException{
        if(!destino.isEmpty()){
          Geocoding ObjGeocoding=new Geocoding();
          ObjGeocoding.getCoordinates(destino);
          jlDestino.setText("Entrega: "+ObjGeocoding.getAddressFound());
        }
    }    
     private void calculaRuta(String destino){
        if(!destino.isEmpty()){
           // this.setVisible(false);
          //  RutaCalcula formulario=new RutaCalcula(new JFrame(), true, destino,true);
           // Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
          //  formulario.setLocation((d.width/2)-(formulario.getWidth()/2), (d.height/2)-(formulario.getHeight()/2));
//            formulario.setSize(new Dimension(400, 350));
          //  formulario.setVisible(true);
          RotaEntrega rotaEntrega = new RotaEntrega(new JFrame(), true, destino);
          rotaEntrega.setLocationRelativeTo(null);
          rotaEntrega.setVisible(true);
        }
    }
    
    /**
     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PedidoPesquisaDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PedidoPesquisaDeliveryView dialog = new PedidoPesquisaDeliveryView(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbtEditar;
    private javax.swing.JButton jbtMapa;
    private javax.swing.JLabel jlDestino;
    private javax.swing.JTextField jtfPesquisa;
    // End of variables declaration//GEN-END:variables
}