/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import dao.CategoriaProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.CategoriaProduto;

/**
 *
 * @author daniel
 */
public class CategoriaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoriaView
     */
    List<CategoriaProduto> listaCategoria;
    String operacao;
    public CategoriaView() {
        initComponents();
        jButton2.setEnabled(false);
      //  jButton2.setVisible(false);
        jbtCancelar.setEnabled(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        rowSorterToStringConverter1 = new converter.RowSorterToStringConverter();
        jPanel1 = new javax.swing.JPanel();
        jtfPesquisa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();

        rowSorterToStringConverter1.setTable(jTable1);

        setTitle("Cadastro Categoria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Categoria"));

        jtfPesquisa.setNextFocusableComponent(jbNovo);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisa, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da Pesquisa"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(310);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Categoria"));

        jLabel1.setText("Código:");

        jtfId.setEnabled(false);

        jLabel2.setText("Descrição:");

        jtfDescricao.setEnabled(false);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfDescricao))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        // TODO add your handling code here:

          if (operacao == "salvar"){
              CategoriaProdutoDAO produtoDAO = new CategoriaProdutoDAO();
              produtoDAO.salvar(carregaObjeto());
              JOptionPane.showMessageDialog(null, "Categoria Salvo com sucesso");
          }else
          if (operacao == "alterar"){
              CategoriaProdutoDAO produtoDAO = new CategoriaProdutoDAO();
              produtoDAO.alterar(carregaObjeto());
              JOptionPane.showMessageDialog(null, "Categoira Alterado com sucesso");
          }
          jbtCancelarActionPerformed(evt);
          jbNovo.setEnabled(true);
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        // TODO add your handling code here:
        // dispose();

        dispose();
        //Habilita o menu de cep.
      //  Principal.categoriaMenuItem.setEnabled(true);

    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed

          jtfId.setText("");
          jtfId.setEnabled(false);
          jtfDescricao.setText("");
          jtfDescricao.setEnabled(false);
          jtfPesquisa.setEnabled(true);
          carregaTable();
          jbtSalvar.setEnabled(false);
          jbtCancelar.setEnabled(false);
          jbNovo.setEnabled(true);
          jButton2.setEnabled(false);
          jtfPesquisa.requestFocus();

    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esta Categoria de Produto?", "ATENÇÂO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {

            CategoriaProdutoDAO catDAO = new CategoriaProdutoDAO();
            try{
               catDAO.excluir(carregaObjeto());
               JOptionPane.showMessageDialog(null, "Categoria Excluída com Sucesso !!!");               
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Problemas ao Excluir Categoria de Produto: "+e.getMessage());
                e.printStackTrace();
            }finally{
                jbtCancelarActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        // TODO add your handling code here:
        operacao = "salvar";
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        jtfDescricao.setEnabled(true);
        jbNovo.setEnabled(false);
        jButton2.setEnabled(false);
        jbtCancelar.setEnabled(true);
        jtfDescricao.requestFocus();

    }//GEN-LAST:event_jbNovoActionPerformed

    private void jtfDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            jbtSalvar.setEnabled(true);
            jbtSalvar.requestFocus();
        }
    }//GEN-LAST:event_jtfDescricaoKeyPressed

    private void jtfDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDescricaoFocusLost
        jtfDescricao.setText(jtfDescricao.getText().toUpperCase());
    }//GEN-LAST:event_jtfDescricaoFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        operacao = "alterar";
        jtfId.setText("");
        jtfId.setEnabled(true);
        jtfDescricao.setText("");
        jtfDescricao.setEnabled(true);
        Long id = (Long) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));        
        
        jtfId.setText(id.toString());
        jtfDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        
        jbNovo.setEnabled(false);
        jbtCancelar.setEnabled(true);
        jbtSalvar.setEnabled(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

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

    private CategoriaProduto carregaObjeto(){
        CategoriaProduto categoria = new CategoriaProduto();
        
        if (operacao == "alterar")
            categoria.setId(Long.parseLong(jtfId.getText()));
        categoria.setDescricao(jtfDescricao.getText());
        
        return categoria;
        
    }
    
     private void carregaTable(){
        
       // Cep cep = new Cep();
        
      //  String[] tableColumsName = {"CÓD.","LOGRADOURO","BAIRRO"};
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
     //   amodel.setColumnIdentifiers(tableColumsName);
       // modeloTable = (DefaultTableModel) jTable2.getModel();
        
        amodel.setNumRows(0);
        CategoriaProdutoDAO daoCat = new CategoriaProdutoDAO();
             
        listaCategoria = null;
        
        listaCategoria = daoCat.listCategoriaProduto();
        
        for (CategoriaProduto categ : listaCategoria){                            
            amodel.addRow(new Object[]{categ.getId(),categ.getDescricao()});                     
        }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfPesquisa;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
