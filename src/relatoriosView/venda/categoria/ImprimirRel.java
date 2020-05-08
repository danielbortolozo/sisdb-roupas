/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView.venda.categoria;

import dao.CategoriaProdutoDAO;
import dao.EmpresaDAO;
import dao.PedidoDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.CategoriaProduto;
import model.Empresa;
import model.PedidoItens;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author daniel
 */
public class ImprimirRel {
    
    
    private PedidoDAO pedidoDAO;
    private CategoriaProdutoDAO catDAO = new CategoriaProdutoDAO();
    Empresa empresa = new Empresa();
    EmpresaDAO empDAO = new EmpresaDAO();
    
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    private void gerarRelatorioDesktop(JRDataSource jrds,Map<String, Object> parametros,  String arquivo) {
        try {
            JasperPrint print;
            print = JasperFillManager.fillReport(arquivo, parametros, jrds);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void gerarRelatorio(Date dtIni, Date dtFim) {
        
        
        pedidoDAO = new PedidoDAO();
        
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        List listDados  = new ArrayList<>();
        List<PedidoItens> listaPedidoItens = new ArrayList<>();
        PedidoItens pItens = new PedidoItens();
        this.empresa = this.empDAO.getEmpresa();
        
        VendaItensProdutoCategoria vipc = new VendaItensProdutoCategoria();
               
        
        for (CategoriaProduto cat : catDAO.listCategoriaPorOrderDescricao()){
            
            listaPedidoItens = pedidoDAO.listarItensPedidoPorPeriodo(dtIni, dtFim, cat.getDescricao());         
            
            if (!listaPedidoItens.isEmpty()){            
               for (PedidoItens pi : listaPedidoItens ){                
                   total = total.add(pi.getVlSubtotal());               
               }            
               listDados.add(new VendaItensProdutoCategoria(cat.getDescricao(), total.toString()));
               total = new BigDecimal(BigInteger.ZERO);
            }
        }
        
        
        HashMap param = new HashMap();
        String dataini=df.format(dtIni) ;
        String datafim=df.format(dtFim);
        
        param.put("dataini", dataini );
        param.put("datafim", datafim);
        
        param.put("logo", empresa.getLogo());
        
        param.put("empresa_telefone", empresa.getTelefone());
        param.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
        +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
        param.put("empresa_nome", empresa.getNomeFantasia());
        param.put("empresa_cnpj", empresa.getCnpj());
        param.put("empresa_ie", empresa.getIe());      
                
            
            
        String arquivo = "src/relatoriosView/venda/categoria/relVendaProdutoPorCategoria.jasper";
         
        
        JRDataSource jrds = new JRBeanCollectionDataSource(listDados);
       
        gerarRelatorioDesktop(jrds, param, arquivo);
    
    
    
   } 
    
    
}
