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
import view.TelaProdutoLista;

/**
 *
 * @author Aluno
 */
public class AreaCompraController {
    
    
    TelaCompra view;
    Produto produto;
    
    public AreaCompraController(TelaCompra theView) {
        this.view = theView;
        view.addBtnAdicionarListener(new AcaoBotaoAdicionar());
        view.addBtnCalculaListener(new AcaoBotaoAdicionar());
        view.addBtnLimparListener(new AcaoBotaoLimpar());
        view.addBtnMinhasComprasListener(new AcaoBotaoMinhasCompras());
        view.addBtnVoltarListener(new VoltaTelaInicial());
        view.setVisible(true);
    }
    
    public void carregaTabela() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        TableModelProdutos modelo = new TableModelProdutos(dao.consultaProduto(produto));
        view.getTabelaProdutos().setModel(modelo);
        view.getTabelaProdutos().setVisible(true);
    }
            
            
    //------------- classes ----------------------
    class AcaoBotaoAdicionar implements ActionListener{ 

        @Override
        public void actionPerformed(ActionEvent e) {
            
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
            view.dispose();
        }
        
    }
}
