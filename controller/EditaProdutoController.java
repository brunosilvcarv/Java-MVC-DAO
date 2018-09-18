/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Produto;
import view.TelaProduto;

/**
 *
 * @author snow
 */
public class EditaProdutoController extends AdicionaProdutoController{
    
    //Produto produto;
    public EditaProdutoController(TelaProduto theView, Produto produto) {
        this.theView = theView;
        //this.produto = produto;
        // settar os campos de texto com os valores do produto selecionado
        theView.getBtnAdicionar().setVisible(false);
        theView.getBtnAlterar().setVisible(true);
        theView.addBtnAlterarListener(new AlteraProdutoEventListener());
        theView.addBtnVoltar(new Voltar());
        theView.setCampoProduto(produto.getDescricao());
        theView.setCampoQuantidade(String.valueOf(produto.getQuantidade()));
        theView.setCampoValor(String.valueOf(produto.getValor()));
        theView.setVisible(true);
       
    }
    
    
    
    class AlteraProdutoEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("alterou");
            
        }
        
    }
    
    class Voltar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
        }
        
    }
}
