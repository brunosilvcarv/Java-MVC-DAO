/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
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
        theView.addClicaProdutoListener(new AbrePaginaProduto());
        theView.addBtnVoltarListener(new VoltaTelaInicial());
        theView.setVisible(true);
    }
    
    public void carregaTabela() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        TableModelProdutos modelo = new TableModelProdutos(dao.consultaProduto(produto));
        theView.getTabela().setModel(modelo);
        theView.getTabela().setVisible(true);
    } 
    
    
    // para a ação do botão atualizar  lista
    class ListaProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                carregaTabela();
                
            } catch (SQLException ex) {
                Logger.getLogger(ListaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    //para a ação de mostrar PopUpMenu ou redirecionar para TelaProduto
    class AbrePaginaProduto implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("oi");
                theView.getMenuItemExcluir().setText("Excluir");
                theView.getMenuItemAlterar().setText("Alterar");
                theView.getPopupMenu().show(theView, e.getX(), e.getY());
            System.out.println(theView.getTabela().getSelectionModel());
                
                
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
    
    class VoltaTelaInicial implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
        }
        
    }
    
}
