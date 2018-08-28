/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import view.TableModelProdutos;
import view.TelaProduto;
import view.TelaProdutoLista;

/**
 *
 * @author snow
 */
public class ListaProdutoController {
    
    TelaProdutoLista theView;
    Produto produto;
    
    public ListaProdutoController(TelaProdutoLista theView) {
        this.theView = theView;
        theView.addBtnAdicionaProdutoListener(new RedirecionaParaTelaProduto());
        theView.addBtnAtualizaListaListener(new ListaProduto());
        //theView.addClicaProdutoListener();
        theView.setVisible(true);
    }
    
    
    // para a ação do botão atualizar  lista
    class ListaProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ProdutoDAO dao = new ProdutoDAO();
                TableModelProdutos modelo = new TableModelProdutos(dao.consultaProduto(produto));
                theView.getTabela().setModel(modelo);
                theView.getTabela().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ListaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    //para a ação de mostrar PopUpMenu ou redirecionar para TelaProduto
    class AbrePaginaProduto implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
    class RedirecionaParaTelaProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TelaProduto telaProduto = new TelaProduto();
            new AdicionaProdutoController(telaProduto);
            telaProduto.setLocationRelativeTo(null);
            telaProduto.setVisible(true);
        }
        
    }
}
