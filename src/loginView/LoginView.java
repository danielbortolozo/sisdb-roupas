/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginView;

import dao.ColaboradorDAO;
import dao.LicencaDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import licencaView.LicencaView;
import menuView.Menu;
import model.Licenca;
import model.Pessoa;
import util.GerarChaveLic;
import static util.GerarChaveLic.descriptografa;

/**
 *
 * @author daniel
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
   Locale locale = new Locale("pt", "BR");
   GregorianCalendar calendar = new GregorianCalendar();
   int verificaLicenca =0;
   int chaveLicenca = 0;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
   Date y = new Date();
    String sy;
   LicencaDAO lDao = new LicencaDAO();
    
    public LoginView() {
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

        painelLogin = new javax.swing.JPanel();
        painelImgCab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelCentral = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        senha = new jpass.JRPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 525));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelLogin.setLayout(new java.awt.BorderLayout());

        painelImgCab.setBackground(new java.awt.Color(8, 5, 2));
        painelImgCab.setPreferredSize(new java.awt.Dimension(410, 400));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundWolf1.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelCentral.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(10, 6, 2));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar2.png"))); // NOI18N
        btnEntrar.setPreferredSize(new java.awt.Dimension(135, 45));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar1.png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        jPanel2.add(btnEntrar);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair2Vermelho.png"))); // NOI18N
        btnSair.setPreferredSize(new java.awt.Dimension(135, 45));
        btnSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair1.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair);

        jLabel2.setBackground(new java.awt.Color(2, 9, 16));
        jLabel2.setForeground(new java.awt.Color(240, 241, 244));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Suporte : (17) 99784-1731 | www.sisdb.com.br");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/userBlack.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, -1, 170));

        usuario.setBackground(new java.awt.Color(2, 11, 16));
        usuario.setBorder(null);
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setPhColor(new java.awt.Color(255, 255, 255));
        usuario.setPlaceholder("USUARIO");
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 180, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginUsBlack.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, 50));

        senha.setBackground(new java.awt.Color(2, 11, 16));
        senha.setBorder(null);
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senha.setName(""); // NOI18N
        senha.setPhColor(new java.awt.Color(255, 255, 255));
        senha.setPlaceholder("SENHA");
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaKeyPressed(evt);
            }
        });
        jPanel1.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginPassBlack.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, 50));

        javax.swing.GroupLayout painelImgCabLayout = new javax.swing.GroupLayout(painelImgCab);
        painelImgCab.setLayout(painelImgCabLayout);
        painelImgCabLayout.setHorizontalGroup(
            painelImgCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImgCabLayout.createSequentialGroup()
                .addComponent(painelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelImgCabLayout.setVerticalGroup(
            painelImgCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImgCabLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelLogin.add(painelImgCab, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelLogin);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        usuario.setText(usuario.getText().toUpperCase());
    }//GEN-LAST:event_usuarioKeyReleased

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            
            if (usuario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite seu Login");
                return;
            }else
                senha.requestFocus();
            
            
        }




    }//GEN-LAST:event_usuarioKeyPressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        ColaboradorDAO colabDAO = new ColaboradorDAO();
       // Pessoa colaborador;  
        
        System.out.println("usuario ="+ usuario.getText());
        System.out.println("senha ="+ senha.getText());
        
        
        
        if (usuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite o Login do Usuário");
            usuario.requestFocus();
            return;
        }
        if (senha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite a senha do Usuário");
            senha.requestFocus();
            return;
        }

        System.out.println("");
         
        if (colabDAO.autenticaColaborador(usuario.getText(), senha.getText())){
            Pessoa colaborador = new Pessoa() {};
            
            validaLicenca(); 
            
            String args[] = new String[2];
           // colab = dao.getColaborador(jtfLogin.getText());
            args[0] = colabDAO.getNome();    
            args[1] = String.valueOf(colabDAO.getId());
            colaborador = colabDAO.colaboradorIDPessoa(colabDAO.getId());
            colaborador.getColaborad().setUltimo_acesso(calendar.getTime());
            colabDAO.registroDataHoraAcesso(colaborador.getColaborad());
            menuView.Menu.colaborador = colaborador;
            Menu.main(args);
            dispose();
        }else{
             int cont = 0;
             cont = cont + 1;
             usuario.setText("");
             senha.setText("");
             JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida !!!");
             usuario.requestFocus();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            if (senha.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite sua senha");                
            }else
                btnEntrar.requestFocus();
        }


    }//GEN-LAST:event_senhaKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            String op = System.getProperty("os.name");
            if (!"Linux".equals(op))
            btnEntrarActionPerformed(null);
        } 
        
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void validaLicenca(){
        verificaLicenca = 0;
        Licenca licenca = lDao.licenca();
        sy = sdf.format(y);
        int atual = Integer.parseInt(sy);        
        try{
            if (licenca.getInstalacao() == 0 ){
                String dtStr;
                String chave;
                Calendar c = Calendar.getInstance();
                c.setTime(y);
                c.add(Calendar.DATE, +31);
               // c.add(Calendar.DATE, 0);
                Date dtChave = new Date();
                dtChave = c.getTime();
                dtStr = sdf.format(dtChave);
                chave = GerarChaveLic.criptografia(dtStr);               
                System.out.println("A data da chave é :"+dtStr);
                System.out.println("A chave é :"+chave);            
                
                licenca.setInstalacao(1);
                licenca.setPwd(chave);
                lDao.salvar(licenca);                
            }       
            
        chaveLicenca = (Integer.parseInt(descriptografa(licenca.getPwd())));       
        if (chaveLicenca < atual){
            verificaLicenca = 1;
            LicencaView l = new LicencaView(new java.awt.Frame(), true);
            l.setLocationRelativeTo(null); // centraliza a tela
            l.setVisible(true);
            dispose();
            System.exit(0);
        }else
            if (chaveLicenca == atual)
                JOptionPane.showMessageDialog(null, "Seu Sistema será Cancelado Amanhã");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Código Serial Inválido");
            System.exit(0);
        }
    }
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelImgCab;
    private javax.swing.JPanel painelLogin;
    private jpass.JRPasswordField senha;
    private app.bolivia.swing.JCTextField usuario;
    // End of variables declaration//GEN-END:variables
}
