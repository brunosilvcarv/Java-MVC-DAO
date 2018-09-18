/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.Produto;
import view.TableModelProdutos;
import view.TelaCompra;

/**
 *
 * @author Aluno
 */
public class AreaCompraController {
    
    
    TelaCompra theView;
    Produto produto;
    Produto p = new Produto();
    int linha;
    
    public AreaCompraController(TelaCompra theView) {
        this.theView = theView;
        this.theView.addBtnAdicionarListener(new AcaoBotaoAdicionar());
        this.theView.addBtnCalculaListener(new AcaoBotaoAdicionar());
        this.theView.addBtnLimparListener(new AcaoBotaoLimpar());
        this.theView.addBtnMinhasComprasListener(new AcaoBotaoMinhasCompras());
        this.theView.addBtnVoltarListener(new VoltaTelaInicial());
        this.theView.setVisible(true);
    }
    
    public void carregaTabela() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        TableModelProdutos modelo = new TableModelProdutos(dao.consultaProduto(produto));
        theView.getTabelaProdutos().setModel(modelo);
        theView.getTabelaProdutos().setVisible(true);
    }
    
    public void pegaObjetoDaTabela() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        TableModelProdutos modelo = new TableModelProdutos(dao.consultaProduto(produto));
        linha = theView.getTabelaProdutos().getSelectedRow();
        produto = modelo.getObjeto(linha);
        p.setIdProduto(produto.getIdProduto());
        p.setDescricao(produto.getDescricao());
        p.setQuantidade(produto.getQuantidade());
        p.setValor(produto.getValor());
    }
            
    //------------- classes ----------------------
    class AcaoBotaoAdicionar implements ActionListener{ 

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("adicionando produto ao campo de texto");
            try {
                ProdutoDAO dao = new ProdutoDAO();
                pegaObjetoDaTabela();
                String texto = p.getDescricao() + " - "
                        + String.valueOf(p.getQuantidade()) + " - "
                        + String.valueOf(p.getValor());
                theView.setCampoTexto(texto);
            } catch (SQLException ex) {
            }
        }
    }
    
    class AcaoBotaoCalcular implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class AcaoBotaoLimpar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class AcaoBotaoMinhasCompras implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class VoltaTelaInicial implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
        }
        
    }
}
