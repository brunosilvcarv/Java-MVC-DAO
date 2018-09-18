/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaCompra;
import view.TelaProdutoLista;

/**
 *
 * @author Aluno
 */
public class AreaCompraController extends ListaProdutoController{
    
    
    TelaCompra view;
    public AreaCompraController(TelaCompra theView) {
        this.view = theView;
        view.addBtnAdicionarListener(new AcaoBotaoAdicionar());
        view.addBtnCalculaListener(new AcaoBotaoAdicionar());
        view.addBtnLimparListener(new AcaoBotaoLimpar());
        view.addBtnMinhasComprasListener(new AcaoBotaoMinhasCompras());
        
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
}
