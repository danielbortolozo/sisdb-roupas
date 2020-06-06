/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author daniel
 */
public class CarregadorDesktop extends JDesktopPane {
    
    Image img = new ImageIcon(getClass().getResource("/imagens/background.jpeg")).getImage();
    
    @Override
    public void paintChildren(Graphics g){
        
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
        super.paintChildren(g);
        
        
    }
    
}
