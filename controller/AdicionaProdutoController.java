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
public class AdicionaProdutoController {
   
    TelaProduto theView;
   
    public AdicionaProdutoController(TelaProduto theView) {
        this.theView = theView;
        theView.getBtnAlterar().setVisible(false);
        theView.getBtnExcluir().setVisible(false);
        theView.addBtnAdicionarListener(new AdicionaProdutoEventListener());
        theView.addBtnVoltar(new Voltar());
        theView.setVisible(true);
    }
    
    public AdicionaProdutoController() {
        
    }
    
    class AdicionaProdutoEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String descricao = theView.getCampoProduto();
            //converte os tipos de dados para, daí, serem adicionados no DAO
            int quantidade = Integer.parseInt(theView.getCampoQuantidade());
            double valor = Double.parseDouble(theView.getCampoValor());
            
            Produto produto = new Produto();
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setValor(valor);
            
            try {
                ProdutoDAO dao = new ProdutoDAO();
                boolean adicionou = dao.addProduto(produto);
                if (adicionou) {
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                    theView.dispose();
                    //limpar campos, após dispose.
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao adicionar produto!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdicionaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class Voltar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
        }
        
    }
}
