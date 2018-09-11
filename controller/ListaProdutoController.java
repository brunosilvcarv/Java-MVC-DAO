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
    int linha;
    
    public ListaProdutoController(TelaProdutoLista theView) {
        this.theView = theView;
        theView.addBtnAdicionaProdutoListener(new RedirecionaParaTelaProduto());
        theView.addBtnAtualizaListaListener(new ListaProduto());
        theView.addClicaProdutoListener(new AcaoMenuItens());
        theView.addBtnVoltarListener(new VoltaTelaInicial());
        theView.addAcaoMenuItemExcluir(new AcaoMenuItemExcluir());
        theView.addAcaoMenuItemAlterar(new AcaoMenuItemAlterar());
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
    class AcaoMenuItens implements MouseListener {
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
            System.out.println("tabela clicada");
                theView.getMenuItemExcluir().setText("Excluir");
                theView.getMenuItemAlterar().setText("Alterar");
                theView.getPopupMenu().show(theView, e.getX(), e.getY());
            linha = theView.getTabela().getSelectedRow();
            System.out.println("linha: "+linha);
            
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
    
    class AcaoMenuItemExcluir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("excluir pressionado");
        }
        
    }
    
    class AcaoMenuItemAlterar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("alterar pressionado");
            
        }
        
    }
   
    
}
