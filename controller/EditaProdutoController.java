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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import view.TelaProduto;

/**
 *
 * @author snow
 */
public class EditaProdutoController extends AdicionaProdutoController{
    
    Produto produto = new Produto();
    
    public EditaProdutoController(TelaProduto theView) {
        this.theView = theView;
        // settar os campos de texto com os valores do produto selecionado
        theView.getBtnAdicionar().setVisible(false);
        theView.getBtnAlterar().setVisible(true);
        theView.getBtnExcluir().setVisible(true);
        theView.addBtnAlterarListener(new AlteraProdutoEventListener());
        theView.addBtnExcluirListener(new ExcluiProdutoEventListener());
        theView.setVisible(true);
    }
    
    class AlteraProdutoEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String descricao = theView.getCampoProduto();
            //converte os tipos de dados para, daí, serem adicionados no DAO
            int quantidade = Integer.parseInt(theView.getCampoQuantidade());
            double valor = Double.parseDouble(theView.getCampoValor());
            
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setValor(valor);
            
            try {
                ProdutoDAO dao = new ProdutoDAO();
                boolean alterou = dao.alteraProduto(produto);
                if (alterou) {
                    JOptionPane.showMessageDialog(null, "Produto altero com sucesso!");
                    theView.dispose();
                    //limpar campos, após dispose.
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao alterar produto!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdicionaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class ExcluiProdutoEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //vai ter que pegar o id do produto SELECIONADO
            try {
                ProdutoDAO dao = new ProdutoDAO();
                dao.delProduto(produto.getIdProduto());
            } catch (SQLException ex) {
                Logger.getLogger(ExcluiProdutoEventListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
