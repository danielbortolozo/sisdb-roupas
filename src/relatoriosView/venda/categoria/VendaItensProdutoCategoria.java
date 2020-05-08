/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.categoria;

import java.math.BigDecimal;




/**
 *
 * @author daniel
 */

public class VendaItensProdutoCategoria {

   
    
    private String categoria;
    private String total;

    public VendaItensProdutoCategoria() {
    }

    public VendaItensProdutoCategoria(String categoria, String total) {
        this.categoria = categoria;
        this.total = total;
    }
    
   
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
    
    
    
    
    
}
