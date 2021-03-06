/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentoView;

import dao.ProdutoDAO;
import java.text.DecimalFormat;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author daniel
 */
public class VendaDetView extends javax.swing.JDialog {

    /**
     * Creates new form OrcamentoDetView
     */
    private ProdutoDAO prodDao;
    private Produto produto;
    float vltotal, vlUnit, qtd, estoque, subtotal;
    private static DefaultListModel model;
    
    public VendaDetView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jtfCodProd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfValorVenda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfValorUnitario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfUnidade = new javax.swing.JTextField();
        jtfDesconto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfSubTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtSalvar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();

        rowSorterToStringConverter1.setTable(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Produtos"));

        jtfPesquisa.setNextFocusableComponent(jbtSair);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${rowSorter}"), jtfPesquisa, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(rowSorterToStringConverter1);
        bindingGroup.addBinding(binding);

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD. PRODUTO", "DESCRIÇÃO", "ESTOQUE", "UNIDADE", "MARCA", "R$ PREÇO", "CÓD. BARRAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 328, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do Orçamento"));

        jtfCodProd.setEnabled(false);
        jtfCodProd.setNextFocusableComponent(jtfQuantidade);
        jtfCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodProdKeyTyped(evt);
            }
        });

        jLabel1.setText("CÓD. PRODUTO");

        jtfDescricao.setEnabled(false);

        jLabel2.setText("DESCRIÇÃO");

        jLabel4.setText("QUANTIDADE");

        jtfQuantidade.setBackground(new java.awt.Color(183, 211, 245));
        jtfQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfQuantidade.setEnabled(false);
        jtfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyTyped(evt);
            }
        });

        jLabel6.setText("R$ TOTAL");

        jtfValorVenda.setBackground(new java.awt.Color(237, 238, 100));
        jtfValorVenda.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jtfValorVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValorVenda.setEnabled(false);
        jtfValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfValorVendaFocusGained(evt);
            }
        });
        jtfValorVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfValorVendaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorVendaKeyTyped(evt);
            }
        });

        jLabel7.setText("R$ UNITÁRIO");

        jtfValorUnitario.setEditable(false);
        jtfValorUnitario.setBackground(new java.awt.Color(237, 238, 100));
        jtfValorUnitario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jtfValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfValorUnitario.setEnabled(false);

        jLabel3.setText("Unidade");

        jtfUnidade.setEditable(false);
        jtfUnidade.setBackground(new java.awt.Color(183, 211, 245));
        jtfUnidade.setEnabled(false);

        jtfDesconto.setBackground(new java.awt.Color(237, 238, 168));
        jtfDesconto.setEnabled(false);
        jtfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoActionPerformed(evt);
            }
        });
        jtfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfDescontoFocusGained(evt);
            }
        });
        jtfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyTyped(evt);
            }
        });

        jLabel5.setText("DESCTO.");

        jLabel8.setText("%");

        jLabel9.setText("R$ SUBTOTAL");

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setBackground(new java.awt.Color(237, 238, 100));
        jtfSubTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jtfQuantidade)
                    .addComponent(jtfCodProd))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfUnidade))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );

        jtfQuantidade.getAccessibleContext().setAccessibleDescription("");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtSalvar)
                .addComponent(jbtSair))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            jtfCodProd.setEnabled(true);
            jtfDescricao.setEnabled(true);
            jtfCodProd.requestFocus();
        }
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

          jtfCodProd.setEnabled(true);
          jtfDescricao.setEnabled(true);
          jtfQuantidade.setEnabled(true);
          jtfValorUnitario.setEnabled(true);
          jtfUnidade.setEnabled(true);
          jtfCodProd.setText((jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
          jtfDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
          
          jtfValorUnitario.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString())));//
          estoque = (Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
          jtfUnidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
          jtfQuantidade.requestFocus();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

       

    }//GEN-LAST:event_jTable1KeyPressed

    private void jtfCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            prodDao = new ProdutoDAO();
            produto = new Produto();

            if (jtfCodProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Código do Produto não pode ficar em branco ou vazio !!!");              
                jtfCodProd.requestFocus();
            } else {
                Long id_produto = (Long.parseLong(jtfCodProd.getText()));
                produto = prodDao.produtoId(id_produto);
                estoque = produto.getEstoque();
                if (produto == null) {
                    JOptionPane.showMessageDialog(null, "Este Produto não existe");
                    jtfCodProd.setText("");
                    jtfCodProd.requestFocus();
                } else if (estoque <= 0) {
                    JOptionPane.showMessageDialog(null, "Este Produto não têm no Estoque!!!");
                    jtfCodProd.setText("");
                    jtfCodProd.requestFocus();
                } else {
                    jtfValorUnitario.setEnabled(true);
                    jtfDescricao.setEnabled(true);
                    jtfDescricao.setText(produto.getDescricao());
                    jtfValorUnitario.setText(String.valueOf(produto.getVlVenda()));
                    jtfValorUnitario.setText(new DecimalFormat("#,##0.0000").format(Float.parseFloat(jtfValorUnitario.getText())));
                    jtfQuantidade.setEnabled(true);
                    jtfUnidade.setEnabled(true);
                    jtfUnidade.setText(produto.getUnidade().getSigla());
                    jtfQuantidade.requestFocus();
                }

            }

        }
    }//GEN-LAST:event_jtfCodProdKeyPressed

    private void jtfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
                qtd = Float.parseFloat(jtfQuantidade.getText());
            if (jtfQuantidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "A Quantidade não pode ficar em branco ou vazio !!!");
                jtfQuantidade.requestFocus();
            } else if (estoque <= 0) {
                JOptionPane.showMessageDialog(null, "Este Produto não têm no Estoque.");
                jtfCodProd.requestFocus();
                return;
            } else if (qtd > estoque){
                JOptionPane.showMessageDialog(null, "Quantidade Maior que o Estouque!!!");
                return;
            }else{
                vltotal = 0;
                String vlUnitStr = jtfValorUnitario.getText();
                vlUnitStr = vlUnitStr.replace(".", "");
                vlUnitStr = vlUnitStr.replace(",", ".");
                vlUnit = (Float.parseFloat(vlUnitStr));                
                qtd = (Float.parseFloat(jtfQuantidade.getText()));
                vltotal = (qtd * vlUnit);
                subtotal = vltotal;
                jtfValorUnitario.setEnabled(true);
                jtfValorVenda.setEnabled(true);
                jtfSubTotal.setText(String.valueOf(vltotal));
                jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(Float.parseFloat(jtfSubTotal.getText())));                
                jtfSubTotal.setEnabled(true);
                jtfDesconto.setEnabled(true);
                jtfDesconto.requestFocus();
              
            }

        }
    }//GEN-LAST:event_jtfQuantidadeKeyPressed

    private void jtfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyTyped
        String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jtfQuantidadeKeyTyped

    private void jtfValorVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorVendaKeyPressed
        float desconto = 0, vlpago = 0;
        if (evt.getKeyCode() == evt.VK_ENTER){
            vlpago = vltotal;
            if (jtfValorVenda.getText().equals("")){                
                jtfValorVenda.setText(new DecimalFormat("#,##0.00").format(vlpago));
                
            }else {
               desconto = 0;                          
               vlpago = Float.parseFloat(jtfValorVenda.getText());                
               desconto = ((vlpago / vltotal)*100);
               desconto = (100 - desconto);
               jtfDesconto.setText(new DecimalFormat("#,##0.00").format(desconto));
               jtfValorVenda.setText(new DecimalFormat("#,##0.00").format(vlpago));  
               vltotal= vlpago; 
            }
            jbtSalvar.setEnabled(true);
            jbtSalvar.requestFocus(); 
        }  
    }//GEN-LAST:event_jtfValorVendaKeyPressed

    private void jtfValorVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorVendaKeyTyped
        String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jtfValorVendaKeyTyped

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        DefaultTableModel amodel = (DefaultTableModel) VendaCabView.jTable1.getModel();
        
       
        if (jtfQuantidade.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite a Quantidade.");
            jtfQuantidade.requestFocus();
            return;
        }else
            if (jtfCodProd.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Digite o Código do Produto.");
               jtfCodProd.requestFocus();
               return;
            }        
        //Passando Total para o formulário Cabeçalho do Orçamento.
      //  VendaCabView.vltotal = (VendaCabView.vltotal + vltotal);
        VendaCabView.subtotal = (VendaCabView.subtotal + this.subtotal);
        VendaCabView.vltotal = (VendaCabView.vltotal + this.vltotal);
        VendaCabView.contItem = VendaCabView.contItem + 1;
        
        VendaCabView.jtfSubTotal.setText(new DecimalFormat("#,##0.00").format(VendaCabView.subtotal));
     
        //Carrega Tabela do Formulário de Orçamento Cab.
        amodel.addRow(new Object[]{String.valueOf(VendaCabView.contItem), jtfCodProd.getText(), jtfDescricao.getText(), jtfQuantidade.getText(), jtfUnidade.getText(),
            jtfValorUnitario.getText(), jtfDesconto.getText(), jtfValorVenda.getText()});

        limpar();
        habilitar(false);
        jtfPesquisa.setEnabled(true);
        jbtSalvar.setEnabled(false);
        jtfPesquisa.requestFocus();
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSalvarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            jbtSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_jbtSalvarKeyPressed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        // TODO add your handling code here:
        // dispose();
        
        VendaCabView.jbtProduto.setEnabled(true);
        VendaCabView.jtfDesconto.setEnabled(true);
        VendaCabView.jtfDesconto.requestFocus();
        dispose();
        //Habilita o menu de cep.
        //  MenuPrincipal.categoriaMenuItem.setEnabled(true);
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jtfCodProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodProdKeyTyped
        String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jtfCodProdKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void jbtSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtSairKeyPressed
//        if (evt.getKeyCode() == evt.VK_ENTER){
//            OrcamentoCabView.jtfDesconto.requestFocus();
//            dispose();
//        }
    }//GEN-LAST:event_jbtSairKeyPressed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void jtfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyPressed
        float desconto = 0, vlpago =0;
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (jtfDesconto.getText().equals("")){
                jtfDesconto.setText("0.0");
                jtfValorVenda.setEnabled(true);
                jtfValorVenda.requestFocus();
            }else{
                vltotal = (qtd * vlUnit);
                desconto = Float.parseFloat(jtfDesconto.getText());
                vlpago = (vltotal -(vltotal*desconto/100));
                jtfValorVenda.setEnabled(true);
                jtfValorVenda.setText(new DecimalFormat("#,##0.00").format(vlpago));
                vltotal = vlpago;
                jbtSalvar.setEnabled(true);
                jbtSalvar.requestFocus();
            }
                
            
        }
    }//GEN-LAST:event_jtfDescontoKeyPressed

    private void jtfValorVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfValorVendaFocusGained
        jtfValorVenda.setText("");
    }//GEN-LAST:event_jtfValorVendaFocusGained

    private void jtfDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyTyped
        String caracteres="0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }//GEN-LAST:event_jtfDescontoKeyTyped

    private void jtfDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDescontoFocusGained
        jtfDesconto.setText("");
    }//GEN-LAST:event_jtfDescontoFocusGained

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
//            java.util.logging.Logger.getLogger(OrcamentoDetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OrcamentoDetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OrcamentoDetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OrcamentoDetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                OrcamentoDetView dialog = new OrcamentoDetView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    public static javax.swing.JTextField jtfCodProd;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfSubTotal;
    private javax.swing.JTextField jtfUnidade;
    private javax.swing.JTextField jtfValorUnitario;
    private javax.swing.JTextField jtfValorVenda;
    private converter.RowSorterToStringConverter rowSorterToStringConverter1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void carregaTable(){
        List<Produto> listaProduto; 
        DefaultTableModel amodel = (DefaultTableModel) jTable1.getModel();
        amodel.setNumRows(0);
        ProdutoDAO proDAO = new ProdutoDAO();                   
        listaProduto = null;        
        listaProduto = proDAO.listaProdutoAtivo();        
        String valorUnit = null;       
        for (Produto produto : listaProduto){       
            amodel.addRow(new Object[]{produto.getId(),produto.getDescricao(), produto.getEstoque(), produto.getUnidade().getSigla(), produto.getMarca().getDescricao(), produto.getVlVenda(), produto.getCodBarras()});            
        }
        
    }
  
    public void limpar(){
        jtfCodProd.setText("");
        jtfDescricao.setText("");
        jtfQuantidade.setText("");
        jtfPesquisa.setText("");
        jtfValorUnitario.setText("");
        jtfValorVenda.setText("");
        jtfDesconto.setText("");
        jtfSubTotal.setText("");
        jtfUnidade.setText("");
    }
    public void habilitar(boolean habilita){
        jtfCodProd.setEnabled(habilita);
        jtfDescricao.setEnabled(habilita);
        jtfQuantidade.setEnabled(habilita);
        jtfPesquisa.setEnabled(habilita);
        jtfValorUnitario.setEnabled(habilita);
        jtfValorVenda.setEnabled(habilita);
        jtfDesconto.setEnabled(habilita);
        jtfSubTotal.setEnabled(habilita);
        jtfUnidade.setEnabled(habilita);
    }

}
