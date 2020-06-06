/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosView;

import conexao.ConnectionFactory;
import dao.EmpresaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.ProdutoDAO;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.CompraCab;
import model.Empresa;
import model.OrcamentoCab;
import model.Pedido;
import model.PedidoItens;
import model.Pessoa;
import model.Produto;
import model.VendaCab;
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import relatoriosView.caixa.RelCaixa;
import relatoriosView.crediario.CrediarioRel;
import relatoriosView.creditocliente.CreditoCliente;
import relatoriosView.venda.PedidoRel;

/**
 *
 * @author daniel
 */
public class ImprimeRelatorio {

    private Connection conn;
    DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Empresa empresa = new Empresa();
    EmpresaDAO empDAO = new EmpresaDAO();
    public ImprimeRelatorio()  {
      
    }

    public void conexao() throws Exception{
         try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso! Classe: ImprimeRelatorio.");
        } catch (Exception e) {
            throw new Exception("Problemas ao conectar no,banco de dados!Erro:" + e.getMessage());
        }
    }
    
    
    public void relatorioProduto() throws SQLException {
        try {
            conexao();
            ResultSet rs = null;
            Statement stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            // String sql= "select p.id, p.descricao, m.descricao as marca from produto p, marca_produto m ";
            String sql = "SELECT  p.vl_venda,p.estoque,p.id,p.cod_interno,"
                    + "p.codigo_original,p.descricao,m.descricao AS marca FROM "
                    + "produto p,marca_produto m WHERE m.id = p.id_marca order by p.descricao";
                
            rs = stmt.executeQuery(sql);
            InputStream is = getClass().getResourceAsStream("Produtos.jasper");
            
            JRResultSetDataSource relatResult = new JRResultSetDataSource(rs);
            JasperPrint jp = null;
            jp = JasperFillManager.fillReport(is, new HashMap(), relatResult);
            JasperViewer jv = new JasperViewer(jp, false);
            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }
    
    public void relatorioProdutoJPA() throws JRException{
       List listaDados = new ArrayList();
        Map parametros = new HashMap();
        ProdutoRel relProduto = new ProdutoRel();
        ProdutoDAO daoProduto = new ProdutoDAO();
        List<Produto> produtos = new ArrayList();
        produtos = daoProduto.listaProduto();
        this.empresa = this.empDAO.getEmpresa();
        for (Produto prod : produtos ){
            relProduto.setCod_interno(prod.getCod_interno());
    //        relProduto.setCodigo_original(prod.getCod_original());
            relProduto.setDescricao(prod.getDescricao());
            relProduto.setMarca(prod.getMarca().getDescricao());
            relProduto.setVl_venda(new DecimalFormat("#,##0.00").format(prod.getVlVenda()));
            relProduto.setEstoque(new DecimalFormat("#,##0.00").format(prod.getEstoque()));
            
            if(prod.getStatus() == 0)
            relProduto.setStatus("ATIVO");
            else
                if (prod.getStatus() == 1)
                    relProduto.setStatus("INATIVO");
            
            
           listaDados.add(new ProdutoRel(relProduto.getCod_interno(), relProduto.getDescricao(), relProduto.getMarca(),
           relProduto.getEstoque(), relProduto.getVl_venda(), relProduto.getStatus()));            
        }
       
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
        +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        
//        parametros.put("status", status);
//        parametros.put("tipoPesquisa", tipoPesquisa);
//        InputStream logo = getClass().getResourceAsStream("img/logoPinheiro1.png");
//       
//        if (logo == null)
//            JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
//        parametros.put("logo", logo); 
        
        InputStream is = getClass().getResourceAsStream("Produtos.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, parametros, relat);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);     
        
    }
    
    public void relatorioVendaPorPeriodo(List<PedidoRel> lista, String tipo, String dtIni, String dtFim, String total ) throws JRException{
        Map parametros = new HashMap();
        
        this.empresa = this.empDAO.getEmpresa();
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        parametros.put("tipo", tipo);
        parametros.put("dtIni", dtIni);
        parametros.put("dtFim", dtFim);
       
        parametros.put("totalGeral", total);
        
        //Totais
//        parametros.put("totalEntrada", totalEntrada);
//        parametros.put("totalSaida", totalSaida);
//        parametros.put("totalSaldoFinal", totalSaldoFinal);
        
               
        InputStream is = getClass().getResourceAsStream("/relatoriosView/venda/RelatorioVenda.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(lista);
        
        JasperPrint jp = null;
       
        jp = JasperFillManager.fillReport(is, parametros, relat);
        
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);         
        
    }
    
    public void creditoCliente(List<CreditoCliente> lista, String vlDevolucao, String vlTroca, String credito,
            String nome, String cpf) throws JRException{
        Map parametros = new HashMap();
        
        this.empresa = this.empDAO.getEmpresa();
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        
        parametros.put("vlDevolucao", vlDevolucao);
        parametros.put("vlTroca", vlTroca);
        parametros.put("creditoDebito", credito);
        parametros.put("cliente", nome);
        parametros.put("cpf", cpf);
        
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Troca/Devolução de Mercadorias.", true); 
        viewer.setSize(800,600); 
        viewer.setLocationRelativeTo(null); 
        viewer.setResizable(true);
        
        InputStream is = getClass().getResourceAsStream("/relatoriosView/creditocliente/creditoCliente.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(lista);
        
        JasperPrint jp = null;
       
        jp = JasperFillManager.fillReport(is, parametros, relat);
        
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
       
        //Adiciona o Relatorio no JDialog.        
        viewer.getContentPane().add(jv.getContentPane()); 
        viewer.setVisible(true);   
              
    }
    
    
    
    public void relatorioCrediario(List<CrediarioRel> listaCrediario, String vlTotal) throws JRException, ParseException{
        Map parametros = new HashMap();
        CrediarioRel crediario = new CrediarioRel();
        GregorianCalendar calendar = new GregorianCalendar();
        String vlporExtenso = null;
        Calendar cal = Calendar.getInstance();
        //Date por Extenso
        Locale local = new Locale("pt","BR");        
        DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
        cal = cal.getInstance();
//int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
//int mes = calendar.get(GregorianCalendar.MONTH);
        
     //   ultimoCrediario = listaCrediario.get(listaCrediario.size()-1);
        this.empresa = this.empDAO.getEmpresa();
       // parametros.put("logo", empresa.getLogo());
        
        parametros.put("telefone", empresa.getTelefone());
        parametros.put("endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        
        
        parametros.put("nomeFantasia", empresa.getNomeFantasia());
      //  parametros.put("ndoc", crediario.getDocumento());
        
        
       
       // parametros.put("vencimentoPromissoria", crediario.getVencimento());
        parametros.put("cnpjEmpresa", empresa.getCnpj());
      //  parametros.put("valor", vlTotal);
     //   double valorTotal = 0;
     //   vlTotal = vlTotal.replace(".", "");
     //   vlTotal = vlTotal.replace(",", ".");
      //  valorTotal = Double.parseDouble(vlTotal);
           
       // parametros.put("valorExtenso", vlporExtenso);
        
        
        //Pegar o dia do vencimento          
       // cal.setTime(sdf.parse(crediario.getVencimento()));
                
        String mesStr = dateFormat.format(cal.getTime());       
       // parametros.put("dataVencimentoExtenso", mesStr);
                
       // mesStr = dateFormat.format(cal.getTime());
        parametros.put("dataAtualExtenso", mesStr);
        parametros.put("cidade", this.empresa.getCidade());
               
        InputStream logo = getClass().getResourceAsStream("img/republicaFederativa4.png");
//       
//        if (logo == null)
//            JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
//parameter.put("IMAGE",new FileInputStream("C:/suaPasta/suaImagem.jpg"));
        parametros.put("logoPromissoria", logo); 
        
    //    InputStream icone = (new ImageIcon("img/republicaFederativa4.png")).getImage();
   //       parametros.put("logoPromissoria", icone); 
        
        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Carnê Crediário.", true); 
        viewer.setSize(800,600); 
        viewer.setLocationRelativeTo(null); 
        viewer.setResizable(true);

        InputStream is = getClass().getResourceAsStream("/relatoriosView/crediario/carne.jasper");            
                  
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaCrediario);
        JasperPrint jp = null;
           
        jp = JasperFillManager.fillReport(is, parametros, relat);
        JasperViewer jv = new JasperViewer(jp, true);
        // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); 
        
        //Adiciona o Relatorio no JDialog.        
        viewer.getContentPane().add(jv.getContentPane()); 
        viewer.setVisible(true);   



        
        
    }

//    public void reciboVenda(VendaCab venda, String cliente, String operador) {
//        List listaDados = new ArrayList();
//        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
//        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
//        ReciboVenda reciboVenda = new ReciboVenda();
//        Map parametros = new HashMap();
//        for (int i = 0; i < venda.getListaItens().size(); i++) {
//            reciboVenda.setCodigoProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getId()));
//            reciboVenda.setDescricaoProduto(venda.getListaItens().get(i).getProduto().getDescricao());
//            reciboVenda.setQtdProduto(String.valueOf(venda.getListaItens().get(i).getQuantidade()));
//            reciboVenda.setUndProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getUnidade().getSigla()));
//            reciboVenda.setVlUnit(new DecimalFormat("#,##0.0000").format(venda.getListaItens().get(i).getVl_unitario()));
//            reciboVenda.setVlTotal(new DecimalFormat("#,##0.00").format(venda.getListaItens().get(i).getVl_total()));
//            //Lista de Dados.
//            listaDados.add(new ReciboVenda(reciboVenda.getCodigoProduto(), reciboVenda.getDescricaoProduto(), reciboVenda.getQtdProduto(),
//                    reciboVenda.getUndProduto(), reciboVenda.getVlUnit(), reciboVenda.getVlTotal()));
//        }
//        try {            
//            parametros.put("cliente", cliente);
//            parametros.put("operador", operador);
//            parametros.put("desconto", String.valueOf(venda.getDesconto()));
//            parametros.put("idVenda", venda.getId().toString());
//            String subTotalStr = null;
//            subTotalStr = new DecimalFormat("#,##0.00").format(venda.getSubtotal());
//            parametros.put("subTotal", subTotalStr);
//            String totalStr = null;
//            totalStr = new DecimalFormat("#,##0.00").format(venda.getTotal());
//            parametros.put("total", totalStr);
//            if (venda.getCliente().getTipo().equals("F")) {
//                parametros.put("cpf", daoPF.pessoaFisica(venda.getCliente().getId()).getCpf());
//            } else if (venda.getCliente().getTipo().equals("J")) {
//               // System.out.println("CNPJ ="+daoPJ.pessoaJuridica(venda.getCliente().getPessoa().getId()).getCnpj());
//                parametros.put("cpf", daoPJ.pessoaJuridica(venda.getCliente().getId()).getCnpj());
//               
//            }
//            InputStream is = getClass().getResourceAsStream("ReciboVenda.jasper");
//            JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
//            JasperPrint jp = null;
//            jp = JasperFillManager.fillReport(is, parametros, relat);
//            JasperViewer jv = new JasperViewer(jp, false);
//            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
//            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
//            jv.setVisible(true);
//        } catch (JRException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    
    
    public void vendaPorCliente(String operador, Pessoa pessoa) throws SQLException, JRException, Exception {
        conexao();
        ResultSet rs = null;
        try{
            System.out.println("Cliente ="+pessoa.getId());    
        Statement stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);       
       // String sql = "select p.id, p.nome, p.email, pf.cpf, c.datacadastro FROM pessoa p, pessoa_fisica pf, cliente c where p.id=c.pessoa_id and p.id=pf.pessoa_id";                
        String sql = "select pe.id, pi.dt, sum(pi.vl_subtotal)   FROM pessoa p, pedido pe, pedido_itens pi "+ 
                     "where p.id=pe.id_cliente and pe.id=pi.id_pedido and pe.id_cliente=:cliente group by pe.id";             

      //  PreparedStatement stmt = conn.prepareStatement(sql);
       // stmt.setString(1, cliente);
        rs = stmt.executeQuery(sql);
           
            System.out.println("Relatorio por Cliente :"+rs.toString());
        Map parametros = new HashMap();
        parametros.put("operador", operador);
        parametros.put("nome", pessoa.getNome());

        InputStream is = getClass().getResourceAsStream("VendaPorCliente.jasper");
        
        JRResultSetDataSource relatResult = new JRResultSetDataSource(rs);
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, parametros, relatResult);
        JasperViewer jv = new JasperViewer(jp, false);
        // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não tem relatório para este cliente.");
            e.printStackTrace();
        }

    }
    
    public void relatorioProduto(List<Produto> produtos, String status, String tipoPesquisa) throws JRException{
        List listaDados = new ArrayList();
       
        ProdutoRel relProduto = new ProdutoRel();
        
        for (Produto prod : produtos ){
            relProduto.setId(String.valueOf(prod.getId()));
            relProduto.setCod_interno(String.valueOf(prod.getCod_interno()));
            relProduto.setDescricao(prod.getDescricao());
            relProduto.setUnidade(prod.getUnidade().getSigla());
            relProduto.setMarca(prod.getMarca().getDescricao());
//            relProduto.setModelo(prod.getModelo());
            relProduto.setPeso(prod.getPeso());
            relProduto.setEstoque(String.valueOf(prod.getEstoque()));
            relProduto.setPreco(String.valueOf(prod.getVlVenda()));
            listaDados.add(new ProdutoRel(relProduto.getId(), relProduto.getCod_interno(), relProduto.getDescricao(),relProduto.getUnidade(), relProduto.getMarca(),
            relProduto.getPeso(), relProduto.getEstoque(), relProduto.getPreco()));            
        }
        // cabecalhoRelatorio(status, tipoPesquisa);
        Map parametros = new HashMap();
        
        this.empresa = this.empDAO.getEmpresa();
        parametros.put("status", status);
        parametros.put("tipoPesquisa", tipoPesquisa);
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        
        
       // InputStream logo = getClass().getResourceAsStream("img/logoPinheiro1.png");
       
       // if (logo == null)
       //     JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
       // parametros.put("logo", logo); 
        
        InputStream is = getClass().getResourceAsStream("RelatorioProduto_1.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, parametros, relat);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);        
        
    }    

    
    public void historicoCaixa(List<RelCaixa> listaHistCaixa, String totalEntrada, String totalSaida, String totalSaldoFinal) throws JRException{
       
        Map parametros = new HashMap();
        
        this.empresa = this.empDAO.getEmpresa();
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        //Totais
        parametros.put("totalEntrada", totalEntrada);
        parametros.put("totalSaida", totalSaida);
        parametros.put("totalSaldoFinal", totalSaldoFinal);
        
               
        InputStream is = getClass().getResourceAsStream("/relatoriosView/caixa/caixa.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaHistCaixa);
        
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, parametros, relat);
        
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);          
    }
    
    
    
    //private Map parametros(String status, String tipoPesquisa) {
       
   // }
    
    public void compraPeriodoDeEmissao(List<CompraCab> listaCompra, String dataIni, String dataFim) throws JRException{
        List listaDados = new ArrayList();
        Map parametros = new HashMap();        
        CompraCabRel compraRel = new CompraCabRel();
        float totalGeral = 0;
        for(CompraCab compra : listaCompra){
            compraRel.setNum_doc(compra.getNum_doc());
            compraRel.setDescricao(compra.getDescricao());
            compraRel.setFornecedor(compra.getFornecedor().getNome());
            compraRel.setEmissao(df.format(compra.getEmissao()));
            compraRel.setSubtotal(new DecimalFormat("#,##0.00").format(compra.getSubtotal()));
            compraRel.setDesconto(String.valueOf(compra.getDesconto()));
            compraRel.setTotal(new DecimalFormat("#,##0.00").format(compra.getVltotal()));
            totalGeral = (totalGeral + compra.getVltotal());
            listaDados.add(new CompraCabRel(compraRel.getNum_doc(), compraRel.getDescricao(), compraRel.getFornecedor(),
            compraRel.getEmissao(), compraRel.getSubtotal(), compraRel.getDesconto(), compraRel.getTotal()));
        }
        String total_str = null;
        total_str = (new DecimalFormat("#,##0.00").format(totalGeral));
        parametros.put("totalGeral", total_str);
        parametros.put("dataInicial", dataIni);
        parametros.put("dataFinal", dataFim);
       
        this.empresa = this.empDAO.getEmpresa();
       // parametros.put("status", status);
       // parametros.put("tipoPesquisa", tipoPesquisa);
        parametros.put("logo", empresa.getLogo());
        
        parametros.put("empresa_telefone", empresa.getTelefone());
        parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
                +" - "+empresa.getCidade()+" - "+empresa.getEstado());
        parametros.put("empresa_nome", empresa.getNomeFantasia());
        parametros.put("empresa_cnpj", empresa.getCnpj());
        parametros.put("empresa_ie", empresa.getIe());
        
        
        
        //InputStream logo = getClass().getResourceAsStream("img/InfoCell.png");
       
//        if (logo == null)
//            JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
//        parametros.put("logo", logo); 
//        
        InputStream is = getClass().getResourceAsStream("compra/CompraPorPeriodoDeEmissao.jasper");              
        
        JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
        JasperPrint jp = null;
        jp = JasperFillManager.fillReport(is, parametros, relat);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jv.setVisible(true);      
        
    }
    
    public void reciboVendaAVista(VendaCab venda, String cliente, String operador, String recebido, String troco, String tipoPagto) throws ParseException {        
        List listaDados = new ArrayList();
        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        ReciboVenda reciboVenda = new ReciboVenda();
        Map parametros = new HashMap();
        for (int i = 0; i < venda.getListaItens().size(); i++) {
            reciboVenda.setCodigoProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getId()));
            reciboVenda.setDescricaoProduto(venda.getListaItens().get(i).getProduto().getDescricao());
            reciboVenda.setQtdProduto(String.valueOf(venda.getListaItens().get(i).getQuantidade()));
            reciboVenda.setUndProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getUnidade().getSigla()));
            reciboVenda.setVlUnit(new DecimalFormat("#,##0.0000").format(venda.getListaItens().get(i).getVl_unitario()));
            reciboVenda.setVlTotal(new DecimalFormat("#,##0.00").format(venda.getListaItens().get(i).getVl_total()));
            reciboVenda.setDesconto(new DecimalFormat("#,##0.00").format(venda.getListaItens().get(i).getDesconto()));
            //Lista de Dados.
            listaDados.add(new ReciboVenda(reciboVenda.getCodigoProduto(), reciboVenda.getDescricaoProduto(), reciboVenda.getQtdProduto(),
                    reciboVenda.getUndProduto(), reciboVenda.getVlUnit(), reciboVenda.getVlTotal(), reciboVenda.getDesconto()));
        }
        try {            
            parametros.put("cliente", cliente);
            parametros.put("operador", operador);
            parametros.put("desconto", String.valueOf(venda.getDesconto()));
            parametros.put("idVenda", venda.getId().toString());         
            parametros.put("vlTroco", troco);
            parametros.put("vlRecebido", recebido);
            parametros.put("tipoVenda", venda.getTipoVenda());
            String subTotalStr = null;
            subTotalStr = new DecimalFormat("#,##0.00").format(venda.getSubtotal());
            parametros.put("subTotal", subTotalStr);
            parametros.put("tipoPagto", tipoPagto);
            String totalStr = null;
            totalStr = new DecimalFormat("#,##0.00").format(venda.getTotal());
            parametros.put("total", totalStr);
            if (venda.getCliente().getTipo().equals("F")) {
               String cpf = daoPF.pessoaFisica(venda.getCliente().getId()).getCpf();
               String mascara = "###.###.###-##";                
               if (cpf == null)
                   cpf = "00000000000";
               cpf = formatarString(cpf,mascara );                 
               parametros.put("cpf", cpf);
            } else if (venda.getCliente().getTipo().equals("J")) {               
               String cnpj = daoPJ.pessoaJuridica(venda.getCliente().getId()).getCnpj();
               String mascara = "##.###.###/####-##";
               if (cnpj == null)
                   cnpj = "00000000000000";               
               cnpj = formatarString(cnpj,mascara );
               parametros.put("cpf",cnpj);               
            }
            InputStream is = getClass().getResourceAsStream("ReciboDeVenda.jasper");
            InputStream logo = getClass().getResourceAsStream("img/logoPinheiro1.png"); 
            if (logo == null)
                JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
            parametros.put("logo", logo);
            
            JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
            JasperPrint jp = null;
            jp = JasperFillManager.fillReport(is, parametros, relat);
            JasperViewer jv = new JasperViewer(jp, false);
            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String formatarString(String texto, String mascara) throws ParseException {
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }
    public void reciboVendaAPrazo(VendaCab venda, String cliente, String operador) throws ParseException {
        List listaDados = new ArrayList();
        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        ReciboVenda reciboVenda = new ReciboVenda();
        Map parametros = new HashMap();
      
        for (int i = 0; i < venda.getListaItens().size(); i++) {
            reciboVenda.setCodigoProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getId()));
            reciboVenda.setDescricaoProduto(venda.getListaItens().get(i).getProduto().getDescricao());
            reciboVenda.setQtdProduto(String.valueOf(venda.getListaItens().get(i).getQuantidade()));
            reciboVenda.setUndProduto(String.valueOf(venda.getListaItens().get(i).getProduto().getUnidade().getSigla()));
            reciboVenda.setVlUnit(new DecimalFormat("#,##0.0000").format(venda.getListaItens().get(i).getVl_unitario()));
            reciboVenda.setVlTotal(new DecimalFormat("#,##0.00").format(venda.getListaItens().get(i).getVl_total()));
            reciboVenda.setDesconto(new DecimalFormat("#,##0.00").format(venda.getListaItens().get(i).getDesconto()));
            //Lista de Dados.
            listaDados.add(new ReciboVenda(reciboVenda.getCodigoProduto(), reciboVenda.getDescricaoProduto(), reciboVenda.getQtdProduto(),
                    reciboVenda.getUndProduto(), reciboVenda.getVlUnit(), reciboVenda.getVlTotal(), reciboVenda.getDesconto()));
        }
        try {  
            
            parametros.put("cliente", cliente);
            parametros.put("operador", operador);
            parametros.put("desconto", String.valueOf(venda.getDesconto()));
            parametros.put("idVenda", venda.getId().toString()); 
            parametros.put("parcelas", String.valueOf(venda.getParcelas()));
            parametros.put("vencimento", sdf.format(venda.getVencimento()));
          //  parametros.put("vlTroco", troco);
         //   parametros.put("vlRecebido", recebido);
            parametros.put("tipoVenda", venda.getTipoVenda());
            String subTotalStr = null;
            subTotalStr = new DecimalFormat("#,##0.00").format(venda.getSubtotal());
            parametros.put("subTotal", subTotalStr);
          //  parametros.put("tipoPagto", tipoPagto);
            String totalStr = null;
            totalStr = new DecimalFormat("#,##0.00").format(venda.getTotal());
            parametros.put("total", totalStr);
            if (venda.getCliente().getTipo().equals("F")) {
               String cpf = daoPF.pessoaFisica(venda.getCliente().getId()).getCpf();
               String mascara = "###.###.###-##";                
               if (cpf == null)
                   cpf = "00000000000";
               cpf = formatarString(cpf,mascara );                 
               parametros.put("cpf", cpf);
            } else if (venda.getCliente().getTipo().equals("J")) {               
               String cnpj = daoPJ.pessoaJuridica(venda.getCliente().getId()).getCnpj();
               String mascara = "##.###.###/####-##";
               if (cnpj == null)
                   cnpj = "00000000000000";               
               cnpj = formatarString(cnpj,mascara );
               parametros.put("cpf",cnpj);               
            }
            InputStream is = getClass().getResourceAsStream("ReciboVendaPrazo.jasper");
            InputStream logo = getClass().getResourceAsStream("img/logoPinheiro1.png"); 
            if (logo == null)
                JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
            parametros.put("logo", logo);
            
            JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
            JasperPrint jp = null;
            jp = JasperFillManager.fillReport(is, parametros, relat);
            JasperViewer jv = new JasperViewer(jp, false);
            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void orcamento(OrcamentoCab orcamento, String cliente, String operador) throws ParseException {
        List listaDados = new ArrayList();
        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        ReciboVenda reciboVenda = new ReciboVenda();
        Map parametros = new HashMap();
      
        for (int i = 0; i < orcamento.getListOrcamentoDet().size(); i++) {
            
            reciboVenda.setCodigoProduto(String.valueOf(orcamento.getListOrcamentoDet().get(i).getProduto().getId()));
            reciboVenda.setDescricaoProduto(orcamento.getListOrcamentoDet().get(i).getProduto().getDescricao());
            reciboVenda.setQtdProduto(String.valueOf(orcamento.getListOrcamentoDet().get(i).getQuantidade()));
            reciboVenda.setUndProduto(String.valueOf(orcamento.getListOrcamentoDet().get(i).getProduto().getUnidade().getSigla()));
            reciboVenda.setVlUnit(new DecimalFormat("#,##0.0000").format(orcamento.getListOrcamentoDet().get(i).getVl_unitario()));
            reciboVenda.setVlTotal(new DecimalFormat("#,##0.00").format(orcamento.getListOrcamentoDet().get(i).getVl_total()));
            reciboVenda.setDesconto(new DecimalFormat("#,##0.0").format(orcamento.getListOrcamentoDet().get(i).getDesconto()));
            
            //Lista de Dados.
            listaDados.add(new ReciboVenda(reciboVenda.getCodigoProduto(), reciboVenda.getDescricaoProduto(), reciboVenda.getQtdProduto(),
                    reciboVenda.getUndProduto(), reciboVenda.getVlUnit(), reciboVenda.getVlTotal(), reciboVenda.getDesconto()));
        }
        try {  
            this.empresa = empDAO.getEmpresa();
            parametros.put("cliente", cliente);           
            parametros.put("operador", operador);
            parametros.put("idOrcamento", String.valueOf(orcamento.getId()));
            parametros.put("desconto", String.valueOf(orcamento.getDesconto()));
        
            parametros.put("empresa_telefone", empresa.getTelefone());
            parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
            +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
            parametros.put("empresa_nome", empresa.getNomeFantasia());
            parametros.put("empresa_cnpj", empresa.getCnpj());
            parametros.put("empresa_ie", empresa.getIe());
        
            String subTotalStr = null;
            subTotalStr = new DecimalFormat("#,##0.00").format(orcamento.getSubtotal());
            parametros.put("subTotal", subTotalStr);
                        
            String totalStr = null;
            totalStr = new DecimalFormat("#,##0.00").format(orcamento.getVl_total());
            parametros.put("total", totalStr);
            
//            if (orcamento.getCliente().getTipo().equals("F")) {               
//               String cpf = daoPF.pessoaFisica(orcamento.getCliente().getId()).getCpf();                
//               String mascara = "###.###.###-##";                
//               if (cpf == null)
//                   cpf = "00000000000";
//               cpf = formatarString(cpf,mascara );                 
//               parametros.put("cpf", cpf);                
//            } else if (orcamento.getCliente().getTipo().equals("J")) {               
//               String cnpj = daoPJ.pessoaJuridica(orcamento.getCliente().getId()).getCnpj();
//               String mascara = "##.###.###/####-##";
//               if (cnpj == null)
//                   cnpj = "00000000000000";               
//               cnpj = formatarString(cnpj,mascara );
//               parametros.put("cpf",cnpj);               
//            }
            InputStream is = getClass().getResourceAsStream("Orcamento.jasper");            
         //   InputStream logo = getClass().getResourceAsStream("img/logoPinheiro1.png"); 
            if (empresa.getLogo() == null)
                JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
            parametros.put("logo", empresa.getLogo());
            
            JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
            JasperPrint jp = null;
           
            jp = JasperFillManager.fillReport(is, parametros, relat);
           
            JasperViewer jv = new JasperViewer(jp, false);
            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    public void pedido(Pedido pedido, String cliente, String operador, String subTotal, String total, 
            String acrescimo, String desconto, String troco) throws ParseException {
        List listaDados = new ArrayList();
        PessoaFisicaDAO daoPF = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoPJ = new PessoaJuridicaDAO();
        ReciboVenda reciboVenda = new ReciboVenda();
        Map parametros = new HashMap();
                
        if (cliente.equals(""))
            cliente = "CONSUMIDOR";
             
        PedidoVenda pVenda = new PedidoVenda();
        
        for (PedidoItens pItens : pedido.getListaItens()){
            pVenda.setDescricaoProduto(pItens.getProduto().getDescricao());
            pVenda.setQtdProduto(String.valueOf(pItens.getQuantidade()));
           // pVenda.setVlUnit(String.valueOf(pItens.getProduto().getVlVenda()));
            pVenda.setVlUnit(new DecimalFormat("#,##0.00").format(pItens.getVlUnit()));
            pVenda.setSubtotal(new DecimalFormat("#,##0.00").format(pItens.getVlSubtotal()));
            listaDados.add(new PedidoVenda(pVenda.getDescricaoProduto(), pVenda.getVlUnit(),
            pVenda.getSubtotal(), pVenda.getQtdProduto(), pVenda.getIdProduto()));            
        }      
        try {  
            this.empresa = empDAO.getEmpresa();
            parametros.put("cliente", cliente);           
            parametros.put("operador", operador);
            parametros.put("idOrcamento", String.valueOf(pedido.getId()));
            parametros.put("desconto", desconto);
            parametros.put("subTotal", subTotal);
            parametros.put("total", total);
            parametros.put("acrescimo", acrescimo);
            parametros.put("troco", troco);
        
            parametros.put("empresa_telefone", empresa.getTelefone());
            parametros.put("empresa_endereco", empresa.getLogradouro()+" , "+empresa.getNumero()+" - "+empresa.getBairro()
            +" - "+empresa.getCidade()+" - "+empresa.getEstado());        
            parametros.put("empresa_nome", empresa.getNomeFantasia());
            parametros.put("empresa_cnpj", empresa.getCnpj());
            parametros.put("empresa_ie", empresa.getIe());
            
            
//            if (empresa.getLogo() == null)
//                JOptionPane.showMessageDialog(null, "Imagem nao encontrada");
            parametros.put("logo", empresa.getLogo());

            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true); 
            viewer.setSize(800,600); 
            viewer.setLocationRelativeTo(null); 
            viewer.setResizable(true);

            InputStream is = getClass().getResourceAsStream("PedidoVenda.jasper");            
                  
            JRBeanCollectionDataSource relat = new JRBeanCollectionDataSource(listaDados);
            JasperPrint jp = null;
           
            jp = JasperFillManager.fillReport(is, parametros, relat);
            JasperViewer jv = new JasperViewer(jp, true);
            // jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);         
            viewer.getContentPane().add(jv.getContentPane()); 
            viewer.setVisible(true);                    
            //jv.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);           
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
}
