/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class ProdutoGradeItenView extends javax.swing.JDialog {

    /**
     * Creates new form ProdutoGradeItenView
     */
     DefaultTableModel amodel;
    public ProdutoGradeItenView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jtfAtributo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfEstoqueMínimo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEstoque = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtImporta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens da grade"));

        jLabel1.setText("ATRIBUTO");

        jtfAtributo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfAtributoFocusLost(evt);
            }
        });
        jtfAtributo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfAtributoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel2.setText("(EX: Tamanho; Cor;  Peso; etc... )");

        jtfEstoqueMínimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEstoqueMínimoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEstoqueMínimoKeyPressed(evt);
            }
        });

        jLabel3.setText("ESTOQUE MÍNIMO");

        jtfEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEstoqueKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEstoqueKeyPressed(evt);
            }
        });

        jLabel4.setText("ESTOQUE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfEstoqueMínimo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEstoqueMínimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtImporta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jbtImporta.setText("OK");
        jbtImporta.setEnabled(false);
        jbtImporta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtImportaActionPerformed(evt);
            }
        });
        jbtImporta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtImportaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbtImporta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtImporta)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAtributoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfAtributoFocusLost
        // TODO add your handling code here:
        //  jtfDescricao.setText(jtfDescricao.getText().toUpperCase());
     //   jtfDescricao.setText(RemoverAcentosString.semAcento(jtfDescricao.getText().toUpperCase()));
    }//GEN-LAST:event_jtfAtributoFocusLost

    private void jtfAtributoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAtributoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfAtributo.equals(null) || jtfAtributo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo atributo não pode ser nullo ou vazio !!!");
            }else{
                jtfEstoqueMínimo.requestFocus();
            }

        }
    }//GEN-LAST:event_jtfAtributoKeyPressed

    private void jtfEstoqueMínimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueMínimoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfEstoqueMínimo.getText().isEmpty())
                jtfEstoqueMínimo.setText("0");
                
            jtfEstoque.requestFocus();
        }
    }//GEN-LAST:event_jtfEstoqueMínimoKeyPressed

    private void jtfEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfEstoque.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "O campo número não pode ser nullo ou vazio !!!");
            }else{
                jbtImporta.setEnabled(true);
                jbtImporta.requestFocus();
            }

        }
    }//GEN-LAST:event_jtfEstoqueKeyPressed

    private void jbtImportaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImportaActionPerformed
        float estoqueMin = 0;
        float estoque = 0;
        amodel = (DefaultTableModel) ProdutoGradeView.jTable1.getModel();
               
        estoqueMin = Float.parseFloat(jtfEstoqueMínimo.getText());
        estoque = Float.parseFloat(jtfEstoque.getText());
        amodel.addRow(new Object[]{jtfAtributo.getText(), estoqueMin,  estoque});
        dispose();
    }//GEN-LAST:event_jbtImportaActionPerformed

    private void jbtImportaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtImportaKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
            jbtImportaActionPerformed(null);
        }
    }//GEN-LAST:event_jbtImportaKeyPressed

    private void jtfEstoqueMínimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueMínimoKeyTyped
        String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfEstoqueMínimoKeyTyped

    private void jtfEstoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueKeyTyped
         String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           evt.consume();
        }
    }//GEN-LAST:event_jtfEstoqueKeyTyped

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
//            java.util.logging.Logger.getLogger(ProdutoGradeItenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProdutoGradeItenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProdutoGradeItenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProdutoGradeItenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ProdutoGradeItenView dialog = new ProdutoGradeItenView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtImporta;
    private javax.swing.JTextField jtfAtributo;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfEstoqueMínimo;
    // End of variables declaration//GEN-END:variables

    private float Floatparse(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
