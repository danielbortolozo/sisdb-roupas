/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.PedidoCrediarioDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pedido;
import model.PedidoCrediario;
import model.PessoaEndereco;
import model.PessoaFisica;
import model.PessoaJuridica;
import net.sf.jasperreports.engine.JRException;
import relatoriosView.ImprimeRelatorio;
import relatoriosView.crediario.CrediarioRel;
import relatoriosView.crediario.ValorPorExtenso;

/**
 *
 * @author daniel
 */
public class PedidoCrediarioView extends javax.swing.JDialog {

    /**
     * Creates new form PedidoCrediarioView
     */
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    public static String botao = null;
    private Pedido pedido = new Pedido();
    Date vencimento = null;
    BigDecimal vlParcela = new BigDecimal(BigInteger.ZERO);
    BigDecimal qtdParcela = new BigDecimal(BigInteger.ZERO);
    public PedidoCrediarioView(java.awt.Frame parent, boolean modal, Pedido pedido) {
        super(parent, modal);
        initComponents();
        Keypress_jDateChoooser();
        this.pedido = pedido;
        jLabel4.setVisible(false);
        jlValorParcelas.setVisible(false);
        //System.out.println("Pedido nº "+this.pedido.getId());
        
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
        jLabel2 = new javax.swing.JLabel();
        jtfNumParcela = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlValorParcelas = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jbtOk = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DO CREDIÁRIO"));

        jLabel1.setText("1º - VENCIMENTO");

        jLabel2.setText("QUANTAS VEZES?");

        jtfNumParcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNumParcelaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNumParcelaKeyPressed(evt);
            }
        });

        jLabel3.setText("TOTAL");

        jlTotal.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(20, 94, 241));
        jlTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotal.setText("jLabel4");
        jlTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel4.setText("VALOR DAS PARCELAS: ");

        jlValorParcelas.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlValorParcelas.setText("jLabel5");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jDateChooser1AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNumParcela)
                    .addComponent(jlValorParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNumParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTotal))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jlValorParcelas)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbtOk.setText("OK");
        jbtOk.setEnabled(false);
        jbtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtOk, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        botao = "cancelar";                
        dispose();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed
       

    }//GEN-LAST:event_jDateChooser1KeyPressed

    private void jbtOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOkActionPerformed

        botao = "ok";
        
        PedidoCrediario pCrediario = new PedidoCrediario();
        PedidoCrediarioDAO daoPedCred = new PedidoCrediarioDAO();
        //Convertendo a quantidade de parcela para inteiro.
        int parcelas = Integer.parseInt(qtdParcela.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(vencimento); // Objeto Date() do usuário
      //  cal.add(cal.DAY_OF_MONTH, +1);      
        List<CrediarioRel> listaCrediario = new ArrayList<CrediarioRel>();
        CrediarioRel crediarioRel = new CrediarioRel();
        PessoaFisica pFisica = new PessoaFisica();
        PessoaJuridica pJuridica = new PessoaJuridica();
        PessoaFisicaDAO pFisicaDao = new PessoaFisicaDAO();
        PessoaJuridicaDAO pJuridicaDao = new PessoaJuridicaDAO();
        PessoaEndereco pEndereco = new PessoaEndereco();
        Locale local = new Locale("pt","BR");        
        DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
        double vlParcelaDb = 0;       
// String tipoCliente = PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido().getCliente().getTipo();
      //  Long idPessoa = PedidoRecebeCrediarioView.pedidoCrediario.getIdPedido().getCliente().getId();
//        if (tipoCliente.equals("F"))
//            pFisica = pFisicaDao.pessoaFisica(idPessoa);
//        else
//            if (tipoCliente.equals("J"))
//                pJuridica = pJuridicaDao.pessoaJuridica(idPessoa);
        for (int i = 1; i <= parcelas; i++ ){                                
            pCrediario.setDtVencimento(cal.getTime());
            pCrediario.setIdPedido(this.pedido);
            pCrediario.setIdPedidoPagamento(null);
            pCrediario.setNumParcela(i+"/"+parcelas);
            pCrediario.setVlParcela(vlParcela);
            pCrediario.setStatus("ABERTO");
         //   pCrediario.setVlRestante(vlParcela);
            
            //Salva Pedido Crediario
            daoPedCred.salvar(pCrediario); 
            
            
            //Passar os parametro para a classe de Relatório Crediario, para gerar o carnê.
            crediarioRel.setDocumento(this.pedido.getId().toString());
            crediarioRel.setVencimento(df.format(pCrediario.getDtVencimento()));
            crediarioRel.setValor(new DecimalFormat("#,##0.00").format(vlParcela));
            crediarioRel.setParcela(pCrediario.getNumParcela());
            crediarioRel.setCliente(this.pedido.getCliente().getNome());
            vlParcelaDb = Double.parseDouble(vlParcela.toString());
            crediarioRel.setValorExtenso(ValorPorExtenso.valorPorExtenso(vlParcelaDb));
                                
            cal = cal.getInstance();
            cal.setTime(pCrediario.getDtVencimento());
            crediarioRel.setVencimentoExtenso(dateFormat.format(cal.getTime()));
            
            
            
           // crediarioRel.setCpf(p);
            if (this.pedido.getCliente().getTipo().equals("F")){
                pFisica = pFisicaDao.pessoaFisica(this.pedido.getCliente().getId());
                crediarioRel.setCpf(pFisica.getCpf());
                
                if (pFisica.getListaEndereco().size() > 0){
                   for(PessoaEndereco pEnd : pFisica.getListaEndereco()){
                       if (pEnd.getPrincipal().equals(true))
                           crediarioRel.setEndereco(pEnd.getLogradouro()+", "+pEnd.getNumero()+", "+pEnd.getBairro()+"-"+
                                   pEnd.getCidade()+"-"+pEnd.getUf());
                     
                       
                   }
                }   
            }else
                if (this.pedido.getCliente().getTipo().equals("J")){
                    pJuridica = pJuridicaDao.pessoaJuridica(this.pedido.getCliente().getId());
                    crediarioRel.setCpf(pJuridica.getCnpj());
                    
                    if (pJuridica.getListaEndereco().size() > 0){
                       for(PessoaEndereco pEnd : pJuridica.getListaEndereco()){
                          if (pEnd.getPrincipal().equals(true))
                             crediarioRel.setEndereco(pEnd.getLogradouro()+", "+pEnd.getNumero()+", "+pEnd.getBairro()+"-"+
                                     pEnd.getCidade()+"-"+pEnd.getUf());                    
                       
                   }
                } 
                    
                    
                }

            
            listaCrediario.add(new CrediarioRel(crediarioRel.getDocumento(), crediarioRel.getVencimento(),
            crediarioRel.getParcela(), crediarioRel.getValor(), crediarioRel.getCliente(), crediarioRel.getCpf(), crediarioRel.getEndereco(), crediarioRel.getVencimentoExtenso(),
            crediarioRel.getValorExtenso()));
            
            
                       
            //Aumenta um Mês.
            cal.add(Calendar.MONTH, 1);           
        }        
        JOptionPane.showMessageDialog(null, "Crediário Cadastrado com Sucesso!!!"); 
        
        ImprimeRelatorio carne = new ImprimeRelatorio();
        try {
            carne.relatorioCrediario(listaCrediario, jlTotal.getText());
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(PedidoCrediarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        dispose();
        //Zerar o Formulário de Venda.
//        PedidoView.pedido = new Pedido();
//        PedidoView.jlStatusCaixa.setText("CAIXA LIVRE");
//        PedidoView.jlStatusCaixa.setForeground(Color.BLUE);
//        PedidoView.jlNumPedido.setVisible(false);
//        PedidoView.jtfCliente.setText("");
//        PedidoView.jtfObs.setText("");
//           
//        PedidoView.jtfSubTotal.setText("");
//        PedidoView.subtotal = 0;
//        PedidoView.cliente = new Pessoa() {};
//        PedidoView.listaItens = new ArrayList<>();
//        DefaultTableModel modelPedido = (DefaultTableModel) PedidoView.jTable1.getModel();
//        modelPedido.setNumRows(0);
//        PedidoView.jbtPagamento.setEnabled(false);
//        PedidoView.jtfCliente.setEnabled(true);
//        PedidoView.jbtCliente.setEnabled(true);
//        PedidoView.pedidoPagView = null;
    }//GEN-LAST:event_jbtOkActionPerformed

    private void jtfNumParcelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumParcelaKeyPressed
        
        
        
        if (evt.getKeyCode() == evt.VK_ENTER){ 
            
            String vlTotalStr = jlTotal.getText();
            vlTotalStr = vlTotalStr.replace(".", "");
            vlTotalStr = vlTotalStr.replace(",", ".");           
            
            if (jtfNumParcela.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Digite a quantidade de parcelas.");
               return;
           }else{                
                vlParcela = new BigDecimal(vlTotalStr); 
                              
                qtdParcela = new BigDecimal(jtfNumParcela.getText());
                
                vlParcela = vlParcela.divide(qtdParcela,MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
                
                // vlParcela.divide((qtd));
                jlValorParcelas.setText("R$ "+vlParcela.toString());
                jLabel4.setVisible(true);               
                jlValorParcelas.setVisible(true);               
           }         
           
                      
           vencimento = jDateChooser1.getDate();            
           if (vencimento == null){
               JOptionPane.showMessageDialog(null, "Escolha a Data do 1º Vencimento");
               //jDateChooser1.requestFocus();
               //jDateChooser1.requestFocusInWindow();
               jDateChooser1.requestDefaultFocus();
               return;
           }
           jbtOk.setEnabled(true);
           jbtOk.requestFocus();
        }
    }//GEN-LAST:event_jtfNumParcelaKeyPressed

    private void jtfNumParcelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumParcelaKeyTyped

       String caracteres="0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfNumParcelaKeyTyped

    private void jDateChooser1AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jDateChooser1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1AncestorMoved

   private void Keypress_jDateChoooser(){
        HashSet<AWTKeyStroke> conjForward = new HashSet<AWTKeyStroke>(jDateChooser1.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conjForward.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        conjForward.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_DOWN, 0));
        jDateChooser1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjForward);
        
   }
    
    
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
//            java.util.logging.Logger.getLogger(PedidoCrediarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PedidoCrediarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PedidoCrediarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PedidoCrediarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                PedidoCrediarioView dialog = new PedidoCrediarioView(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtOk;
    public static javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlValorParcelas;
    private javax.swing.JTextField jtfNumParcela;
    // End of variables declaration//GEN-END:variables
}
