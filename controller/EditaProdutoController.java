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
    
    Produto produto;
    public EditaProdutoController(TelaProduto theView, Produto p) {
        this.theView = theView;
        this.produto = p;
        // carrega componentes da tela
        theView.getBtnAdicionar().setVisible(false);
        theView.getBtnAlterar().setVisible(true);
        theView.addBtnAlterarListener(new AlteraProdutoEventListener());
        theView.addBtnVoltar(new Voltar());
        // preenche os campos com os dados do produto selecionado na tabela
        theView.setCampoProduto(p.getDescricao());
        theView.setCampoQuantidade(String.valueOf(p.getQuantidade()));
        theView.setCampoValor(String.valueOf(p.getValor()));
        theView.setVisible(true);
        
        mostraProduto();
    }
    
    public void mostraProduto(){
        // impressão somente para inspeção
        System.out.println("Produto:");
        System.out.println("id-> "+produto.getIdProduto());
        System.out.println("descricao-> "+produto.getDescricao());
        System.out.println("quantidade-> "+produto.getQuantidade());
        System.out.println("valor-> "+produto.getValor());
    }
    
    
    class AlteraProdutoEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("alterou");
            
            String descricao = theView.getCampoProduto();
            //converte os tipos de dados para, daí, serem adicionados no DAO
            int quantidade = Integer.parseInt(theView.getCampoQuantidade());
            double valor = Double.parseDouble(theView.getCampoValor());
            
            //Produto produto = new Produto();
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setValor(valor);
            
            try {
                ProdutoDAO dao = new ProdutoDAO();
                boolean alterou = dao.alteraProduto(produto);
                if(alterou) {
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                    theView.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto!\nContate o suporte.");
                    theView.dispose();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(EditaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class Voltar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
        }
        
    }
}
