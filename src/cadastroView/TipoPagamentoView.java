/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;




import dao.TipoPagamentoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menuView.Menu;

import model.TipoPagamento;
import util.RemoverAcentosString;


/**
 *
 * @author daniel
 */
public class TipoPagamentoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CepView
     */
    List<TipoPagamento> listaTipoPag;
    String operacao;
    public TipoPagamentoView() {
        initComponents();
        carregaTable();
     //   jButton2.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        rowSorterToStringConverter1 = new converter.RowSorterToStringConverter();
        jPanel2 = new javax.swing.JPanel();
        jtfDescricao = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtfPesquisa = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        rowSorterToStringConverter1.setTable(jTable2);

        setTitle("Cadastro de Tipos de Pagamentos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCRIÇÃO TIPO PAGAMENTO"));

        jtfDescricao.setEnabled(false);
        jtfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescricaoActionPerformed(evt);
            }
        });
        jtfDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDescricaoFocusLost(evt);
            }
        });
        jtfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescricaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        jbtSalvar.setText("Salvar");
        jbtSalvar.setEnabled(false);
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });
        jbtSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtSalvarKeyPressed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit_1.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.setToolTipText("Fechar Formulário");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });
        jbtSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtSairKeyPressed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setEnabled(false);
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });
        jbtCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtCancelarKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jButton2.setText("Excluir");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setEnabled(false);
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jbNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbNovoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSalvar)
                .addComponent(jbtSair)
                .addComponent(jbtCancelar)
                .addComponent(jButton2)
                .addComponent(jbNovo))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Tipo Pagamento"));

        jtfPesquisa.setNextFocusableComponent(jbNovo);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable2, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisa, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da Pesquisa"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD.", "TIPO PAGAMENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        // TODO add your handling code here:
       // dispose();
           
      dispose();
     
//      Principal.tipoPagtoMenuItem.setEnabled(true);
        
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        // TODO add your handling code here:
        
        if (operacao == "salvar"){
           TipoPagamentoDAO dao = new TipoPagamentoDAO();
           dao.salvar(carregaObjeto());
           JOptionPane.showMessageDialog(null, "Salvo com sucesso");    
        }else
           if (operacao == "alterar"){
               TipoPagamentoDAO dao = new TipoPagamentoDAO();
               dao.alterar(carregaObjeto());
               JOptionPane.showMessageDialog(null, "Alterado com sucesso");
           }
        jbtCancelarActionPerformed(evt);
        jbNovo.setEnabled(true);
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfPesquisa.getText().equals("")){
                jbNovo.requestFocus();
            }
            
            
        }
        
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        // TODO add your handling code here:
       operacao = "salvar";
       DefaultTableModel amodel = (DefaultTableModel) jTable2.getModel();
       amodel.setNumRows(0);
      
       limpar();
       
       habilita(false);
       jtfDescricao.setEnabled(true);
       jbNovo.setEnabled(false);
       jtfDescricao.requestFocus();
       
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jtfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescricaoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jtfDescricaoActionPerformed

    private void jtfDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if(jtfDescricao.getText().equals("")){
                JOptionPane.showMessageDialog(null, "A descrição não pode ser nullo ou vazio");
                jtfDescricao.requestFocus();
            }else{
                jbtSalvar.setEnabled(true);
                jbtSalvar.requestFocus();
            }
                
            
            
        }
    }//GEN-LAST:event_jtfDescricaoKeyPressed

    private void jtfDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDescricaoFocusLost
        // TODO add your handling code here:
        
        jtfDescricao.setText(RemoverAcentosString.semAcento(jtfDescricao.getText().toUpperCase()));
    }//GEN-LAST:event_jtfDescricaoFocusLost

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
        limpar();
        habilita(false);
        jtfPesquisa.setEnabled(true);
        carregaTable();
        jbtSalvar.setEnabled(false);
        jbtCancelar.setEnabled(false);
        jbNovo.setEnabled(true);
        jtfPesquisa.requestFocus();
        
        
        
        
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
//        //Limpar os campos
//        operacao = "alterar";
//        limpar();
//        
//        //Habilitar os campos.
//        jtfDescricao.setEnabled(true);
//        
//        
//        //Passar Valor da JTable2 para os campos inputField. 
//       // System.out.println("valor jtable ="+(String) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
//        jtfDescricao.setText((String) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
//        jbNovo.setEnabled(false);
//        jbtSalvar.setEnabled(true);
//        jbtCancelar.setEnabled(true);
          
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_jTable2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir este Tipo de Pagamento?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            TipoPagamentoDAO tipopagDAO = new TipoPagamentoDAO();
            operacao = "alterar";
            tipopagDAO.excluir(carregaObjeto());
            JOptionPane.showMessageDialog(null, "Tipo Pagamento Excluído com Sucesso !!!");
            jbtCancelarActionPerformed(evt);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbNovoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbNovoActionPerformed(null);
        }  
    }//GEN-LAST:event_jbNovoKeyPressed

    private void jbtCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtCancelarKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
                jbtCancelarActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtCancelarKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jButton2ActionPerformed(null);
        }  
    }//GEN-LAST:event_jButton2KeyPressed

    private void jbtSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSalvarKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSalvarActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSalvarKeyPressed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
               jbtSairActionPerformed(null);
        }  
    }//GEN-LAST:event_jbtSairKeyPressed

    private TipoPagamento carregaObjeto(){
      
        TipoPagamento tipoPag = new TipoPagamento();
        
        //Passando os parâmetros para o Objeto Cep.
      //  
        if (operacao == "alterar" )
            tipoPag.setId((Long) jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        tipoPag.setDescricao(jtfDescricao.getText());
        
        System.out.println("teese = "+tipoPag.getId());
        System.out.println("teese = "+tipoPag.getDescricao());
           
        return tipoPag;
    }
    
    private void limpar(){
        
        jtfDescricao.setText("");
        jtfPesquisa.setText("");
             
    }
    private void habilita(boolean habilita){
       
        jtfDescricao.setEnabled(habilita);
        jtfPesquisa.setEnabled(habilita);
        
    }
    
    private void carregaTable(){
        
       // Cep cep = new Cep();
        
      //  String[] tableColumsName = {"CÓD.","LOGRADOURO","BAIRRO"};
        DefaultTableModel amodel = (DefaultTableModel) jTable2.getModel();
     //   amodel.setColumnIdentifiers(tableColumsName);
       // modeloTable = (DefaultTableModel) jTable2.getModel();
        
        amodel.setNumRows(0);
        TipoPagamentoDAO tipopagDAO = new TipoPagamentoDAO();
        
        
        
        listaTipoPag = null;
        
        listaTipoPag = tipopagDAO.listTipoPag();
        
        for (TipoPagamento tppg : listaTipoPag){
            
          //  jTable2.setValueAt();
            
                    
            amodel.addRow(new Object[]{tppg.getId(),tppg.getDescricao()});
            
            
        }
    }
    
      
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPesquisa;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
